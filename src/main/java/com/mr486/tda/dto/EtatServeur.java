package com.mr486.tda.dto;

import com.mr486.tda.model.Ami;
import com.mr486.tda.model.Contrat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EtatServeur {
    private Integer status;
    private Integer nbJoueurs;
    private List<Ami> joueurs;
    private List<Contrat> contrats;
    private List<ScoreJoueur> scoreJoueurs;
    private DataGraphique dataGraphique;
    private List<String> detailsParties;
}
