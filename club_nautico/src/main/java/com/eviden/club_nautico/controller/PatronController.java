package com.eviden.club_nautico.controller;

import com.eviden.club_nautico.DTOs.PatronDTO;
import com.eviden.club_nautico.entity.Patron;
import com.eviden.club_nautico.services.PatronService;
import jakarta.validation.Valid;
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

    @GetMapping("/{id}")
    public ResponseEntity<PatronDTO> getPatronById(@PathVariable long id) {
        PatronDTO patronDTO = patronService.getPatronById(id);
        return new ResponseEntity<>(patronDTO, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllPatrones() {
        patronService.deleteAllPatrones();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatronById(@PathVariable long id) {
        patronService.deletePatronById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatronDTO> updatePatron(@PathVariable Long id, @Valid @RequestBody PatronDTO patronDTO) {
        PatronDTO updatedPatronDTO = patronService.updatePatron(id, patronDTO);
        return new ResponseEntity<>(updatedPatronDTO, HttpStatus.OK);
    }

}
