package com.skillconnect.service;

import com.skillconnect.model.BusinessProfile;
import java.util.List;
import java.util.Optional;

public interface BusinessProfileService {
    List<BusinessProfile> getAllProfiles();
    Optional<BusinessProfile> getProfileById(int id);
    BusinessProfile saveProfile(BusinessProfile profile);
    Optional<BusinessProfile> updateProfile(int id);
    void deleteProfile(int id);
}
