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
public class Patron {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_patron;

    @Column
    private String nombre;
    @Column
    private String apellido;

    @OneToMany(mappedBy = "patron", cascade = CascadeType.ALL)
    private List<Salida> salidas;

    @OneToOne
    private Socio socio;

}
