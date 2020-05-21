package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;


public interface CandidateRepository extends JpaRepository<Candidate, CandidateId> {

    @Query("from Candidate c where c.id.user.id = ?1 and c.id.company.id = ?2 and c.id.acceleration.id = ?3")
    Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId);

    @Query("select c from Candidate c where c.id.company.id = ?1")
    List<Candidate> findAllByCompanyId(Long companyId);

    @Query("select c from Candidate c where c.id.acceleration.id = ?1")
    List<Candidate> findAllByAccelerationId(Long acclerationId);

}