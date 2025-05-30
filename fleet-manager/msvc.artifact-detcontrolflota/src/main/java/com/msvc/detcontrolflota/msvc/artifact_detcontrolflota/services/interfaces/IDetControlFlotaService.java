package com.msvc.detcontrolflota.msvc.artifact_detcontrolflota.services.interfaces;

import com.msvc.detcontrolflota.msvc.artifact_detcontrolflota.models.dtos.DetControlFlotaDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDetControlFlotaService {
    DetControlFlotaDto create(DetControlFlotaDto entity);
    DetControlFlotaDto findById(Long id);
    List<DetControlFlotaDto> findByRequest(Long request);
    List<DetControlFlotaDto> findAll();
    Page<DetControlFlotaDto> findAll(Pageable pageable);
    DetControlFlotaDto update(Long id, DetControlFlotaDto entity);
    DetControlFlotaDto partialUpdate(Long id, DetControlFlotaDto entity);
    void delete(Long id);
    List<DetControlFlotaDto> findByEstado(long idmetodo, String estado);
}
