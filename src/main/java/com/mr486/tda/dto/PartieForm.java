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
    private Long id = 0L;
    private Long contratId = 0L;
    private Long preneurId = 0L;
    private Long appelId = 0L;
    private Long mortId = 0L;
    private Boolean estFait = false;
    private Integer point = 0;
    private Long petitAuBoutId = 0L;
    private Boolean chelem = false;
    private Boolean capot = false;
}
