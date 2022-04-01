package com.scaffolding.scaffolding.service;

import com.scaffolding.scaffolding.entity.Pelicula;

import java.util.List;

public interface PeliculaService {
    //metodo abstracto para listar todas las peliculas
    public abstract List<Pelicula> listAllPeliculas();

    //metodo abstracto para añadir peliculas
    public abstract Pelicula addPelicula (Pelicula pelicula);

    //metodo abstracto para buscar por id
    public abstract Pelicula findById(int id);

    //metodo abstracto  para buscar por titulo
    public abstract List<Pelicula> findByTitulo(String titulo);

    //metodo abstracto  para buscar por genero
    public abstract List<Pelicula> findByGenero(String genero);
}
