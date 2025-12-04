package com.mr486.tda.tools;

import com.mr486.tda.model.Partie;
import com.mr486.tda.service.AmiService;
import com.mr486.tda.service.ContratService;
import com.mr486.tda.service.JoueurService;
import com.mr486.tda.service.PartieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class DetailPartie {

    private final AmiService amiService;
    private final ContratService contratService;
    private final PartieService partieService;
    private final JoueurService joueurService;

    public String getDetail(Partie partie, Integer nbrJoueurs, Integer numPartie) {
        StringBuilder sb = new StringBuilder();
        sb.append(numPartie).append(" ");
        sb.append(contratService.getContratById(partie.getContratId()).getInitiale());
        if (partie.getContratId() > 1) {
            sb.append(" ").append(amiService.getAmiById(partie.getPreneurId()).getNom());
            if (nbrJoueurs >= 5) {
                if (Objects.equals(partie.getPreneurId(), partie.getAppelId())) {
                    sb.append("⚽");
                } else {
                    sb.append("\uD83E\uDD1D").append(amiService.getAmiById(partie.getAppelId()).getNom());
                }
            }
            if (partie.getEstFait()) {
                sb.append(" \uD83D\uDFE2");
            } else {
                sb.append(" \uD83D\uDD34");
            }
            sb.append(partie.getPoints());
            if (partie.getPetitAuBoutId() > 1) {
                sb.append(" ➀").append(amiService.getAmiById(partie.getPetitAuBoutId()).getNom());
            }
            if (partie.getChelem()) {
                sb.append(" \uD83C\uDFC6CHELEM\uD83C\uDFC6");
            }
            if (partie.getCapot()) {
                sb.append(" \uD83D\uDE31CAPOT\uD83D\uDE31");
            }
        }
        if (nbrJoueurs == 6) {
            sb.append(" ⚰\uFE0F").append(amiService.getAmiById(partie.getMortId()).getNom());
        }
        return sb.toString();
    }

    public List<String> getDetailsPartiesByReunionId(Long reunionId) {
        List<Partie> parties = partieService.getPartiesByReunionId(reunionId);
        List<String> details = new java.util.ArrayList<>();
        int nbrJoueurs = joueurService.getJoueursInscrits().size();
        int compteur = 0;
        for (Partie partie : parties) {
            compteur++;
            details.add(getDetail(partie, nbrJoueurs, compteur));
        }
        return details;
    }
}
