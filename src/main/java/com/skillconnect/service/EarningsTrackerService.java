package com.skillconnect.service;

import com.skillconnect.model.EarningsTracker;
import java.util.List;
import java.util.Optional;

public interface EarningsTrackerService {
    List<EarningsTracker> getAllEarningsTrackers();
    Optional<EarningsTracker> getEarningsTrackerById(int id);
    EarningsTracker saveEarningsTracker(EarningsTracker earningsTracker);
    void deleteEarningsTracker(int id);
}
