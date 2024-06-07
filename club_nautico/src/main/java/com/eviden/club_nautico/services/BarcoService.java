package com.eviden.club_nautico.services;

import com.eviden.club_nautico.DTOs.BarcoDTO;
import com.eviden.club_nautico.DTOs.SocioDTO;
import com.eviden.club_nautico.entity.Barco;
import com.eviden.club_nautico.entity.Socio;
import com.eviden.club_nautico.repositories.BarcoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BarcoService {
    @Autowired
    private BarcoRepository barcoRepository;

    public Barco createBarco(BarcoDTO barcoDTO) {
        Barco barco = new Barco(barcoDTO.getId(), barcoDTO.getMatricula(), barcoDTO.getNombre(), barcoDTO.getNum_amarre(), barcoDTO.getCuota_amarre(), barcoDTO.getSalidas(), barcoDTO.getSocio());
        return barcoRepository.save(barco);
    }

    public List<BarcoDTO> getAllBarcos() {
        List<Barco> barcos = barcoRepository.findAll();
        return barcos.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public BarcoDTO getBarcoById(long id) {
        Optional<Barco> barcoOpt = barcoRepository.findById(id);
        Barco barco = barcoOpt.get();
        return convertToDTO(barco);
    }


    public void deleteAllBarcos() {
        barcoRepository.deleteAll();
    }

    public void deleteBarcoById(long Id) {
        Optional<Barco> barcoOpt = barcoRepository.findById(Id);
        barcoRepository.deleteById(Id);
    }

    public BarcoDTO updateBarco(Long id, BarcoDTO barcoDTO){
        Optional<Barco> optionalBarco = barcoRepository.findById(id);

        Barco barco = optionalBarco.get();
        barco.setMatricula(barcoDTO.getMatricula());
        barco.setNombre(barcoDTO.getNombre());
        barco.setNum_amarre(barcoDTO.getNum_amarre());
        barco.setCuota_amarre(barcoDTO.getCuota_amarre());
        barco.setSalidas(barcoDTO.getSalidas());
        barco.setSocio(barcoDTO.getSocio());

        barcoRepository.save(barco);
        return convertToDTO(barco);
    }

    public BarcoDTO convertToDTO(Barco barco) {
        return new BarcoDTO(barco.getId_barco(), barco.getMatricula(), barco.getNombre(), barco.getNum_amarre(), barco.getCuota_amarre(), barco.getSalidas(), barco.getSocio());
    }

}
