package com.group.controlflota.msvc_artifact_controlflota.models.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.OffsetDateTime;
import java.util.Map;
import java.util.Objects;

@Entity
@Table(name = "control_flota")
public class ControlFlota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    public ControlFlota() {
    }

    // Constructor con parámetros
    public ControlFlota(Long request, String manifiesto, Long idMetodo,String metodo,
                        String estado,Long travelId, String observaciones ) {
        this.request = request;
        this.manifiesto = manifiesto;
        this.idMetodo = idMetodo;
        this.metodo = metodo;
        this.estado = estado;
        this.travelId = travelId;
        this.observaciones = observaciones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        ControlFlota that = (ControlFlota) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(request, that.request) &&
                Objects.equals(manifiesto, that.manifiesto) &&
                Objects.equals(idMetodo, that.idMetodo) &&
                Objects.equals(metodo, that.metodo) &&
                Objects.equals(estado, that.estado) &&
                Objects.equals(travelId, that.travelId) &&
                Objects.equals(observaciones, that.observaciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, request, manifiesto, idMetodo, metodo, estado, travelId,  observaciones);
    }

    // toString
    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", request=" + request +
                ", manifiesto=" + manifiesto +
                ", idMetodo=" + idMetodo +
                ", metodo=" + metodo +
                ", estado=" + estado +
                ", travelId=" + travelId +
                ", observaciones=" + observaciones +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
