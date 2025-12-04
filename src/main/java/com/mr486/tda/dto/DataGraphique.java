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
public class DataGraphique {
    private List<String> nomsJoueurs = new ArrayList<>();
    private List<Integer> scoreJoueurs = new ArrayList<>();
}
