package com.mr486.tda.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EtatServeur {
    private Long reunionActiveId = 0L;
    private Integer status = 0;
    private Integer nbJoueurs = 0;
    private List<JoueurInscrit> joueurs = new ArrayList<>();
    private List<ScoreJoueur> scoreJoueurs = new ArrayList<>();
    private DataGraphique dataGraphique;
    private List<String> detailsParties = new ArrayList<>();
    private PartieForm partieForm;
}
