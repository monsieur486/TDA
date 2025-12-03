package com.mr486.tda.service;

import com.mr486.tda.exeption.TdaException;
import com.mr486.tda.model.Reunion;
import com.mr486.tda.persistance.ReunionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReunionService {

    private final ReunionRepository reunionRepository;

    public Reunion getReunionActive() {
        return reunionRepository.findFirstByActiveTrueOrderByCreatedDateAsc()
                .orElseThrow(() -> new TdaException("Aucune réunion active trouvée"));
    }

    public Long getReunionIdActive() {
        try {
            return getReunionActive().getId();
        } catch (TdaException e) {
            return 0L;
        }
    }
}
