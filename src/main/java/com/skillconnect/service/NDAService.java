package com.skillconnect.service;

import com.skillconnect.model.NDA;
import java.util.List;
import java.util.Optional;

public interface NDAService {
    List<NDA> getAllNDAs();
    Optional<NDA> getNDAById(int id);
    NDA saveNDA(NDA nda);
    void deleteNDA(int id);
}
