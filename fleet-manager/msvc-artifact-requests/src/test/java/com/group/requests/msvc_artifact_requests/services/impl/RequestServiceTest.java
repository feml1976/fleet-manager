package com.group.requests.msvc_artifact_requests.services.impl;

import com.group.requests.msvc_artifact_requests.models.dtos.RequestDto;
import com.group.requests.msvc_artifact_requests.models.entities.Request;
import com.group.requests.msvc_artifact_requests.repositories.IRequestRepository;
import com.group.requests.msvc_artifact_requests.services.mapper.RequestMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RequestServiceTest {

    @Mock
    private IRequestRepository requestRepository;

    @Mock
    private RequestMapper requestMapper;

    @InjectMocks
    private RequestService requestService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreate() {
        RequestDto dto = new RequestDto();
        Request entity = new Request();

        when(requestMapper.toEntity(dto)).thenReturn(entity);
        when(requestRepository.save(entity)).thenReturn(entity);
        when(requestMapper.toDTO(entity)).thenReturn(dto);

        RequestDto result = requestService.create(dto);
        assertNotNull(result);
        verify(requestRepository).save(entity);
    }

    @Test
    void testFindById_Exists() {
        Long id = 1L;
        Request entity = new Request();
        RequestDto dto = new RequestDto();

        when(requestRepository.findById(id)).thenReturn(Optional.of(entity));
        when(requestMapper.toDTO(entity)).thenReturn(dto);

        RequestDto result = requestService.findById(id);
        assertNotNull(result);
    }

    @Test
    void testFindById_NotFound() {
        Long id = 1L;
        when(requestRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> requestService.findById(id));
    }

    @Test
    void testDelete_WhenExists() {
        Long id = 1L;
        when(requestRepository.existsById(id)).thenReturn(true);
        requestService.delete(id);
        verify(requestRepository).deleteById(id);
    }

    @Test
    void testDelete_WhenNotFound() {
        Long id = 1L;
        when(requestRepository.existsById(id)).thenReturn(false);
        assertThrows(EntityNotFoundException.class, () -> requestService.delete(id));
    }
}
