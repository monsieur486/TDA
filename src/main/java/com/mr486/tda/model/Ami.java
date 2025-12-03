package com.mr486.tda.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "amis")
public class Ami {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom", nullable = false)
    private String nom;
    @Column(name = "avatar_url")
    private String avatarUrl;
    @Column(name = "is_guest")
    private Boolean isGuest;
}
