package com.mr486.tda.tools;

import com.mr486.tda.dto.JoueurInscrit;
import com.mr486.tda.dto.ScoreJoueur;
import com.mr486.tda.model.Ami;
import com.mr486.tda.model.Joueur;
import com.mr486.tda.model.Partie;
import com.mr486.tda.persistance.JoueurRepository;
import com.mr486.tda.service.AmiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ScoreJoueurService {

    private final AmiService amiService;
    private final CalculDeltaService deltaService;

    public List<ScoreJoueur> getScoreJoueurs(List<JoueurInscrit> joueurs, List<Partie> parties) {
        List<ScoreJoueur> scoreJoueurs = new ArrayList<>();
        for (JoueurInscrit joueur : joueurs) {
            ScoreJoueur scoreJoueur = new ScoreJoueur();
            Ami ami = amiService.getAmiById(joueur.getId());
            String nom = ami.getNom();
            if (ami.getIsGuest()) {
                nom += "*";
            }
            scoreJoueur.setNom(nom);
            scoreJoueur.setImage(ami.getAvatarUrl());
            scoreJoueur.setScore(deltaService.calculScoreJoueur(parties, joueurs.size(), ami.getId()));
            scoreJoueurs.add(scoreJoueur);
        }
        // Tri croissant sur score, puis croissant sur nom
        scoreJoueurs.sort((a, b) -> {
            int cmp = Integer.compare(a.getScore(), b.getScore());
            if (cmp == 0) {
                return a.getNom().compareToIgnoreCase(b.getNom());
            }
            return cmp;
        });
        return scoreJoueurs;
    }
}
