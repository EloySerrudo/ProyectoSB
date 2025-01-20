package com.proyecto.registro.services;

import com.proyecto.registro.dao.PeliculaDao;
import com.proyecto.registro.persistences.models.Pelicula;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService {
    private final PeliculaDao peliculaDao;

    public PeliculaService(@Qualifier("jpaPelicula") PeliculaDao peliculaDao) {
        this.peliculaDao = peliculaDao;
    }
    public List<Pelicula> getPeliculas() {
        return peliculaDao.selectAllPeliculas();
    }
    public Pelicula getPelicula(Integer id) {
        return peliculaDao.selectPeliculaById(id)
                .orElseThrow();
    }
    public Pelicula addPelicula(Pelicula pelicula) {
        return peliculaDao.insertPelicula(pelicula);
    }
    public void updatePelicula(Integer id, Pelicula updateRequest) {
        Pelicula pelicula = peliculaDao.selectPeliculaById(id)
                .orElseThrow();
        pelicula.setName(updateRequest.getName());
        pelicula.setYear(updateRequest.getYear());
        peliculaDao.updatePelicula(pelicula);
    }
    public void deletePelicula(Integer id) {
        if (!peliculaDao.existsPeliculaById(id)) {
            ;
        }
        peliculaDao.deletePelicula(id);
    }
}
