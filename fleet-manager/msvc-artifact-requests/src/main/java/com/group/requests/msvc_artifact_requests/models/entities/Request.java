package com.group.requests.msvc_artifact_requests.models.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.OffsetDateTime;
import java.util.Map;
import java.util.Objects;

@Entity
@Table(name = "request")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "request")
    private Long request;

    @Column(name = "\"create\"", columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> create;

    @Column(name = "assign", columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> assign;

    @Column(name = "activate", columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> activate;

    @Column(name = "\"update\"", columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> update;

    @Column(name = "finish", columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> finish;

    @Column(name = "cancel", columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> cancel;

    @CreationTimestamp
    @Column(name = "create_at", updatable = false)
    private OffsetDateTime createAt;

    @UpdateTimestamp
    @Column(name = "update_at")
    private OffsetDateTime updateAt;

    // Constructor vacío
    public Request() {
    }

    // Constructor con parámetros
    public Request(Long request, Map<String, Object> create, Map<String, Object> assign, Map<String, Object> activate,
                   Map<String, Object> update, Map<String, Object> finish, Map<String, Object> cancel) {
        this.request = request;
        this.create = create;
        this.assign = assign;
        this.activate = activate;
        this.update = update;
        this.finish = finish;
        this.cancel = cancel;
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

    public Map<String, Object> getCreate() {
        return create;
    }

    public void setCreate(Map<String, Object> create) {
        this.create = create;
    }

    public Map<String, Object> getAssign() {
        return assign;
    }

    public void setAssign(Map<String, Object> assign) {
        this.assign = assign;
    }

    public Map<String, Object> getActivate() {
        return activate;
    }

    public void setActivate(Map<String, Object> activate) {
        this.activate = activate;
    }

    public Map<String, Object> getUpdate() {
        return update;
    }

    public void setUpdate(Map<String, Object> update) {
        this.update = update;
    }

    public Map<String, Object> getFinish() {
        return finish;
    }

    public void setFinish(Map<String, Object> finish) {
        this.finish = finish;
    }

    public Map<String, Object> getCancel() {
        return cancel;
    }

    public void setCancel(Map<String, Object> cancel) {
        this.cancel = cancel;
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
        Request that = (Request) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(request, that.request) &&
                Objects.equals(create, that.create) &&
                Objects.equals(assign, that.assign) &&
                Objects.equals(activate, that.activate) &&
                Objects.equals(update, that.update) &&
                Objects.equals(finish, that.finish) &&
                Objects.equals(cancel, that.cancel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, request, create, assign, activate, update, finish, cancel);
    }

    // toString
    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", request=" + request +
                ", create=" + create +
                ", assign=" + assign +
                ", activate=" + activate +
                ", update=" + update +
                ", finish=" + finish +
                ", cancel=" + cancel +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
