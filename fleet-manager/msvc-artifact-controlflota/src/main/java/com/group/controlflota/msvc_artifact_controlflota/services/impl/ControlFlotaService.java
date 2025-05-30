package com.group.controlflota.msvc_artifact_controlflota.services.impl;

import com.group.controlflota.msvc_artifact_controlflota.models.dtos.ControlFlotaDto;
import com.group.controlflota.msvc_artifact_controlflota.models.entities.ControlFlota;
import com.group.controlflota.msvc_artifact_controlflota.repositories.IControlFlotaRepository;
import com.group.controlflota.msvc_artifact_controlflota.services.interfaces.IControlFlotaService;
import com.group.controlflota.msvc_artifact_controlflota.services.mapper.IControlFlotaMapper;
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
public class ControlFlotaService implements IControlFlotaService {


    private static final Logger logger = LoggerFactory.getLogger(ControlFlotaService.class);

    @Autowired
    private IControlFlotaMapper requestMapper;

    @Autowired
    private IControlFlotaRepository _Repository;


    @Override
    public ControlFlotaDto create(ControlFlotaDto entityDto) {
        ControlFlota entity = requestMapper.toEntity(entityDto);
        entity.setCreateAt(OffsetDateTime.now());
        entity.setUpdateAt(OffsetDateTime.now());

        ControlFlota savedEntity = _Repository.save(entity);
        return requestMapper.toDTO(savedEntity);

    }

    @Override
    @Transactional(readOnly = true)
    public ControlFlotaDto findById(Long id) {
        Optional<ControlFlota> entity = _Repository.findById(id);
        return entity.map(requestMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Request not found with id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ControlFlotaDto> findByRequest(Long request) {
        List<ControlFlota> requestEntities = _Repository.findByRequest(request);
        return requestEntities.stream()
                .map(requestMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ControlFlotaDto> findAll() {
        List<ControlFlota> requestEntities = _Repository.findAll();
        return requestEntities.stream()
                .map(requestMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ControlFlotaDto> findAll(Pageable pageable) {
        Page<ControlFlota> requestEntities = _Repository.findAll(pageable);
        return requestEntities.map(requestMapper::toDTO);
    }

    @Override
    public ControlFlotaDto update(Long id, ControlFlotaDto entity) {
        Optional<ControlFlota> existingEntity = _Repository.findById(id);
        if (existingEntity.isPresent()) {
            ControlFlota requestEntity = existingEntity.get();
            requestMapper.updateEntityFromDTO(entity, requestEntity);
            requestEntity.setUpdateAt(OffsetDateTime.now());

            ControlFlota updatedEntity = _Repository.save(requestEntity);
            return requestMapper.toDTO(updatedEntity);
        } else {
            throw new EntityNotFoundException("Request not found with id: " + id);
        }
    }

    @Override
    public ControlFlotaDto partialUpdate(Long id, ControlFlotaDto entityDto) {
        Optional<ControlFlota> existingEntity = _Repository.findById(id);
        if (existingEntity.isPresent()) {
            ControlFlota entity = existingEntity.get();

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

            ControlFlota updatedEntity = _Repository.save(entity);
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
/*
    // Métodos simplificados usando el campo 'estado' existente
    @Override
    @Transactional(readOnly = true)
    public List<ControlFlotaDto> findByActivate(boolean estate) {
        List<ControlFlota> entities = estate ?
                _Repository.findByEstado(4,estate) :
                _Repository.findByEstado(4,estate);

        return entities.stream()
                .map(requestMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ControlFlotaDto> findByAssign(boolean estate) {
        List<ControlFlota> entities = estate ?
                _Repository.findByEstado(3,estate) :
                _Repository.findByEstado(3,estate);

        return entities.stream()
                .map(requestMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ControlFlotaDto> findByCreate(boolean estate) {
        List<ControlFlota> entities = estate ?
                _Repository.findByEstado(2,estate) :
                _Repository.findByEstado(2,estate);

        return entities.stream()
                .map(requestMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ControlFlotaDto> findByFinish(boolean estate) {
        List<ControlFlota> entities = estate ?
                _Repository.findByEstado(6,estate) :
                _Repository.findByEstado(6,estate);

        return entities.stream()
                .map(requestMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ControlFlotaDto> findByCancel(boolean estate) {
        List<ControlFlota> entities = estate ?
                _Repository.findByEstado(7,estate) :
                _Repository.findByEstado(7,estate);

        return entities.stream()
                .map(requestMapper::toDTO)
                .collect(Collectors.toList());
    }

 */
    @Override
    @Transactional(readOnly = true)
    public List<ControlFlotaDto> findByEstado(long idmetodo, String estado) {
        List<ControlFlota> entities = _Repository.findByEstado(idmetodo, estado);

        return entities.stream()
                .map(requestMapper::toDTO)
                .collect(Collectors.toList());
    }
}
