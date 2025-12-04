package com.mr486.tda.service;

import com.mr486.tda.dto.DataGraphique;
import com.mr486.tda.dto.EtatServeur;
import com.mr486.tda.model.Reunion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EtatServeurService {

    private final ReunionService reunionService;
    private final JoueurService joueurService;

    public EtatServeur getEtatServeur() {
        EtatServeur etatServeur = new EtatServeur();
        DataGraphique dataGraphique = new DataGraphique();
        Long reunionId = reunionService.getReunionIdActive();
        etatServeur.setReunionId(reunionId);
        etatServeur.setDataGraphique(dataGraphique);
        if(reunionId >0){
            Reunion reunion = reunionService.getReunionActive();
            if(reunion.getCagnotte()){
                etatServeur.setStatus(2);
            } else {
                etatServeur.setStatus(1);
            }
            etatServeur.setNbJoueurs(joueurService.getJoueursInscrits().size());
        }
        return etatServeur;
    }

}
