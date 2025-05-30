package com.group.requests.msvc_artifact_requests.services.impl;

import com.group.requests.msvc_artifact_requests.models.dtos.RequestDto;
import com.group.requests.msvc_artifact_requests.models.entities.Request;
import com.group.requests.msvc_artifact_requests.repositories.IRequestRepository;
import com.group.requests.msvc_artifact_requests.services.interfaces.IRequestService;
import com.group.requests.msvc_artifact_requests.services.mapper.RequestMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import jakarta.persistence.criteria.Predicate;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional
public class RequestService implements IRequestService {

    private static final Logger logger = LoggerFactory.getLogger(RequestService.class);

    @Autowired
    private RequestMapper requestMapper;

    @Autowired
    private IRequestRepository requestRepository;

    @Override
    public RequestDto create(RequestDto requestDTO) {
        Request requestEntity = requestMapper.toEntity(requestDTO);
        requestEntity.setCreateAt(OffsetDateTime.now());
        requestEntity.setUpdateAt(OffsetDateTime.now());

        Request savedEntity = requestRepository.save(requestEntity);
        return requestMapper.toDTO(savedEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public RequestDto findById(Long id) {
        Optional<Request> requestEntity = requestRepository.findById(id);
        return requestEntity.map(requestMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Request not found with id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<RequestDto> findByRequest(Long request) {
        List<Request> requestEntities = requestRepository.findByRequest(request);
        return requestEntities.stream()
                .map(requestMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<RequestDto> findAll() {
        List<Request> requestEntities = requestRepository.findAll();
        return requestEntities.stream()
                .map(requestMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<RequestDto> findAll(Pageable pageable) {
        Page<Request> requestEntities = requestRepository.findAll(pageable);
        return requestEntities.map(requestMapper::toDTO);
    }

    @Override
    public RequestDto update(Long id, RequestDto requestDTO) {
        Optional<Request> existingEntity = requestRepository.findById(id);
        if (existingEntity.isPresent()) {
            Request requestEntity = existingEntity.get();
            requestMapper.updateEntityFromDTO(requestDTO, requestEntity);
            requestEntity.setUpdateAt(OffsetDateTime.now());

            Request updatedEntity = requestRepository.save(requestEntity);
            return requestMapper.toDTO(updatedEntity);
        } else {
            throw new EntityNotFoundException("Request not found with id: " + id);
        }
    }

    @Override
    public RequestDto partialUpdate(Long id, RequestDto requestDTO) {
        Optional<Request> existingEntity = requestRepository.findById(id);
        if (existingEntity.isPresent()) {
            Request requestEntity = existingEntity.get();

            // Solo actualizar campos no nulos del DTO
            if (requestDTO.getRequest() != null) {
                requestEntity.setRequest(requestDTO.getRequest());
            }
            if (requestDTO.getCreate() != null) {
                requestEntity.setCreate(requestDTO.getCreate());
            }
            if (requestDTO.getAssign() != null) {
                requestEntity.setAssign(requestDTO.getAssign());
            }
            if (requestDTO.getActivate() != null) {
                requestEntity.setActivate(requestDTO.getActivate());
            }
            if (requestDTO.getUpdate() != null) {
                requestEntity.setUpdate(requestDTO.getUpdate());
            }
            if (requestDTO.getFinish() != null) {
                requestEntity.setFinish(requestDTO.getFinish());
            }
            if (requestDTO.getCancel() != null) {
                requestEntity.setCancel(requestDTO.getCancel());
            }

            requestEntity.setUpdateAt(OffsetDateTime.now());

            Request updatedEntity = requestRepository.save(requestEntity);
            return requestMapper.toDTO(updatedEntity);
        } else {
            throw new EntityNotFoundException("Request not found with id: " + id);
        }
    }

    @Override
    public void delete(Long id) {
        if (requestRepository.existsById(id)) {
            requestRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Request not found with id: " + id);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<RequestDto> findByActivate(boolean activate) {
        List<Request> requestEntities = activate ?
                requestRepository.findByActivateTrue() :
                requestRepository.findByActivateFalse();

        return requestEntities.stream()
                .map(requestMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<RequestDto> findByAssign(boolean assign) {
        List<Request> requestEntities = assign ?
                requestRepository.findByAssignTrue() :
                requestRepository.findByAssignFalse();

        return requestEntities.stream()
                .map(requestMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<RequestDto> findByCreate(boolean create) {
        List<Request> requestEntities = create ?
                requestRepository.findByCreateTrue() :
                requestRepository.findByCreateFalse();

        return requestEntities.stream()
                .map(requestMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<RequestDto> findByFinish(boolean finish) {
        List<Request> requestEntities = finish ?
                requestRepository.findByFinishTrue() :
                requestRepository.findByFinishFalse();

        return requestEntities.stream()
                .map(requestMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<RequestDto> findByCancel(boolean cancel) {
        List<Request> requestEntities = cancel ?
                requestRepository.findByCancelTrue() :
                requestRepository.findByCancelFalse();

        return requestEntities.stream()
                .map(requestMapper::toDTO)
                .collect(Collectors.toList());
    }
}
