package com.mr486.tda.service;

import com.mr486.tda.model.Contrat;
import com.mr486.tda.persistance.ContratRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContratService {

    private final ContratRepository contratRepository;

    public List<Contrat> getContrats() {
        return contratRepository.findAll();
    }

}
