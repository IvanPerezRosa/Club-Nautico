package com.eviden.club_nautico.repositories;

import com.eviden.club_nautico.entity.Salida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalidaRepository extends JpaRepository<Salida, Long> {
}
