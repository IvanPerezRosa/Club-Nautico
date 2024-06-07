package com.eviden.club_nautico.DTOs;

import com.eviden.club_nautico.entity.Barco;
import com.eviden.club_nautico.entity.Patron;
import lombok.Data;

import java.sql.Date;

@Data
public class SalidaDTO {
    private long id;
    private Date fecha;
    private String hora;
    private String destino;
    private Long patron_id;
    private Long barco_id;

    public SalidaDTO(long id, Date fecha, String hora, String destino, Long patron_id, Long barco_id) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.destino = destino;
        this.patron_id = patron_id;
        this.barco_id = barco_id;
    }

}
