package com.skillconnect.service;

import com.skillconnect.model.FreelancerProfile;
import com.skillconnect.model.Project;

import java.util.List;
import java.util.Optional;

public interface FreelancerProfileService {
    List<FreelancerProfile> getAllProfiles();
     Optional<FreelancerProfile> getProfileById(int id);
    FreelancerProfile saveProfile(FreelancerProfile profile);
    void deleteProfile(int id);
	
    Optional<FreelancerProfile> updateProfileById(int id);
}
