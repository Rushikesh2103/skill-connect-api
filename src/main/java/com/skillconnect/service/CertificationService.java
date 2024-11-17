package com.skillconnect.service;

import com.skillconnect.model.Certification;
import java.util.List;
import java.util.Optional;

public interface CertificationService {
    List<Certification> getAllCertifications();
    Optional<Certification> getCertificationById(int id);
    Certification saveCertification(Certification certification);
    void deleteCertification(int id);
}
