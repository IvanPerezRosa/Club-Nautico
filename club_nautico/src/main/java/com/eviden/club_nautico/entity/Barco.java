package com.eviden.club_nautico.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Barco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_barco;

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

    public Barco (Long id_barco, String matricula, String nombre, Long num_amarre, Long cuota_amarre, Socio socio) {
        this.id_barco = id_barco;
        this.matricula = matricula;
        this.nombre = nombre;
        this.num_amarre = num_amarre;
        this.cuota_amarre = cuota_amarre;
        this.socio = socio;
    }

}
