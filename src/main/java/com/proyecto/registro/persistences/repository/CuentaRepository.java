package com.proyecto.registro.persistences.repository;

import com.proyecto.registro.persistences.models.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {
    Optional<Cuenta> findOneByEmail(String email);
}
