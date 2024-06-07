package com.eviden.club_nautico.services;

import com.eviden.club_nautico.DTOs.BarcoDTO;
import com.eviden.club_nautico.DTOs.SocioDTO;
import com.eviden.club_nautico.entity.Barco;
import com.eviden.club_nautico.entity.Socio;
import com.eviden.club_nautico.repositories.BarcoRepository;
import com.eviden.club_nautico.repositories.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SocioService {
    @Autowired
    private SocioRepository socioRepository;
    @Autowired
    private BarcoRepository barcoRepository;


    public Socio createSocio(SocioDTO socioDTO) {
        List<Barco> barcos = socioDTO.getBarcos_id().stream()
                .map(id_barco -> {
                    Optional<Barco> optionalBarco = barcoRepository.findById(id_barco);
                    Barco barco = optionalBarco.get();
                    return barco;
                }).toList();

        Socio socio;
        if (barcos == null || barcos.isEmpty()) {
            socio = new Socio(socioDTO.getId(),socioDTO.getNombre(),socioDTO.getApellido(),socioDTO.getDni(),null);
        } else {
            socio = new Socio(socioDTO.getId(),socioDTO.getNombre(),socioDTO.getApellido(),socioDTO.getDni(),barcos);
        }

        return socioRepository.save(socio);
    }

    public List<SocioDTO> getAllSocios(){
        List<Socio> socios = socioRepository.findAll();
        return socios.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public SocioDTO getSocioById(long id) {
        Optional<Socio> socioOpt = socioRepository.findById(id);
        Socio socio = socioOpt.get();
        return convertToDTO(socio);
    }

    public void deleteAllSocios() {
        socioRepository.deleteAll();
    }

    public void deleteSocioById(long Id) {
        Optional<Socio> socioOpt = socioRepository.findById(Id);
        socioRepository.deleteById(Id);
    }

    public SocioDTO updateSocio(Long id, SocioDTO socioDTO){
        Optional<Socio> optionalSocio = socioRepository.findById(id);

        Socio socio = optionalSocio.get();
        socio.setNombre(socioDTO.getNombre());
        socio.setApellido(socioDTO.getApellido());
        socio.setDni(socioDTO.getDni());

        socioRepository.save(socio);
        return convertToDTO(socio);
    }

    public SocioDTO convertToDTO(Socio socio) {
        List<Long> barcos_id = socio.getBarcos().stream().map(Barco::getId_barco).toList();
        return new SocioDTO(socio.getId_socio(), socio.getDni(), socio.getApellido(),socio.getNombre(),barcos_id);
    }


}
