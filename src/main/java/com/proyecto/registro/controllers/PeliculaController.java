package com.proyecto.registro.controllers;

import com.proyecto.registro.persistences.models.Pelicula;
import com.proyecto.registro.services.PeliculaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/peliculas")
public class PeliculaController {
    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }
    @GetMapping
    public List<Pelicula> getPeliculas() {
        return peliculaService.getPeliculas();
    }
    @GetMapping("{peliculaId}")
    public Pelicula getPelicua(@PathVariable("peliculaId") Integer id) {
        return peliculaService.getPelicula(id);
    }
    @PostMapping
    public Pelicula addPelicula(@RequestBody Pelicula pelicula) {
        return peliculaService.addPelicula(pelicula);
    }
    @PutMapping("{peliculaId}")
    public void updatePelicula(@PathVariable("peliculaId") Integer id, @RequestBody Pelicula request) {
        peliculaService.updatePelicula(id, request);
    }
    @DeleteMapping("{peliculaId}")
    public void deletePelicula(@PathVariable("peliculaId") Integer id) {
        peliculaService.deletePelicula(id);
    }
}
