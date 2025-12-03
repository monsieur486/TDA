package com.mr486.tda.persistance;

import com.mr486.tda.model.Ami;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmiRepository extends JpaRepository<Ami, Long> {
}
