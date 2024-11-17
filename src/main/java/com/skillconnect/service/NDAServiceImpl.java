package com.skillconnect.service;

import com.skillconnect.model.NDA;
import com.skillconnect.repository.NDARepository;
import com.skillconnect.service.NDAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NDAServiceImpl implements NDAService {

    @Autowired
    private NDARepository ndaRepository;

    @Override
    public List<NDA> getAllNDAs() {
        return ndaRepository.findAll();
    }

    @Override
    public Optional<NDA> getNDAById(int id) {
        return ndaRepository.findById(id);
    }

    @Override
    public NDA saveNDA(NDA nda) {
        return ndaRepository.save(nda);
    }

    @Override
    public void deleteNDA(int id) {
        ndaRepository.deleteById(id);
    }
}
