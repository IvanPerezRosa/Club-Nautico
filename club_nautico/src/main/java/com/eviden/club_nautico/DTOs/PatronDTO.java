package com.eviden.club_nautico.DTOs;

import lombok.Data;

@Data
public class PatronDTO {
    private int id;
    private String nombre;
    private String apellido;

    public PatronDTO(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

}
