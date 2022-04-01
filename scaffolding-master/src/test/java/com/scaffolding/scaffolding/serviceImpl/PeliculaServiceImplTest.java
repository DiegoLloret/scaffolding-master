package com.scaffolding.scaffolding.serviceImpl;

import com.scaffolding.scaffolding.entity.Pelicula;
import com.scaffolding.scaffolding.repository.PeliculaJpaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class PeliculaServiceImplTest {
    // test de listar todas las peliculas
    @Mock
    private PeliculaJpaRepository jpaRepository;

    @InjectMocks
    private PeliculaServiceImpl peliculaService;
    //test de listar todas las peliculas
    @Test
    void listAllPeliculas() {
    List<Pelicula> lista=new ArrayList<>();
    Mockito.when(jpaRepository.findAll()).thenReturn(lista);
    assertEquals(peliculaService.listAllPeliculas().size(),0);
    }
    // test de añadir peliculas
    @Test
    void addPelicula() {
        Pelicula p = new Pelicula();
        Mockito.when(jpaRepository.save(p)).thenReturn(p);
        assertEquals(peliculaService.addPelicula(p),p);
    }
    //test de buscar peliculas por id
    @Test
    void findById() {
        Pelicula p = new Pelicula();
        Mockito.when(jpaRepository.findById(3)).thenReturn(p);
        assertEquals(peliculaService.findById(3),p);
    }
    //test de buscar peliculas por titulo
    @Test
    void findByTitulo() {
        List<Pelicula> p = new ArrayList<>();
        p.add((new Pelicula("eo","",1,1,"")));
        Mockito.when(jpaRepository.findAll()).thenReturn(p);
        assertEquals(peliculaService.findByTitulo("eo"),p);
    }
    //test de buscar peliculas por genero
    @Test
    void findByGenero() {
        List<Pelicula> p = new ArrayList<>();
        p.add((new Pelicula("","eo",1,1,"")));
        Mockito.when(jpaRepository.findAll()).thenReturn(p);
        assertEquals(peliculaService.findByGenero("eo"),p);
    }
}