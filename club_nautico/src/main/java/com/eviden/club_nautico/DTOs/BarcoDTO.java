package com.eviden.club_nautico.DTOs;

import lombok.Data;

@Data
public class BarcoDTO {
    private int id;
    private String matricula;
    private String nombre;
    private Long num_amarre;
    private Long cuota_amarre;

    public BarcoDTO(int id, String matricula, String nombre, Long num_amarre, Long cuota_amarre) {
        this.id = id;
        this.matricula = matricula;
        this.nombre = nombre;
        this.num_amarre = num_amarre;
        this.cuota_amarre = cuota_amarre;
    }
}
