package com.eviden.club_nautico.controller;

import com.eviden.club_nautico.DTOs.BarcoDTO;
import com.eviden.club_nautico.DTOs.SocioDTO;
import com.eviden.club_nautico.entity.Socio;
import com.eviden.club_nautico.services.SocioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/socios")
public class SocioController {

    @Autowired
    private SocioService socioService;

    @PostMapping
    public ResponseEntity<SocioDTO> createSocio(@RequestBody SocioDTO socioDTO) {
        Socio socio = socioService.createSocio(socioDTO);
        SocioDTO socioDTO1= socioService.convertToDTO(socio);
        return new ResponseEntity<>(socioDTO1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SocioDTO>> getAllSocios() {
        List<SocioDTO> socios =socioService.getAllSocios();
        return new ResponseEntity<>(socios,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SocioDTO> getSocioById(@PathVariable long id) {
        SocioDTO socioDTO = socioService.getSocioById(id);
        return new ResponseEntity<>(socioDTO, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllSocios() {
        socioService.deleteAllSocios();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSocioById(@PathVariable long id){
        socioService.deleteSocioById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<SocioDTO> updateSocio(@PathVariable Long id, @Valid @RequestBody SocioDTO socioDTO) {
        SocioDTO updatedSocioDTO = socioService.updateSocio(id, socioDTO);
        return new ResponseEntity<>(updatedSocioDTO, HttpStatus.OK);
    }


}
