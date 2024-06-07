package com.eviden.club_nautico.DTOs;

import com.eviden.club_nautico.entity.Barco;
import lombok.Data;

import java.util.List;

@Data
public class SocioDTO {
    private long id;
    private String nombre;
    private String apellido;
    private Long dni;
    private List<Long> barcos_id;

    public SocioDTO(long id, Long dni, String apellido, String nombre, List<Long> barcos_id) {
        this.id = id;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.barcos_id = barcos_id;
    }
}

