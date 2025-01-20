package com.proyecto.registro.dao;

import com.proyecto.registro.persistences.models.Pelicula;

import java.util.List;
import java.util.Optional;

public interface PeliculaDao {
    List<Pelicula> selectAllPeliculas();
    Optional<Pelicula> selectPeliculaById(Integer id);
    Pelicula insertPelicula(Pelicula pelicula);
    boolean existsPeliculaById(Integer id);
    void updatePelicula(Pelicula updateRequest);
    void deletePelicula(Integer id);
}
