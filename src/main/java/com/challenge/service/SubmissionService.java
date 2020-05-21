package com.challenge.service;

import com.challenge.entity.Submission;
import com.challenge.repository.SubmissionRepository;
import com.challenge.service.interfaces.SubmissionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class SubmissionService implements SubmissionServiceInterface {

    @Autowired
    private SubmissionRepository repository;

    @Override
    public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
        Optional<Float> higherScore = repository.findHigherScoreByChallengeId(challengeId);
        if(higherScore.isPresent()) return new BigDecimal(higherScore.get()).setScale(1);
        return BigDecimal.ZERO.setScale(1);
    }

    @Override
    public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
        return repository.findAllByChallengeIdAndAccelerationId(challengeId, accelerationId);
    }

    @Override
    public Submission save(Submission object) {
        return repository.save(object);
    }

}