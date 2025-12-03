package com.mr486.tda.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Partie {

    private Long id;
    private Long reunionId;
    private Long amiId;
    private Long contratId;
    private Long preneurId;
    private Long mortId;
    private Boolean estFait;
    private Integer point;

    private Long petitAuBoutId;
    private Boolean chelem;
    private Boolean capot;
}
