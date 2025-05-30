package com.msvc.detcontrolflota.msvc.artifact_detcontrolflota.repositories;

import com.msvc.detcontrolflota.msvc.artifact_detcontrolflota.models.entities.DetControlFlota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IDetControlFlotaRepository extends JpaRepository<DetControlFlota, Long>, JpaSpecificationExecutor<DetControlFlota> {
    List<DetControlFlota> findByRequest(Long request);
    @Query("SELECT cf FROM DetControlFlota cf WHERE cf.idMetodo = :idmetodo AND cf.estado = :estado")
    List<DetControlFlota> findByEstado(@Param("idmetodo") long idmetodo, @Param("estado") String estado);
}
