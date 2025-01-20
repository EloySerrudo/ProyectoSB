package com.proyecto.registro.persistences.repository;

import com.proyecto.registro.persistences.models.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {
    boolean existsPeliculaByPeliculaId(Integer id);
}
