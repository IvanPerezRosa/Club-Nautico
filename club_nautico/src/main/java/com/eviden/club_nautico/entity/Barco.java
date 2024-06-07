package com.eviden.club_nautico.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Barco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_barco;

    @Column
    private String matricula;
    @Column
    private String nombre;
    @Column
    private Long num_amarre;
    @Column
    private Long cuota_amarre;

    @OneToMany(mappedBy = "barco", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Salida> salidas;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_socio")
    private Socio socio;

}
