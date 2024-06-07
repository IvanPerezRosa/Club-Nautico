package com.eviden.club_nautico.DTOs;

import com.eviden.club_nautico.entity.Barco;
import lombok.Data;

import java.util.List;

@Data
public class SocioDTO {
    private int id;
    private String nombre;
    private String apellido;
    private Long dni;
    private List<Barco> barcos;

    public SocioDTO(int id, Long dni, String apellido, String nombre, List<Barco> barcos) {
        this.id = id;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.barcos = barcos;
    }
}

