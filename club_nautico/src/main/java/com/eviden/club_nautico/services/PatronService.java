package com.eviden.club_nautico.services;

import com.eviden.club_nautico.DTOs.PatronDTO;
import com.eviden.club_nautico.entity.Patron;
import com.eviden.club_nautico.entity.Salida;
import com.eviden.club_nautico.entity.Socio;
import com.eviden.club_nautico.repositories.PatronRepository;
import com.eviden.club_nautico.repositories.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatronService {
    @Autowired
    private PatronRepository patronRepository;
    @Autowired
    private SocioRepository socioRepository;

    public Patron createPatron(PatronDTO patronDTO) {
        Optional<Socio> socioOptional = socioRepository.findById(patronDTO.getId_socio());
        Socio socio = socioOptional.get();

        Patron patron = new Patron(patronDTO.getNombre(), patronDTO.getApellido(), socio);
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

        Optional<Socio> socioOptional = socioRepository.findById(patronDTO.getId_socio());
        Socio socio = socioOptional.get();

        patron.setNombre(patronDTO.getNombre());
        patron.setApellido(patronDTO.getApellido());
        patron.setSocio(socio);

        patronRepository.save(patron);
        return convertToDTO(patron);
    }

    public PatronDTO convertToDTO(Patron patron) {
        return new PatronDTO(patron.getId_patron(), patron.getNombre(), patron.getApellido(), patron.getSocio().getId_socio());
    }

}
