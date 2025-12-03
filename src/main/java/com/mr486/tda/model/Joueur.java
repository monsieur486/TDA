package com.mr486.tda.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "joueurs")
public class Joueur {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reunion_id")
    private Long reunionId;
    @Column(name = "ami_id")
    private Long amiId;
}
