package com.eviden.club_nautico.DTOs;

import com.eviden.club_nautico.entity.Socio;
import lombok.Data;

@Data
public class PatronDTO {
    private long id;
    private String nombre;
    private String apellido;
    private Long id_socio;

    public PatronDTO(long id, String nombre, String apellido, long id_socio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.id_socio = id_socio;
    }

}
