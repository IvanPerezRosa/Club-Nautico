package com.eviden.club_nautico.DTOs;

import lombok.Data;

import java.sql.Date;

@Data
public class SalidaDTO {
    private int id;
    private Date fecha;
    private String hora;
    private String destino;

    public SalidaDTO(int id, Date fecha, String hora, String destino) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.destino = destino;
    }

}
