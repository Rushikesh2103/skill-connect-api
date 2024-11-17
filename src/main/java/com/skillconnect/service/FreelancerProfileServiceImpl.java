package com.skillconnect.service;

import com.skillconnect.model.FreelancerProfile;
import com.skillconnect.repository.FreelancerProfileRepository;
import com.skillconnect.service.FreelancerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FreelancerProfileServiceImpl implements FreelancerProfileService {

    @Autowired
    private FreelancerProfileRepository profileRepository;
    
    @Override
    public List<FreelancerProfile> getAllProfiles() {
        return profileRepository.findAll();
    }

    @Override
    public Optional<FreelancerProfile> getProfileById(int id) {
        return profileRepository.findById(id);
    }

    @Override
    public FreelancerProfile saveProfile(FreelancerProfile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public void deleteProfile(int id) {
        profileRepository.deleteById(id);
    }

	@Override
	public Optional<FreelancerProfile> updateProfileById(int id) {
		return profileRepository.findById(id);
	}
}
