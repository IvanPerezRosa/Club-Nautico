package com.eviden.club_nautico.controller;

import com.eviden.club_nautico.DTOs.SalidaDTO;
import com.eviden.club_nautico.entity.Salida;
import com.eviden.club_nautico.services.SalidaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salidas")
public class SalidaController {

    @Autowired
    private SalidaService salidaService;

    @PostMapping
    public ResponseEntity<SalidaDTO> createSalida(@RequestBody SalidaDTO salidaDTO) {
        Salida salida = salidaService.createSalida(salidaDTO);
        SalidaDTO salidaDTO1 = salidaService.convertToDTO(salida);
        return new ResponseEntity<>(salidaDTO1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SalidaDTO>> getAllSalidas() {
        List<SalidaDTO> salidas = salidaService.getAllSalidas();
        return new ResponseEntity<>(salidas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalidaDTO> getSalidaById(@PathVariable long id) {
        SalidaDTO salidaDTO = salidaService.getSalidaById(id);
        return new ResponseEntity<>(salidaDTO, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllSalidas() {
        salidaService.deleteAllSalidas();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalidaById(@PathVariable long id) {
        salidaService.deleteSalidaById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalidaDTO> updateSalida(@PathVariable Long id, @Valid @RequestBody SalidaDTO salidaDTO) {
        SalidaDTO updatedSalidaDTO = salidaService.updateSalida(id, salidaDTO);
        return new ResponseEntity<>(updatedSalidaDTO, HttpStatus.OK);
    }

}
