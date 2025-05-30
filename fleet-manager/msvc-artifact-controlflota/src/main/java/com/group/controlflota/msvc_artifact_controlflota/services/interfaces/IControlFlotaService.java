package com.group.controlflota.msvc_artifact_controlflota.services.interfaces;

import com.group.controlflota.msvc_artifact_controlflota.models.dtos.ControlFlotaDto;
import org.springframework.data.domain.*;

import java.util.*;
public interface IControlFlotaService {
    ControlFlotaDto create(ControlFlotaDto entity);
    ControlFlotaDto findById(Long id);
    List<ControlFlotaDto> findByRequest(Long request);
    List<ControlFlotaDto> findAll();
    Page<ControlFlotaDto> findAll(Pageable pageable);
    ControlFlotaDto update(Long id, ControlFlotaDto entity);
    ControlFlotaDto partialUpdate(Long id, ControlFlotaDto entity);
    void delete(Long id);
    /*
    List<ControlFlotaDto> findByActivate(boolean estate);
    List<ControlFlotaDto> findByAssign(boolean estate);
    List<ControlFlotaDto> findByCreate(boolean estate);
    List<ControlFlotaDto> findByFinish(boolean estate);
    List<ControlFlotaDto> findByCancel(boolean estate);
     */
    List<ControlFlotaDto> findByEstado(long idmetodo, String estado);
}
