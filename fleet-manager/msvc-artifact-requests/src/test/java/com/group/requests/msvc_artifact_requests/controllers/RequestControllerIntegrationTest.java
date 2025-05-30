package com.group.requests.msvc_artifact_requests.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.group.requests.msvc_artifact_requests.models.dtos.RequestDto;
import com.group.requests.msvc_artifact_requests.services.interfaces.IRequestService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class RequestControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IRequestService requestService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateRequest() throws Exception {
        RequestDto dto = new RequestDto();
        dto.setRequest(123L);

        when(requestService.create(any(RequestDto.class))).thenReturn(dto);

        mockMvc.perform(post("/api/v1/request")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated());
    }

    @Test
    void testFindById_NotFound() throws Exception {
        Long id = 1L;
        when(requestService.findById(id)).thenThrow(new com.group.requests.msvc_artifact_requests.services.impl.EntityNotFoundException("No existe"));

        mockMvc.perform(get("/api/v1/request/{id}", id))
                .andExpect(status().isNotFound());
    }

    @TestConfiguration
    static class TestConfig {
        @Bean
        public IRequestService requestService() {
            return Mockito.mock(IRequestService.class);
        }
    }
}
