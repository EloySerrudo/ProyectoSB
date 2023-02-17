package com.proyecto.registro.persistences.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data                                   //Esto resume los Getters y Setters
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String nombre;
    private String apellido;
    private LocalDateTime fechaInscripcion;
    private UserStatus userStatus;      //Tipo de dato enumerativo creado para prueba.
}
