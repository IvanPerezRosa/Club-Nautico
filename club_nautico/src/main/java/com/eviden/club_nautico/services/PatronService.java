package com.eviden.club_nautico.services;

import com.eviden.club_nautico.DTOs.PatronDTO;
import com.eviden.club_nautico.entity.Patron;
import com.eviden.club_nautico.repositories.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatronService {
    @Autowired
    private PatronRepository patronRepository;

    public Patron createPatron(PatronDTO patronDTO) {
        Patron patron = new Patron(patronDTO.getId(), patronDTO.getNombre(), patronDTO.getApellido());
        return patronRepository.save(patron);
    }

    public List<PatronDTO> getAllPatrons() {
        List<Patron> patrons = patronRepository.findAll();
        return patrons.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public PatronDTO getPatronById(long patronId) {
        Optional<Patron> patronOptional = patronRepository.findById(patronId);

        Patron patron = patronOptional.get();
        return convertToDTO(patron);
    }

    public void deleteAllPatrones() {
        patronRepository.deleteAll();
    }

    public void deletePatronById(long patronId) {
        patronRepository.deleteById(patronId);
    }

    public PatronDTO updatePatron(long id, PatronDTO patronDTO) {
        Optional<Patron> optionalPatron = patronRepository.findById(id);
        Patron patron = optionalPatron.get();

        patron.setNombre(patronDTO.getNombre());
        patron.setApellido(patronDTO.getApellido());

        patronRepository.save(patron);
        return convertToDTO(patron);
    }

    public PatronDTO convertToDTO(Patron patron) {
        return new PatronDTO(patron.getId(), patron.getNombre(), patron.getApellido());
    }

}
