package com.proyecto.registro.persistences.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cuentas")
public class Cuenta {
    @Id
    @SequenceGenerator(
            name = "cuentas_id_sequence",
            sequenceName = "cuentas_id_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cuentas_id_sequence")
    private Integer id;
    private String email;
    private String password;
}
