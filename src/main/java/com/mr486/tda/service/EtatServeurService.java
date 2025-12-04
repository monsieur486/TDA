package com.mr486.tda.service;

import com.mr486.tda.dto.DataGraphique;
import com.mr486.tda.dto.EtatServeur;
import com.mr486.tda.model.Reunion;
import com.mr486.tda.tools.DetailPartie;
import com.mr486.tda.tools.ScoreJoueurService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EtatServeurService {

    private final ReunionService reunionService;
    private final JoueurService joueurService;
    private final PartieService partieService;
    private final DetailPartie detailPartie;
    private final ScoreJoueurService scoreJoueurService;

    public EtatServeur getEtatServeur() {
        EtatServeur etatServeur = new EtatServeur();
        DataGraphique dataGraphique = new DataGraphique();
        Long reunionId = reunionService.getReunionIdActive();
        etatServeur.setReunionActiveId(reunionId);
        etatServeur.setDataGraphique(dataGraphique);
        if(reunionId >0){
            Reunion reunion = reunionService.getReunionActive();
            if(reunion.getCagnotte()){
                etatServeur.setStatus(2);
            } else {
                etatServeur.setStatus(1);
            }
            etatServeur.setNbJoueurs(joueurService.getJoueursInscrits().size());
            etatServeur.setJoueurs(joueurService.getJoueursInscrits());
            etatServeur.setScoreJoueurs(scoreJoueurService.getScoreJoueurs(
                    joueurService.getJoueursInscrits(),
                    partieService.getPartiesByReunionId(reunionId)
            ));
            etatServeur.setDetailsParties(detailPartie.getDetailsPartiesByReunionId(reunionId));
        }
        etatServeur.setPartieForm(partieService.getPartieForm());
        return etatServeur;
    }

}
