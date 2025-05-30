package com.group.requests.msvc_artifact_requests.services.interfaces;

import com.group.requests.msvc_artifact_requests.models.dtos.RequestDto;
import org.springframework.data.domain.*;

import java.util.*;

public interface IRequestService {
    RequestDto create(RequestDto requestDTO);
    RequestDto findById(Long id);
    List<RequestDto> findByRequest(Long request);
    List<RequestDto> findAll();
    Page<RequestDto> findAll(Pageable pageable);
    RequestDto update(Long id, RequestDto requestDTO);
    RequestDto partialUpdate(Long id, RequestDto requestDTO);
    void delete(Long id);
    List<RequestDto> findByActivate(boolean activate);
    List<RequestDto> findByAssign(boolean assign);
    List<RequestDto> findByCreate(boolean create);
    List<RequestDto> findByFinish(boolean finish);
    List<RequestDto> findByCancel(boolean cancel);
}
