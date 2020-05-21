package com.challenge.repository;

import com.challenge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u join u.candidates cd join cd.id.acceleration a where a.name = ?1")
    List<User> findAllByAccelerationName(String name);

    @Query("select u from User u join u.candidates cd where cd.id.company.id = ?1")
    List<User> findAllByCompanyId(Long id);

}