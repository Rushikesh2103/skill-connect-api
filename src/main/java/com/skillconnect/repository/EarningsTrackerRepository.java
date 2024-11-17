package com.skillconnect.repository;

import com.skillconnect.model.EarningsTracker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EarningsTrackerRepository extends JpaRepository<EarningsTracker, Integer> {
    
}
