package com.msvc.detcontrolflota.msvc.artifact_detcontrolflota.models.dtos;

import jakarta.persistence.Column;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.OffsetDateTime;
import java.util.Map;

public class DetControlFlotaDto {

    private Long id;

    private Long controlFlotaId;

    private Long request;

    private String manifiesto;

    private Long idMetodo;

    private String metodo;

    private String estado;

    private Long travelId;

    private Map<String, Object> jsonenviado;

    private Map<String, Object> jsonrecibido;

    private String observaciones;

    private Integer state = 1;

    private OffsetDateTime createAt;

    private OffsetDateTime updateAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getControlFlotaId() {
        return controlFlotaId;
    }

    public void setControlFlotaId(Long controlFlotaId) {
        this.controlFlotaId = controlFlotaId;
    }

    public Long getRequest() {
        return request;
    }

    public void setRequest(Long request) {
        this.request = request;
    }

    public String getManifiesto() {
        return manifiesto;
    }

    public void setManifiesto(String manifiesto) {
        this.manifiesto = manifiesto;
    }

    public Long getIdMetodo() {
        return idMetodo;
    }

    public void setIdMetodo(Long idMetodo) {
        this.idMetodo = idMetodo;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getTravelId() {
        return travelId;
    }

    public void setTravelId(Long travelId) {
        this.travelId = travelId;
    }

    public Map<String, Object> getJsonenviado() {
        return jsonenviado;
    }

    public void setJsonenviado(Map<String, Object> jsonenviado) {
        this.jsonenviado = jsonenviado;
    }

    public Map<String, Object> getJsonrecibido() {
        return jsonrecibido;
    }

    public void setJsonrecibido(Map<String, Object> jsonrecibido) {
        this.jsonrecibido = jsonrecibido;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public OffsetDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(OffsetDateTime createAt) {
        this.createAt = createAt;
    }

    public OffsetDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(OffsetDateTime updateAt) {
        this.updateAt = updateAt;
    }
}
