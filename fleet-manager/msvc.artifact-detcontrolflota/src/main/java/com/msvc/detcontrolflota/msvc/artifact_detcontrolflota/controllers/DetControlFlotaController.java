package com.msvc.detcontrolflota.msvc.artifact_detcontrolflota.controllers;

import com.msvc.detcontrolflota.msvc.artifact_detcontrolflota.models.dtos.DetControlFlotaDto;
import com.msvc.detcontrolflota.msvc.artifact_detcontrolflota.services.impl.EntityNotFoundException;
import com.msvc.detcontrolflota.msvc.artifact_detcontrolflota.services.interfaces.IDetControlFlotaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/det-control-flota")
@CrossOrigin(origins = "*")
public class DetControlFlotaController {
    private static final Logger logger = LoggerFactory.getLogger(DetControlFlotaController.class);

    @Autowired
    private IDetControlFlotaService _Service;

    /**
     * Crear una nueva solicitud.
     *
     * @param entity Datos de la solicitud a crear
     * @return ResponseEntity con la solicitud creada
     */
    @PostMapping
    public ResponseEntity<DetControlFlotaDto> create(@RequestBody DetControlFlotaDto entity) {
        logger.info("Creating new request");
        try {
            DetControlFlotaDto createdRequest = _Service.create(entity);
            logger.info("Request created successfully with id: {}", createdRequest.getId());
            return new ResponseEntity<>(createdRequest, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error creating request: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Obtener una solicitud por su ID.
     *
     * @param id ID de la solicitud
     * @return ResponseEntity con la solicitud encontrada
     */
    @GetMapping("/{id}")
    public ResponseEntity<DetControlFlotaDto> findById(@PathVariable Long id) {
        logger.info("Finding request by id: {}", id);
        try {
            DetControlFlotaDto request = _Service.findById(id);
            return new ResponseEntity<>(request, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            logger.warn("Request not found with id: {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Error finding request by id {}: {}", id, e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Obtener solicitudes por número de request.
     *
     * @param request Número de request
     * @return ResponseEntity con la lista de solicitudes
     */
    @GetMapping("/by-request/{request}")
    public ResponseEntity<List<DetControlFlotaDto>> findByRequest(@PathVariable Long request) {
        logger.info("Finding requests by request number: {}", request);
        try {
            List<DetControlFlotaDto> requests = _Service.findByRequest(request);
            return new ResponseEntity<>(requests, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error finding requests by request number {}: {}", request, e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Obtener todas las solicitudes.
     *
     * @return ResponseEntity con la lista de todas las solicitudes
     */
    @GetMapping
    public ResponseEntity<List<DetControlFlotaDto>> findAll() {
        logger.info("Finding all requests");
        try {
            List<DetControlFlotaDto> requests = _Service.findAll();
            return new ResponseEntity<>(requests, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error finding all requests: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Obtener todas las solicitudes con paginación.
     *
     * @param pageable Información de paginación
     * @return ResponseEntity con la página de solicitudes
     */
    @GetMapping("/paged")
    public ResponseEntity<Page<DetControlFlotaDto>> findAllPaged(Pageable pageable) {
        logger.info("Finding all requests with pagination: page {}, size {}",
                pageable.getPageNumber(), pageable.getPageSize());
        try {
            Page<DetControlFlotaDto> requests = _Service.findAll(pageable);
            return new ResponseEntity<>(requests, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error finding paged requests: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Actualizar completamente una solicitud.
     *
     * @param id ID de la solicitud a actualizar
     * @param entity Nuevos datos de la solicitud
     * @return ResponseEntity con la solicitud actualizada
     */
    @PutMapping("/{id}")
    public ResponseEntity<DetControlFlotaDto> update(@PathVariable Long id,
                                                  @RequestBody DetControlFlotaDto entity) {
        logger.info("Updating request with id: {}", id);
        try {
            DetControlFlotaDto updatedRequest = _Service.update(id, entity);
            logger.info("Request updated successfully with id: {}", id);
            return new ResponseEntity<>(updatedRequest, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            logger.warn("Request not found for update with id: {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Error updating request with id {}: {}", id, e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Actualizar parcialmente una solicitud.
     *
     * @param id ID de la solicitud a actualizar
     * @param entity Datos parciales de la solicitud
     * @return ResponseEntity con la solicitud actualizada
     */
    @PatchMapping("/{id}")
    public ResponseEntity<DetControlFlotaDto> partialUpdate(@PathVariable Long id,
                                                         @RequestBody DetControlFlotaDto entity) {
        logger.info("Partially updating request with id: {}", id);
        try {
            DetControlFlotaDto updatedRequest = _Service.partialUpdate(id, entity);
            logger.info("Request partially updated successfully with id: {}", id);
            return new ResponseEntity<>(updatedRequest, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            logger.warn("Request not found for partial update with id: {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Error partially updating request with id {}: {}", id, e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Eliminar una solicitud.
     *
     * @param id ID de la solicitud a eliminar
     * @return ResponseEntity con estado de la operación
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        logger.info("Deleting request with id: {}", id);
        try {
            _Service.delete(id);
            logger.info("Request deleted successfully with id: {}", id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException e) {
            logger.warn("Request not found for deletion with id: {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Error deleting request with id {}: {}", id, e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{idmetodo}/{estado}")
    public ResponseEntity<List<DetControlFlotaDto>> findByEstado(@PathVariable Long idmetodo,
                                                              @PathVariable String estado) {
        logger.info("Finding requests by cancel status: {}", idmetodo);
        try {
            List<DetControlFlotaDto> requests = _Service.findByEstado(idmetodo,estado);
            return new ResponseEntity<>(requests, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error finding requests by cancel status {}: {}", idmetodo, e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
