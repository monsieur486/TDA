package com.mr486.tda.persistance;

import com.mr486.tda.model.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur, Long> {
    List<Joueur> findByReunionId(Long id);
}
