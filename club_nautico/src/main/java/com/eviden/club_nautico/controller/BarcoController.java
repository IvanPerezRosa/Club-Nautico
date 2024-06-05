package com.eviden.club_nautico.controller;

import com.eviden.club_nautico.DTOs.BarcoDTO;
import com.eviden.club_nautico.entity.Barco;
import com.eviden.club_nautico.services.BarcoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/barcos")
public class BarcoController {

    @Autowired
    private BarcoService barcoService;

    @PostMapping
    public ResponseEntity<BarcoDTO> createBarco(@RequestBody BarcoDTO barcoDTO) {
        Barco barco = barcoService.createBarco(barcoDTO);
        BarcoDTO barcoDTO1 = barcoService.convertToDTO(barco);
        return new ResponseEntity<>(barcoDTO1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BarcoDTO>> getAllBarcos() {
        List<BarcoDTO> barcos = barcoService.getAllBarcos();
        return new ResponseEntity<>(barcos, HttpStatus.OK);
    }

}
