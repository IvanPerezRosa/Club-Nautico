package com.eviden.club_nautico.DTOs;

import com.eviden.club_nautico.entity.Salida;
import com.eviden.club_nautico.entity.Socio;
import lombok.Data;

import java.util.List;

@Data
public class PatronDTO {
    private int id;
    private String nombre;
    private String apellido;
    private List<Salida> salidas;
    private Socio socio;

    public PatronDTO(int id, String nombre, String apellido, List<Salida> salidas, Socio socio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.salidas = salidas;
        this.socio = socio;
    }

}
