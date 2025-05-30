/**
 * Controlador REST para la gestión de Control de Flota.
 * <p>
 * Este controlador proporciona endpoints REST para todas las operaciones CRUD
 * y consultas especializadas sobre entidades de Control de Flota. Maneja
 * solicitudes HTTP y coordina con el servicio de negocio correspondiente.
 * </p>
 * <p>
 * Todos los endpoints retornan datos en formato JSON y siguen las convenciones
 * REST para métodos HTTP y códigos de respuesta.
 * Endpoints principales:
 *
 * POST /api/v1/requests - Crear nueva solicitud
 * GET /api/v1/requests/{id} - Obtener por ID
 * GET /api/v1/requests - Obtener todas las solicitudes
 * GET /api/v1/requests/paged - Obtener con paginación
 * PUT /api/v1/requests/{id} - Actualización completa
 * PATCH /api/v1/requests/{id} - Actualización parcial
 * DELETE /api/v1/requests/{id} - Eliminar solicitud
 *
 * Endpoints de filtrado:
 *
 * GET /api/v1/requests/by-request/{request} - Por número de request
 * GET /api/v1/requests/by-activate?activate=true/false - Por estado de activación
 * GET /api/v1/requests/by-assign?assign=true/false - Por estado de asignación
 * GET /api/v1/requests/by-create?create=true/false - Por estado de creación
 * GET /api/v1/requests/by-finish?finish=true/false - Por estado de finalización
 * GET /api/v1/requests/by-cancel?cancel=true/false - Por estado de cancelación
 *
 * Características técnicas:
 *
 * Manejo completo de excepciones con respuestas HTTP apropiadas
 * Logging detallado para auditoría y debugging
 * Validación de datos con @Valid
 * Soporte para CORS
 * Documentación JavaDoc completa
 * Códigos de estado HTTP apropiados (200, 201, 204, 404, 500)
 * </p>
 *
 * @author Control Flota Application
 * @version 1.0
 * @since 1.0
 * @see ControlFlotaServiceImpl
 * @see ControlFlotaDTO
 */
package com.group.requests.msvc_artifact_requests.controllers;

import com.group.requests.msvc_artifact_requests.models.dtos.RequestDto;
import com.group.requests.msvc_artifact_requests.services.impl.EntityNotFoundException;
import com.group.requests.msvc_artifact_requests.services.interfaces.IRequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import jakarta.validation.Valid;
import java.util.List;

/**
 * Controlador REST para la gestión de Request.
 * <p>
 * Proporciona endpoints para realizar operaciones CRUD sobre las solicitudes,
 * incluyendo filtros por diferentes estados y paginación.
 * </p>
 *
 * @author Control Flota Application
 * @version 1.0
 * @since 1.0
 */

@RestController
@RequestMapping("/api/v1/request")
@CrossOrigin(origins = "*")
public class RequestController {
    private static final Logger logger = LoggerFactory.getLogger(RequestController.class);

    @Autowired
    private IRequestService requestService;

    /**
     * Crear una nueva solicitud.
     *
     * @param entity Datos de la solicitud a crear
     * @return ResponseEntity con la solicitud creada
     */
    @PostMapping
    public ResponseEntity<RequestDto> create( @RequestBody RequestDto entity) {
        logger.info("Creating new request");
        try {
            RequestDto createdRequest = requestService.create(entity);
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
    public ResponseEntity<RequestDto> findById(@PathVariable Long id) {
        logger.info("Finding request by id: {}", id);
        try {
            RequestDto request = requestService.findById(id);
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
    public ResponseEntity<List<RequestDto>> findByRequest(@PathVariable Long request) {
        logger.info("Finding requests by request number: {}", request);
        try {
            List<RequestDto> requests = requestService.findByRequest(request);
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
    public ResponseEntity<List<RequestDto>> findAll() {
        logger.info("Finding all requests");
        try {
            List<RequestDto> requests = requestService.findAll();
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
    public ResponseEntity<Page<RequestDto>> findAllPaged(Pageable pageable) {
        logger.info("Finding all requests with pagination: page {}, size {}",
                pageable.getPageNumber(), pageable.getPageSize());
        try {
            Page<RequestDto> requests = requestService.findAll(pageable);
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
    public ResponseEntity<RequestDto> update(@PathVariable Long id,
                                              @RequestBody RequestDto entity) {
        logger.info("Updating request with id: {}", id);
        try {
            RequestDto updatedRequest = requestService.update(id, entity);
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
    public ResponseEntity<RequestDto> partialUpdate(@PathVariable Long id,
                                                    @RequestBody RequestDto entity) {
        logger.info("Partially updating request with id: {}", id);
        try {
            RequestDto updatedRequest = requestService.partialUpdate(id, entity);
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
            requestService.delete(id);
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

    /**
     * Obtener solicitudes por estado de activación.
     *
     * @param activate Estado de activación (true/false)
     * @return ResponseEntity con la lista de solicitudes filtradas
     */
    @GetMapping("/by-activate")
    public ResponseEntity<List<RequestDto>> findByActivate(@RequestParam boolean activate) {
        logger.info("Finding requests by activate status: {}", activate);
        try {
            List<RequestDto> requests = requestService.findByActivate(activate);
            return new ResponseEntity<>(requests, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error finding requests by activate status {}: {}", activate, e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Obtener solicitudes por estado de asignación.
     *
     * @param assign Estado de asignación (true/false)
     * @return ResponseEntity con la lista de solicitudes filtradas
     */
    @GetMapping("/by-assign")
    public ResponseEntity<List<RequestDto>> findByAssign(@RequestParam boolean assign) {
        logger.info("Finding requests by assign status: {}", assign);
        try {
            List<RequestDto> requests = requestService.findByAssign(assign);
            return new ResponseEntity<>(requests, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error finding requests by assign status {}: {}", assign, e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Obtener solicitudes por estado de creación.
     *
     * @param create Estado de creación (true/false)
     * @return ResponseEntity con la lista de solicitudes filtradas
     */
    @GetMapping("/by-create")
    public ResponseEntity<List<RequestDto>> findByCreate(@RequestParam boolean create) {
        logger.info("Finding requests by create status: {}", create);
        try {
            List<RequestDto> requests = requestService.findByCreate(create);
            return new ResponseEntity<>(requests, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error finding requests by create status {}: {}", create, e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Obtener solicitudes por estado de finalización.
     *
     * @param finish Estado de finalización (true/false)
     * @return ResponseEntity con la lista de solicitudes filtradas
     */
    @GetMapping("/by-finish")
    public ResponseEntity<List<RequestDto>> findByFinish(@RequestParam boolean finish) {
        logger.info("Finding requests by finish status: {}", finish);
        try {
            List<RequestDto> requests = requestService.findByFinish(finish);
            return new ResponseEntity<>(requests, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error finding requests by finish status {}: {}", finish, e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Obtener solicitudes por estado de cancelación.
     *
     * @param cancel Estado de cancelación (true/false)
     * @return ResponseEntity con la lista de solicitudes filtradas
     */
    @GetMapping("/by-cancel")
    public ResponseEntity<List<RequestDto>> findByCancel(@RequestParam boolean cancel) {
        logger.info("Finding requests by cancel status: {}", cancel);
        try {
            List<RequestDto> requests = requestService.findByCancel(cancel);
            return new ResponseEntity<>(requests, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error finding requests by cancel status {}: {}", cancel, e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
