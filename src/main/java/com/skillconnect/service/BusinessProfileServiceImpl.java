package com.skillconnect.service;

import com.skillconnect.model.BusinessProfile;
import com.skillconnect.repository.BusinessProfileRepository;
import com.skillconnect.service.BusinessProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusinessProfileServiceImpl implements BusinessProfileService {

    @Autowired
    private BusinessProfileRepository profileRepository;

    @Override
    public List<BusinessProfile> getAllProfiles() {
        return profileRepository.findAll();
    }

    @Override
    public Optional<BusinessProfile> getProfileById(int id) {
        return profileRepository.findById(id);
    }

    @Override
    public BusinessProfile saveProfile(BusinessProfile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public void deleteProfile(int id) {
        profileRepository.deleteById(id);
    }

	@Override
	public Optional<BusinessProfile> updateProfile(int id) {
		// TODO Auto-generated method stub
		return profileRepository.findById(id);
	}
}
