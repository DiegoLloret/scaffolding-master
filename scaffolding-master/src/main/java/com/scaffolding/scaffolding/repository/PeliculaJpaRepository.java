package com.scaffolding.scaffolding.repository;

import com.scaffolding.scaffolding.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("peliculaJpaRepository")
public interface PeliculaJpaRepository extends JpaRepository<Pelicula, Serializable> {
    //metodo abstracto para buscar por id
    public abstract Pelicula findById(int id);
    //metodo abstracto para listar por titulo
   // public abstract List<Pelicula> findByTitulo(String titulo);
    //metodo abstracto para buscar por genero
  //  public abstract List<Pelicula> findByGenero(String genero);
}
