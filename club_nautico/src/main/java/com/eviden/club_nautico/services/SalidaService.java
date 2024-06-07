package com.eviden.club_nautico.services;

import com.eviden.club_nautico.DTOs.SalidaDTO;
import com.eviden.club_nautico.entity.Barco;
import com.eviden.club_nautico.entity.Patron;
import com.eviden.club_nautico.entity.Salida;
import com.eviden.club_nautico.repositories.BarcoRepository;
import com.eviden.club_nautico.repositories.PatronRepository;
import com.eviden.club_nautico.repositories.SalidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SalidaService {
    @Autowired
    private SalidaRepository salidaRepository;

    @Autowired
    private PatronRepository patronRepository;

    @Autowired
    private BarcoRepository barcoRepository;

    public Salida createSalida(SalidaDTO salidaDTO) {
        Optional<Patron> patronOptional = patronRepository.findById(salidaDTO.getPatron_id());
        Patron patron = patronOptional.get();

        Optional<Barco> barcoOptional = barcoRepository.findById(salidaDTO.getBarco_id());
        Barco barco = barcoOptional.get();

        Salida salida = new Salida(salidaDTO.getId(),salidaDTO.getFecha(),salidaDTO.getHora(),salidaDTO.getDestino(),patron,barco);
        return salidaRepository.save(salida);
    }

    public List<SalidaDTO> getAllSalidas() {
        List<Salida> salidas = salidaRepository.findAll();
        return salidas.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public SalidaDTO getSalidaById(long salidaId) {
        Optional<Salida> salidaOptional = salidaRepository.findById(salidaId);

        Salida salida = salidaOptional.get();
        return convertToDTO(salida);
    }

    public void deleteAllSalidas() {
        salidaRepository.deleteAll();
    }

    public void deleteSalidaById(long salidaId){
        salidaRepository.deleteById(salidaId);
    }

    public SalidaDTO updateSalida(long id, SalidaDTO salidaDTO) {
        Optional<Salida> optionalSalida = salidaRepository.findById(id);
        Salida salida = optionalSalida.get();

        Optional<Patron> patronOptional = patronRepository.findById(salidaDTO.getPatron_id());
        Patron patron = patronOptional.get();

        Optional<Barco> barcoOptional = barcoRepository.findById(salidaDTO.getBarco_id());
        Barco barco = barcoOptional.get();

        salida.setFecha(salidaDTO.getFecha());
        salida.setHora(salidaDTO.getHora());
        salida.setDestino(salidaDTO.getDestino());
        salida.setPatron(patron);
        salida.setBarco(barco);

        salidaRepository.save(salida);
        return convertToDTO(salida);
    }

    public SalidaDTO convertToDTO(Salida salida) {
        return new SalidaDTO(salida.getId_salida(),salida.getFecha(),salida.getHora(),salida.getDestino(),salida.getPatron().getId_patron(),salida.getBarco().getId_barco());
    }

}
