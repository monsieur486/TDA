package com.mr486.tda.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "parties")
public class Partie {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reunion_id")
    private Long reunionId;
    @Column(name = "contrat_id")
    private Long contratId;
    @Column(name = "preneur_id")
    private Long preneurId;
    @Column(name = "appel_id")
    private Long appelId;
    @Column(name = "mort_id")
    private Long mortId;
    @Column(name = "est_fait")
    private Boolean estFait;
    private Integer points;
    @Column(name = "petit_au_bout_id")
    private Long petitAuBoutId;
    private Boolean chelem;
    private Boolean capot;
}
