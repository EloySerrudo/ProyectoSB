package com.proyecto.registro.persistences.repository;

import com.proyecto.registro.dao.PeliculaDao;
import com.proyecto.registro.persistences.models.Pelicula;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jpaPelicula")
public class PeliculaJPADataAccessService implements PeliculaDao {
    private final PeliculaRepository peliculaRepository;

    public PeliculaJPADataAccessService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    @Override
    public List<Pelicula> selectAllPeliculas() {
        return this.peliculaRepository.findAll();
    }

    @Override
    public Optional<Pelicula> selectPeliculaById(Integer id) {
        return peliculaRepository.findById(id);
    }

    @Override
    public Pelicula insertPelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    @Override
    public boolean existsPeliculaById(Integer id) {
        return peliculaRepository.existsPeliculaByPeliculaId(id);
    }

    @Override
    public void updatePelicula(Pelicula updateRequest) {
        peliculaRepository.save(updateRequest);
    }

    @Override
    public void deletePelicula(Integer id) {
        peliculaRepository.deleteById(id);
    }
}
