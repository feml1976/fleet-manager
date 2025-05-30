package com.group.requests.msvc_artifact_requests.repositories;

import com.group.requests.msvc_artifact_requests.models.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRequestRepository extends JpaRepository<Request, Long>, JpaSpecificationExecutor<Request> {
    List<Request> findByRequest(Long request);

    @Query("SELECT r FROM Request r WHERE r.activate IS NOT NULL")
    List<Request> findByActivateTrue();

    @Query("SELECT r FROM Request r WHERE r.activate IS NULL")
    List<Request> findByActivateFalse();

    @Query("SELECT r FROM Request r WHERE r.assign IS NOT NULL")
    List<Request> findByAssignTrue();

    @Query("SELECT r FROM Request r WHERE r.assign IS NULL")
    List<Request> findByAssignFalse();

    @Query("SELECT r FROM Request r WHERE r.create IS NOT NULL")
    List<Request> findByCreateTrue();

    @Query("SELECT r FROM Request r WHERE r.create IS NULL")
    List<Request> findByCreateFalse();

    @Query("SELECT r FROM Request r WHERE r.finish IS NOT NULL")
    List<Request> findByFinishTrue();

    @Query("SELECT r FROM Request r WHERE r.finish IS NULL")
    List<Request> findByFinishFalse();

    @Query("SELECT r FROM Request r WHERE r.cancel IS NOT NULL")
    List<Request> findByCancelTrue();

    @Query("SELECT r FROM Request r WHERE r.cancel IS NULL")
    List<Request> findByCancelFalse();
}
