package com.group.requests.msvc_artifact_requests.services.impl;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    /**
     * Constructor con mensaje personalizado
     */
    public EntityNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructor con mensaje y causa
     */
    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor con causa
     */
    public EntityNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor con mensaje, causa, y parámetros adicionales
     */
    public EntityNotFoundException(String message, Throwable cause,
                                   boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * Método de conveniencia para crear excepción con ID de entidad
     */
    public static EntityNotFoundException forId(String entityName, Long id) {
        return new EntityNotFoundException(
                String.format("%s not found with id: %d", entityName, id)
        );
    }

    /**
     * Método de conveniencia para crear excepción con campo y valor
     */
    public static EntityNotFoundException forField(String entityName, String fieldName, Object value) {
        return new EntityNotFoundException(
                String.format("%s not found with %s: %s", entityName, fieldName, value)
        );
    }

    /**
     * Método de conveniencia para Request específicamente
     */
    public static EntityNotFoundException forRequest(Long id) {
        return forId("Request", id);
    }
}
