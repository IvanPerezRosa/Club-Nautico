package com.eviden.club_nautico.controller;

import com.eviden.club_nautico.DTOs.PatronDTO;
import com.eviden.club_nautico.entity.Patron;
import com.eviden.club_nautico.services.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patrones")
public class PatronController {

    @Autowired
    private PatronService patronService;

    @PostMapping
    public ResponseEntity<PatronDTO> createPatron(@RequestBody PatronDTO patronDTO) {
        Patron patron = patronService.createPatron(patronDTO);
        PatronDTO patronDTO1 = patronService.convertToDTO(patron);
        return new ResponseEntity<>(patronDTO1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PatronDTO>> getAllPatrons() {
        List<PatronDTO> patrons = patronService.getAllPatrons();
        return new ResponseEntity<>(patrons, HttpStatus.OK);
    }

}
