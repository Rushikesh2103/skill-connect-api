package com.skillconnect.service;

import com.skillconnect.model.Certification;
import com.skillconnect.repository.CertificationRepository;
import com.skillconnect.service.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificationServiceImpl implements CertificationService {

    @Autowired
    private CertificationRepository certificationRepository;

    @Override
    public List<Certification> getAllCertifications() {
        return certificationRepository.findAll();
    }

    @Override
    public Optional<Certification> getCertificationById(int id) {
        return certificationRepository.findById(id);
    }

    @Override
    public Certification saveCertification(Certification certification) {
        return certificationRepository.save(certification);
    }

    @Override
    public void deleteCertification(int id) {
        certificationRepository.deleteById(id);
    }
}
