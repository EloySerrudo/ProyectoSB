package com.proyecto.registro.persistences.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "peliculas")
public class Pelicula {
    @Id
    @SequenceGenerator(
            name = "peliculas_id_sequence",
            sequenceName = "peliculas_id_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "peliculas_id_sequence")
    private Integer peliculaId;
    private String name;
    private String year;
    @ManyToOne
    @JoinColumn(name = "usuarioId", insertable = false, updatable = false)
    private Usuario usuario;
}
