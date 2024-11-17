package com.skillconnect.repository;

import com.skillconnect.model.BusinessProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessProfileRepository extends JpaRepository<BusinessProfile, Integer> {
    
}
