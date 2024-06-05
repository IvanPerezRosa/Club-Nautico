package com.eviden.club_nautico.repositories;

import com.eviden.club_nautico.entity.Barco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarcoRepository extends JpaRepository<Barco, Long> {
}
