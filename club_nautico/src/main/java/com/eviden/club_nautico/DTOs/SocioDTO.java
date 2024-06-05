package com.eviden.club_nautico.DTOs;

import lombok.Data;

@Data
public class SocioDTO {
    private int id;
    private String nombre;
    private String apellido;
    private Long dni;

    public SocioDTO(int id, Long dni, String apellido, String nombre) {
        this.id = id;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
    }
}

