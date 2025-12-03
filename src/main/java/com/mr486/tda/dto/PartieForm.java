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
public class PartieForm {
    private Long contratId;
    private Long preneurId;
    private Long appelId;
    private Long mortId;
    private Boolean estFait;
    private Integer point;
    private Long petitAuBoutId;
    private Boolean chelem;
    private Boolean capot;
}
