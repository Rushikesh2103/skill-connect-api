package com.skillconnect.controller;

import com.skillconnect.model.Certification;
import com.skillconnect.service.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/certifications")
public class CertificationController {

    @Autowired
    private CertificationService certificationService;

    @GetMapping
    public List<Certification> getAllCertifications() {
        return certificationService.getAllCertifications();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Certification> getCertificationById(@PathVariable int id) {
        Optional<Certification> certification = certificationService.getCertificationById(id);
        return certification.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Certification createCertification(@RequestBody Certification certification) {
        return certificationService.saveCertification(certification);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Certification> updateCertification(@PathVariable int id, @RequestBody Certification certification) {
        if (!certificationService.getCertificationById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        certification.setId(id);
        return ResponseEntity.ok(certificationService.saveCertification(certification));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCertification(@PathVariable int id) {
        if (!certificationService.getCertificationById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        certificationService.deleteCertification(id);
        return ResponseEntity.noContent().build();
    }
}
