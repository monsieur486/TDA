package com.mr486.tda.tools;

import com.mr486.tda.model.Contrat;
import com.mr486.tda.model.Partie;
import com.mr486.tda.service.ContratService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CalculDeltaService {

    private final ContratService contratService;

    private Integer calcul4joueurs(Partie partie, Long joueurId) {
        log.warn("Calculating deltas for 4 joueurs partie id: {} - joueur id: {}", partie.getId(), joueurId);
        int variation = 0;
        if (partie.getContratId() <= 1) {
            return 0;
        }
        return variation;
    }

    private Integer calcul5joueurs(Partie partie, Long joueurId) {
        log.warn("Calculating deltas for 5 joueurs partie id: {} - joueur id: {}", partie.getId(), joueurId);
        if (partie.getContratId() <= 1) {
            return 0;
        }

        Contrat contrat = contratService.getContratById(partie.getContratId());

        int variation = contrat.getPoints() + partie.getPoints();
        if (!partie.getEstFait()) {
            variation = -variation;
        }
        if (partie.getChelem() || partie.getCapot()) {
            variation *= 2;
        }

        if (partie.getPreneurId().equals(partie.getAppelId())) {
            if (partie.getPreneurId().equals(joueurId)) {
                variation = variation * 4;
            } else {
                variation = -variation;
            }
        } else {
            if (partie.getPreneurId().equals(joueurId)) {
                variation = variation * 2;
            } else if (!partie.getAppelId().equals(joueurId)) {
                variation = -variation;
            }
        }

        if (partie.getPetitAuBoutId() > 0L) {
            if (partie.getPetitAuBoutId().equals(joueurId)) {
                variation += 40;
            } else {
                variation -= 10;
            }
        }

        return variation;
    }

    private Integer getPointsContrat(Partie partie) {
        Integer points = 0;
        Contrat contrat = contratService.getContratById(partie.getContratId());
        if (partie.getContratId() == 1) { // Belge
            return 0;
        }

        points = contrat.getPoints();
        points += partie.getPoints();

        if (!partie.getEstFait()) {
            points = -points;
        }

        if (Boolean.TRUE.equals(partie.getChelem())) {
            points = points * 2;
        }

        if (Boolean.TRUE.equals(partie.getChelem())) {
            points = points * 2;
        }
        return points;
    }

    public Integer calculScoreJoueur(List<Partie> parties, int nombreJoueurs, Long amiId) {
        int score = 0;
        int nombrePartie = 0;
        for (Partie partie : parties) {
            nombrePartie++;
            score += calculDelta(partie, amiId, nombreJoueurs);
        }
        return score;
    }

    public Integer calculDelta(Partie partie, Long joueurId, int nombreJoueurs) {
        if (nombreJoueurs == 4) {
            return calcul4joueurs(partie, joueurId);
        } else {
            return calcul5joueurs(partie, joueurId);
        }
    }

    public List<Integer> getDeltasForUserId(List<Partie> parties, Long amiId, int nombreJoueurs) {
        return parties.stream()
                .map(partie -> calculDelta(partie, amiId, nombreJoueurs))
                .toList();
    }
}
