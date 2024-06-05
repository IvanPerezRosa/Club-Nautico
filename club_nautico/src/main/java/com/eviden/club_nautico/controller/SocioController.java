package com.eviden.club_nautico.controller;

import com.eviden.club_nautico.DTOs.SocioDTO;
import com.eviden.club_nautico.entity.Socio;
import com.eviden.club_nautico.services.SocioService;
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



}
