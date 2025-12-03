package com.mr486.tda.persistance;

import com.mr486.tda.model.Reunion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReunionRepository extends JpaRepository<Reunion, Long> {
    Optional<Reunion> findFirstByActiveTrueOrderByCreatedDateAsc();
}
