package com.eviden.club_nautico.DTOs;

import com.eviden.club_nautico.entity.Barco;
import com.eviden.club_nautico.entity.Patron;
import lombok.Data;

import java.sql.Date;

@Data
public class SalidaDTO {
    private int id;
    private Date fecha;
    private String hora;
    private String destino;
    private Patron patron;
    private Barco barco;

    public SalidaDTO(int id, Date fecha, String hora, String destino, Patron patron, Barco barco) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.destino = destino;
        this.patron = patron;
        this.barco = barco;
    }

}
