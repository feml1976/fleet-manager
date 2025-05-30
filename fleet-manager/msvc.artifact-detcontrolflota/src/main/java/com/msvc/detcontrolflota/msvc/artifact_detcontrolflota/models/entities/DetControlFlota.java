package com.msvc.detcontrolflota.msvc.artifact_detcontrolflota.models.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.OffsetDateTime;
import java.util.Map;
import java.util.Objects;

@Entity
@Table(name = "det_control_flota")
public class DetControlFlota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "controlflotaid")
    private Long controlFlotaId;

    @Column(name = "request")
    private Long request;

    @Column(name = "manifiesto")
    private String manifiesto;

    @Column(name = "idmetodo")
    private Long idMetodo;

    @Column(name = "metodo")
    private String metodo;

    @Column(name = "estado")
    private String estado;

    @Column(name = "travelid")
    private Long travelId;

    @Column(name = "jsonenviado", columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> jsonenviado;

    @Column(name = "jsonrecibido", columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> jsonrecibido;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "state")
    private Integer state = 1;

    @CreationTimestamp
    @Column(name = "create_at", updatable = false)
    private OffsetDateTime createAt;

    @UpdateTimestamp
    @Column(name = "update_at")
    private OffsetDateTime updateAt;

    // Constructor vacío
    public DetControlFlota() {
    }

    // Constructor con parámetros
    public DetControlFlota(Long controlFlotaId, Long request, String manifiesto, Long idMetodo,String metodo,
                        String estado,Long travelId, Map<String, Object> jsonenviado, Map<String, Object> jsonrecibido,String observaciones ) {
        this.controlFlotaId = controlFlotaId;
        this.request = request;
        this.manifiesto = manifiesto;
        this.idMetodo = idMetodo;
        this.metodo = metodo;
        this.estado = estado;
        this.travelId = travelId;
        this.jsonenviado = jsonenviado;
        this.jsonrecibido = jsonrecibido;
        this.observaciones = observaciones;
    }

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

    // Métodos de auditoría automática
    @PrePersist
    protected void onCreate() {
        createAt = OffsetDateTime.now();
        updateAt = OffsetDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updateAt = OffsetDateTime.now();
    }

    // equals y hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetControlFlota that = (DetControlFlota) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(controlFlotaId, that.controlFlotaId) &&
                Objects.equals(request, that.request) &&
                Objects.equals(manifiesto, that.manifiesto) &&
                Objects.equals(idMetodo, that.idMetodo) &&
                Objects.equals(metodo, that.metodo) &&
                Objects.equals(estado, that.estado) &&
                Objects.equals(travelId, that.travelId) &&
                Objects.equals(jsonenviado, that.jsonenviado) &&
                Objects.equals(jsonrecibido, that.jsonrecibido) &&
                Objects.equals(observaciones, that.observaciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, controlFlotaId, request, manifiesto, idMetodo, jsonenviado, jsonrecibido, estado, travelId,  observaciones);
    }

    // toString
    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", controlFlotaId=" + controlFlotaId +
                ", request=" + request +
                ", manifiesto=" + manifiesto +
                ", idMetodo=" + idMetodo +
                ", metodo=" + metodo +
                ", estado=" + estado +
                ", travelId=" + travelId +
                ", jsonenviado=" + jsonenviado +
                ", jsonrecibido=" + jsonrecibido +
                ", observaciones=" + observaciones +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
