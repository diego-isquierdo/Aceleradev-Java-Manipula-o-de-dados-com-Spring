package com.challenge.service;

import com.challenge.entity.User;
import com.challenge.repository.UserRepository;
import com.challenge.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {

    @Autowired private UserRepository repository;

    @Override
    public Optional<User> findById(Long userId) {
        return repository.findById(userId);
    }

    @Override
    public List<User> findByAccelerationName(String name) {
        return repository.findAllByAccelerationName(name);
    }

    @Override
    public List<User> findByCompanyId(Long companyId) {
        return repository.findAllByCompanyId(companyId);
    }

    @Override
    public User save(User object) {
        return repository.save(object);
    }

}