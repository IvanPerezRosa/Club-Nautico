package com.eviden.club_nautico.services;

import com.eviden.club_nautico.DTOs.BarcoDTO;
import com.eviden.club_nautico.entity.Barco;
import com.eviden.club_nautico.repositories.BarcoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BarcoService {
    @Autowired
    private BarcoRepository barcoRepository;

    public Barco createBarco(BarcoDTO barcoDTO) {
        Barco barco = new Barco(barcoDTO.getId(), barcoDTO.getMatricula(), barcoDTO.getNombre(), barcoDTO.getNum_amarre(), barcoDTO.getCuota_amarre());
        return barcoRepository.save(barco);
    }

    public List<BarcoDTO> getAllBarcos() {
        List<Barco> barcos = barcoRepository.findAll();
        return barcos.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public BarcoDTO convertToDTO(Barco barco) {
        return new BarcoDTO(barco.getId(), barco.getMatricula(), barco.getNombre(), barco.getNum_amarre(), barco.getCuota_amarre());
    }

}
