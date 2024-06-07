package com.eviden.club_nautico.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_salida;

    @Column
    private Date fecha;
    @Column
    private String hora;
    @Column
    private String destino;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_patron", nullable = false)
    private Patron patron;

    @ManyToOne
    @JoinColumn(name = "id_barco", nullable = false)
    private Barco barco;

}
