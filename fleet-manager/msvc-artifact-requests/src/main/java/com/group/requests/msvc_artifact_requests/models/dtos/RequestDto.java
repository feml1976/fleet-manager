package com.group.requests.msvc_artifact_requests.models.dtos;

import java.time.OffsetDateTime;
import java.util.Map;

public class RequestDto {
    private Long id;

    private Long request;

    private Map<String, Object> create;

    private Map<String, Object> assign;

    private Map<String, Object> activate;

    private Map<String, Object> update;

    private Map<String, Object> finish;

    private Map<String, Object> cancel;

    private OffsetDateTime createAt;

    private OffsetDateTime updateAt;

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
}
