package com.mr486.tda.service;

import com.mr486.tda.dto.JoueurInscrit;
import com.mr486.tda.model.Ami;
import com.mr486.tda.model.Joueur;
import com.mr486.tda.persistance.JoueurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JoueurService {

    private final JoueurRepository joueurRepository;
    private final AmiService amiService;
    private final ReunionService reunionService;

    public List<JoueurInscrit> getJoueursInscrits() {
        List<JoueurInscrit> list = new java.util.ArrayList<>();
        Long reunionId = reunionService.getReunionIdActive();
        List<Joueur> joueurs = joueurRepository.findByReunionId(reunionId);
        for (Joueur joueur : joueurs) {
            Ami ami = amiService.getAmiById(joueur.getAmiId());
            JoueurInscrit joueurInscrit = new JoueurInscrit(
                    ami.getId(),
                    ami.getNom()
            );
            list.add(joueurInscrit);
        }

        list.sort(java.util.Comparator.comparing(JoueurInscrit::getNom));

        return list;
    }
}
