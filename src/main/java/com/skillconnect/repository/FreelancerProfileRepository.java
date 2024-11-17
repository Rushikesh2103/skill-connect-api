package com.skillconnect.repository;

import com.skillconnect.model.FreelancerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreelancerProfileRepository extends JpaRepository<FreelancerProfile, Integer> {
    
}
