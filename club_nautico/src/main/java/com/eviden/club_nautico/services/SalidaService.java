package com.eviden.club_nautico.services;

import com.eviden.club_nautico.DTOs.SalidaDTO;
import com.eviden.club_nautico.entity.Salida;
import com.eviden.club_nautico.repositories.SalidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalidaService {
    @Autowired
    private SalidaRepository salidaRepository;

    public Salida createSalida(SalidaDTO salidaDTO) {
        Salida salida = new Salida(salidaDTO.getId(),salidaDTO.getFecha(),salidaDTO.getHora(),salidaDTO.getDestino());
        return salidaRepository.save(salida);
    }

    public List<SalidaDTO> getAllSalidas() {
        List<Salida> salidas = salidaRepository.findAll();
        return salidas.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public SalidaDTO convertToDTO(Salida salida) {
        return new SalidaDTO(salida.getId(),salida.getFecha(),salida.getHora(),salida.getDestino());
    }

}
