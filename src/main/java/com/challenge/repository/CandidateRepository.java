package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;


public interface CandidateRepository extends JpaRepository<Candidate, CandidateId> {

    @Query("FROM Candidate c WHERE c.id.user.id = ?1 AND c.id.company.id = ?2 AND c.id.acceleration.id = ?3")
    Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId);

    @Query("SELECT c FROM Candidate c WHERE c.id.company.id = ?1")
    List<Candidate> findAllByCompanyId(Long companyId);

    @Query("SELECT c FROM Candidate c WHERE c.id.acceleration.id = ?1")
    List<Candidate> findAllByAccelerationId(Long acclerationId);

}