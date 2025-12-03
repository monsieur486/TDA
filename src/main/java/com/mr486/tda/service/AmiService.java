package com.mr486.tda.service;

import com.mr486.tda.exeption.TdaException;
import com.mr486.tda.model.Ami;
import com.mr486.tda.persistance.AmiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AmiService {

    private final AmiRepository amiRepository;

    public List<Ami> getAmisOrder() {
        return amiRepository.findAll().stream()
                .sorted(Comparator.comparing(Ami::getIsGuest)
                        .thenComparing(Ami::getNom))
                .toList();
    }

    public Ami getAmiById(Long id) {
        return amiRepository
                .findById(id)
                .orElseThrow(() -> new TdaException("Ami introuvable avec l'id: " + id));
    }

}
