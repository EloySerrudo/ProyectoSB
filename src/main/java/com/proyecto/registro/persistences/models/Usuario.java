package com.proyecto.registro.persistences.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data                                   //Esto resume los Getters y Setters
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @SequenceGenerator(
            name = "usuarios_id_sequence",
            sequenceName = "usuarios_id_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "usuarios_id_sequence")
    private Integer id;
    private String nombre;
    private String apellido;
    private LocalDateTime fechaInscripcion;
    private UserStatus userStatus;      //Tipo de dato enumerativo creado para prueba.
}
