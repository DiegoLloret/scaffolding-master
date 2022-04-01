package com.scaffolding.scaffolding.serviceImpl;

import com.scaffolding.scaffolding.entity.Pelicula;
import com.scaffolding.scaffolding.repository.PeliculaJpaRepository;
import com.scaffolding.scaffolding.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("peliculaServiceImpl")
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    @Qualifier("peliculaJpaRepository")
    private PeliculaJpaRepository peliculaJpaRepository;
    // metodo para listar todas las peliculas
    @Override
    public List<Pelicula> listAllPeliculas() {
        return peliculaJpaRepository.findAll();
    }

    //metodo para añadir peliculas
    @Override
    public Pelicula addPelicula(Pelicula pelicula) {
        return peliculaJpaRepository.save(pelicula);
    }

    // metodo para buscar por id
    @Override
    public Pelicula findById(int id) {
        return peliculaJpaRepository.findById(id);
    }

    // metodo para buscar por titulo
    @Override
    public List<Pelicula> findByTitulo(String titulo) {

        List<Pelicula> peli=listAllPeliculas();
        List<Pelicula> lista= new ArrayList<>();
        for (Pelicula pelicula: peliculaJpaRepository.findAll()) {
            if (titulo.equalsIgnoreCase(pelicula.getTitulo())) {
                lista.add(pelicula);

            }

        }
            return lista;

    }

    // metodo para buscar por genero
    @Override
    public List<Pelicula> findByGenero(String genero) {

        List<Pelicula> peli=listAllPeliculas();
        List<Pelicula> lista= new ArrayList<>();
        for (Pelicula pelicula: peliculaJpaRepository.findAll()) {
            if (genero.equalsIgnoreCase(pelicula.getGenero())) {
                lista.add(pelicula);

            }

        }
        return lista;
    }
}