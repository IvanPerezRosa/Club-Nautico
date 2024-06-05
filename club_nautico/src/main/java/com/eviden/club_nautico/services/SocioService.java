package com.eviden.club_nautico.services;

import com.eviden.club_nautico.DTOs.SocioDTO;
import com.eviden.club_nautico.entity.Socio;
import com.eviden.club_nautico.repositories.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SocioService {
    @Autowired
    private SocioRepository socioRepository;


    public Socio createSocio(SocioDTO socioDTO) {
        Socio socio = new Socio(socioDTO.getId(),socioDTO.getNombre(),socioDTO.getApellido(),socioDTO.getDni());
        return socioRepository.save(socio);
    }

    public List<SocioDTO> getAllSocios(){
        List<Socio> socios = socioRepository.findAll();
        return socios.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public SocioDTO convertToDTO(Socio socio) {
        return new SocioDTO(socio.getId(), socio.getDni(), socio.getApellido(),socio.getNombre());
    }


}
