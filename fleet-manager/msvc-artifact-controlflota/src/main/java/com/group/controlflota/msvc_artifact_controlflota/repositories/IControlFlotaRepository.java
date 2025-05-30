package com.group.controlflota.msvc_artifact_controlflota.repositories;

import com.group.controlflota.msvc_artifact_controlflota.models.entities.ControlFlota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IControlFlotaRepository extends JpaRepository<ControlFlota, Long>, JpaSpecificationExecutor<ControlFlota> {
    List<ControlFlota> findByRequest(Long request);

    /*
    @Query("SELECT r FROM control_flota cf WHERE cf.idmetodo = 2 and cf.estado=false")
    List<ControlFlota> findByCreateEstadoTrue(long idmetodo);
    @Query("SELECT r FROM control_flota cf WHERE cf.idmetodo = 2 and cf.estado=false")
    List<ControlFlota> findByCreateEstadoFalse(long idmetodo);

    @Query("SELECT r FROM control_flota cf WHERE cf.idmetodo = 3 and cf.estado=false")
    List<ControlFlota> findByAssignEstadoTrue(long idmetodo);
    @Query("SELECT r FROM control_flota cf WHERE cf.idmetodo = 3 and cf.estado=false")
    List<ControlFlota> findByAssignEstadoFalse(long idmetodo);


    @Query("SELECT r FROM control_flota cf WHERE cf.idmetodo = 4 and cf.estado=false")
    List<ControlFlota> findByActivateEstadoTrue(long idmetodo);
    @Query("SELECT r FROM control_flota cf WHERE cf.idmetodo = 4 and cf.estado=false")
    List<ControlFlota> findByActivateEstadoFalse(long idmetodo);


    @Query("SELECT r FROM control_flota cf WHERE cf.idmetodo = 5 and cf.estado=false")
    List<ControlFlota> findByUpdateEstadoTrue(long idmetodo);
    @Query("SELECT r FROM control_flota cf WHERE cf.idmetodo = 5 and cf.estado=false")
    List<ControlFlota> findByUpdateEstadoFalse(long idmetodo);

    @Query("SELECT r FROM control_flota cf WHERE cf.idmetodo = 6 and cf.estado=false")
    List<ControlFlota> findByFinishEstadoTrue(long idmetodo);
    @Query("SELECT r FROM control_flota cf WHERE cf.idmetodo = 6 and cf.estado=false")
    List<ControlFlota> findByFinishEstadoFalse(long idmetodo);

    @Query("SELECT r FROM control_flota cf WHERE cf.idmetodo = 7 and cf.estado=false")
    List<ControlFlota> findByCancelEstadoTrue(long idmetodo);
    @Query("SELECT r FROM control_flota cf WHERE cf.idmetodo = 7 and cf.estado=false")
    List<ControlFlota> findByCancelEstadoFalse(long idmetodo);
*/
    //@Query("SELECT cf FROM control_flota cf WHERE cf.idmetodo = :idmetodo and cf.estado = :estado")
    @Query("SELECT cf FROM ControlFlota cf WHERE cf.idMetodo = :idmetodo AND cf.estado = :estado")
    List<ControlFlota> findByEstado(@Param("idmetodo") long idmetodo, @Param("estado") String estado);

}
