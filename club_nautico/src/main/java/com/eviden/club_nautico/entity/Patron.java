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
public class Patron {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_patron;

    @Column
    private String nombre;
    @Column
    private String apellido;

    @OneToMany(mappedBy = "patron", cascade = CascadeType.ALL)
    private List<Salida> salidas;

    @OneToOne
    private Socio socio;

    public Patron(String nombre, String apellido, Socio socio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.socio = socio;
    }

}
