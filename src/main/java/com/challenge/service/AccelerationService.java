package com.challenge.service;

import com.challenge.entity.Acceleration;
import com.challenge.repository.AccelerationRepository;
import com.challenge.service.interfaces.AccelerationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AccelerationService implements AccelerationServiceInterface {

    @Autowired
    private AccelerationRepository repository;

    public Optional<Acceleration> findAccelerationByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Optional<Acceleration> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Acceleration> findByCompanyId(Long companyId) {
        return null;
    }

    @Override
    public Acceleration save(Acceleration object) {
        return null;
    }

}
