package com.challenge.service;

import com.challenge.entity.Acceleration;
import com.challenge.repository.AccelerationRepository;
import com.challenge.service.interfaces.AccelerationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AccelerationService implements AccelerationServiceInterface {

    @Autowired
    private AccelerationRepository repository;

    @Override
    public Optional<Acceleration> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Acceleration> findByCompanyId(Long companyId) {
        return repository.findByCompanyId(companyId);
    }

    public Optional<Acceleration> findAccelerationByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Acceleration save(Acceleration object) {
        return repository.save(object);
    }

}


