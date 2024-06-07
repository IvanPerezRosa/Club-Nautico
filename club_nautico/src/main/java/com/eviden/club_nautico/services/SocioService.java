package com.eviden.club_nautico.services;

import com.eviden.club_nautico.DTOs.BarcoDTO;
import com.eviden.club_nautico.DTOs.SocioDTO;
import com.eviden.club_nautico.entity.Barco;
import com.eviden.club_nautico.entity.Socio;
import com.eviden.club_nautico.repositories.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SocioService {
    @Autowired
    private SocioRepository socioRepository;


    public Socio createSocio(SocioDTO socioDTO) {
        Socio socio = new Socio(socioDTO.getId(),socioDTO.getNombre(),socioDTO.getApellido(),socioDTO.getDni(),socioDTO.getBarcos());
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
        socio.setBarcos(socioDTO.getBarcos());

        socioRepository.save(socio);
        return convertToDTO(socio);
    }

    public SocioDTO convertToDTO(Socio socio) {
        return new SocioDTO(socio.getId_socio(), socio.getDni(), socio.getApellido(),socio.getNombre(),socio.getBarcos());
    }


}
