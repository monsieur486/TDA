package com.mr486.tda.service;

import com.mr486.tda.dto.PartieForm;
import com.mr486.tda.exeption.TdaException;
import com.mr486.tda.model.Partie;
import com.mr486.tda.persistance.PartieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PartieService {

    private final PartieRepository partieRepository;

    public Partie getPartieEdit() {
        return partieRepository.findFirstByEditTrueOrderByIdDesc()
                .orElseThrow(() -> new TdaException("Aucune partie a modifier trouvée"));
    }

    public Long getPartieIdEdition() {
        try {
            return getPartieEdit().getId();
        } catch (TdaException e) {
            return 0L;
        }
    }

    public PartieForm getPartieForm() {
        Long id = getPartieIdEdition();
        PartieForm partieForm = new PartieForm();
        if (id != 0L) {
            Partie partie = partieRepository.findById(id).orElseThrow();
            partieForm.setId(partie.getId());
            partieForm.setContratId(partie.getContratId());
            partieForm.setPreneurId(partie.getPreneurId());
            partieForm.setAppelId(partie.getAppelId());
            partieForm.setMortId(partie.getMortId());
            partieForm.setEstFait(partie.getEstFait());
            partieForm.setPetitAuBoutId(partie.getPetitAuBoutId());
            partieForm.setChelem(partie.getChelem());
            partieForm.setCapot(partie.getCapot());
        }
        return partieForm;
    }
}
