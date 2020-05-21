package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("SELECT distinct co FROM Company co JOIN co.candidates ca WHERE ca.id.acceleration.id = ?1")
    List<Company> findAllByAccelerationId(Long accelerationId);

    @Query("SELECT co FROM Company co JOIN co.candidates ca WHERE ca.id.user.id = ?1")
    List<Company> findAllByUserId(Long userId);
}