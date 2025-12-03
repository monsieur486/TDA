package com.mr486.tda.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScoreJoueur {
    private String nom;
    private String image;
    private Integer score;

    public String couleur() {
        if (score > 0) {
            return "GREEN";
        } else if (score < 0) {
            return "RED";
        } else {
            return "BLACK";
        }
    }
}
