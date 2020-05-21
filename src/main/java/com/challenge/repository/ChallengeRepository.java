package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ChallengeRepository extends JpaRepository<Challenge, Long> {
    @Query("SELECT ch FROM Challenge ch JOIN ch.accelerations a JOIN a.candidates ca WHERE a.id = ?1 AND ca.id.user.id = ?2")
    List<Challenge> findAllByAccelerationIdAndUserId(Long accelerationId, Long userId);
}