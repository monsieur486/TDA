package com.mr486.tda.persistance;

import com.mr486.tda.model.Partie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PartieRepository extends JpaRepository<Partie, Long> {
    Optional<Partie> findFirstByEditTrueOrderByIdDesc();

    List<Partie> findAllByReunionIdOrderByIdAsc(Long id);
}
