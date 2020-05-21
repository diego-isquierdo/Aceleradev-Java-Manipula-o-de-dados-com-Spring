package com.challenge.repository;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface SubmissionRepository extends JpaRepository<Submission, SubmissionId> {

    @Query("select max(su.score) from Submission su where su.id.challenge.id = ?1")
    Optional<Float> findHigherScoreByChallengeId(Long challengeId);

    @Query("select su from Submission su join su.id.challenge ch join ch.accelerations a where ch.id = ?1 AND a.id = ?2")
    List<Submission> findAllByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId);

}