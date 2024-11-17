package com.skillconnect.service;

import com.skillconnect.model.EarningsTracker;
import com.skillconnect.repository.EarningsTrackerRepository;
import com.skillconnect.service.EarningsTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EarningsTrackerServiceImpl implements EarningsTrackerService {

    @Autowired
    private EarningsTrackerRepository earningsTrackerRepository;

    @Override
    public List<EarningsTracker> getAllEarningsTrackers() {
        return earningsTrackerRepository.findAll();
    }

    @Override
    public Optional<EarningsTracker> getEarningsTrackerById(int id) {
        return earningsTrackerRepository.findById(id);
    }

    @Override
    public EarningsTracker saveEarningsTracker(EarningsTracker earningsTracker) {
        return earningsTrackerRepository.save(earningsTracker);
    }

    @Override
    public void deleteEarningsTracker(int id) {
        earningsTrackerRepository.deleteById(id);
    }
}
