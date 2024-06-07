package com.eviden.club_nautico.DTOs;

import com.eviden.club_nautico.entity.Salida;
import com.eviden.club_nautico.entity.Socio;
import lombok.Data;

import java.util.List;

@Data
public class BarcoDTO {
    private long id;
    private String matricula;
    private String nombre;
    private Long num_amarre;
    private Long cuota_amarre;
    private long socio_id;

    public BarcoDTO(long id, String matricula, String nombre, Long num_amarre, Long cuota_amarre, long socio_id) {
        this.id = id;
        this.matricula = matricula;
        this.nombre = nombre;
        this.num_amarre = num_amarre;
        this.cuota_amarre = cuota_amarre;
        this.socio_id = socio_id;
    }
}
