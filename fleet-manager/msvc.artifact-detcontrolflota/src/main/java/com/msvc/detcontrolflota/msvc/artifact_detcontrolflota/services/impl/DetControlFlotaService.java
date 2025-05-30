package com.msvc.detcontrolflota.msvc.artifact_detcontrolflota.services.impl;


import com.msvc.detcontrolflota.msvc.artifact_detcontrolflota.models.dtos.DetControlFlotaDto;
import com.msvc.detcontrolflota.msvc.artifact_detcontrolflota.models.entities.DetControlFlota;
import com.msvc.detcontrolflota.msvc.artifact_detcontrolflota.repositories.IDetControlFlotaRepository;
import com.msvc.detcontrolflota.msvc.artifact_detcontrolflota.services.interfaces.IDetControlFlotaService;
import com.msvc.detcontrolflota.msvc.artifact_detcontrolflota.services.mapper.IDetControlFlotaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class DetControlFlotaService  implements IDetControlFlotaService {

    private static final Logger logger = LoggerFactory.getLogger(DetControlFlotaService.class);

    @Autowired
    private IDetControlFlotaMapper requestMapper;

    @Autowired
    private IDetControlFlotaRepository _Repository;


    @Override
    public DetControlFlotaDto create(DetControlFlotaDto entityDto) {
        DetControlFlota entity = requestMapper.toEntity(entityDto);
        entity.setCreateAt(OffsetDateTime.now());
        entity.setUpdateAt(OffsetDateTime.now());

        DetControlFlota savedEntity = _Repository.save(entity);
        return requestMapper.toDTO(savedEntity);

    }

    @Override
    @Transactional(readOnly = true)
    public DetControlFlotaDto findById(Long id) {
        Optional<DetControlFlota> entity = _Repository.findById(id);
        return entity.map(requestMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Request not found with id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<DetControlFlotaDto> findByRequest(Long request) {
        List<DetControlFlota> requestEntities = _Repository.findByRequest(request);
        return requestEntities.stream()
                .map(requestMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<DetControlFlotaDto> findAll() {
        List<DetControlFlota> requestEntities = _Repository.findAll();
        return requestEntities.stream()
                .map(requestMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DetControlFlotaDto> findAll(Pageable pageable) {
        Page<DetControlFlota> requestEntities = _Repository.findAll(pageable);
        return requestEntities.map(requestMapper::toDTO);
    }

    @Override
    public DetControlFlotaDto update(Long id, DetControlFlotaDto entity) {
        Optional<DetControlFlota> existingEntity = _Repository.findById(id);
        if (existingEntity.isPresent()) {
            DetControlFlota requestEntity = existingEntity.get();
            requestMapper.updateEntityFromDTO(entity, requestEntity);
            requestEntity.setUpdateAt(OffsetDateTime.now());

            DetControlFlota updatedEntity = _Repository.save(requestEntity);
            return requestMapper.toDTO(updatedEntity);
        } else {
            throw new EntityNotFoundException("Request not found with id: " + id);
        }
    }

    @Override
    public DetControlFlotaDto partialUpdate(Long id, DetControlFlotaDto entityDto) {
        Optional<DetControlFlota> existingEntity = _Repository.findById(id);
        if (existingEntity.isPresent()) {
            DetControlFlota entity = existingEntity.get();

            // Solo actualizar campos no nulos del DTO
            if (entityDto.getRequest() != null) {
                entity.setRequest(entityDto.getRequest());
            }
            if (entityDto.getManifiesto() != null) {
                entity.setManifiesto(entityDto.getManifiesto());
            }
            if (entityDto.getIdMetodo() != null) {
                entity.setIdMetodo(entityDto.getIdMetodo());
            }
            if (entityDto.getMetodo() != null) {
                entity.setMetodo(entityDto.getMetodo());
            }
            if (entityDto.getEstado() != null) {
                entity.setEstado(entityDto.getEstado());
            }
            if (entityDto.getTravelId() != null) {
                entity.setTravelId(entityDto.getTravelId());
            }
            if (entityDto.getObservaciones() != null) {
                entity.setObservaciones(entityDto.getObservaciones());
            }
            entity.setUpdateAt(OffsetDateTime.now());

            DetControlFlota updatedEntity = _Repository.save(entity);
            return requestMapper.toDTO(updatedEntity);
        } else {
            throw new EntityNotFoundException("Request not found with id: " + id);
        }
    }

    @Override
    public void delete(Long id) {
        if (_Repository.existsById(id)) {
            _Repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Request not found with id: " + id);
        }
    }
    @Override
    @Transactional(readOnly = true)
    public List<DetControlFlotaDto> findByEstado(long idmetodo, String estado) {
        List<DetControlFlota> entities = _Repository.findByEstado(idmetodo, estado);

        return entities.stream()
                .map(requestMapper::toDTO)
                .collect(Collectors.toList());
    }
}
