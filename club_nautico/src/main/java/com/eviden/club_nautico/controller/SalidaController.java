package com.eviden.club_nautico.controller;

import com.eviden.club_nautico.DTOs.SalidaDTO;
import com.eviden.club_nautico.entity.Salida;
import com.eviden.club_nautico.services.SalidaService;
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

}
