package com.eviden.club_nautico.repositories;

import com.eviden.club_nautico.entity.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatronRepository extends JpaRepository<Patron, Long>  {

}
