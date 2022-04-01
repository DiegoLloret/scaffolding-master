package com.scaffolding.scaffolding.controller;

import com.scaffolding.scaffolding.entity.Pelicula;
import com.scaffolding.scaffolding.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController

@RequestMapping("/")
public class PeliculaController {

    //servicio PeliculaService
    @Autowired
    @Qualifier("peliculaServiceImpl")
    private PeliculaService peliculaService;

    // getmapping para añadir peliculas
   @GetMapping("addPelicula")
   public void insertarPelicula(String titulo,String genero,int anio,int oscar,String actores) {

       peliculaService.addPelicula(new Pelicula(titulo, genero, anio, oscar, actores));
   }
    //getmapping para listar todas las peliculas
    @GetMapping("verPeliculas")
    public Object verPeliculas()
        {
            List<Pelicula> pelicula=peliculaService.listAllPeliculas();

            if (pelicula.isEmpty()){
                return "No hay peliculas";
            }
            return pelicula;
    }

    //getmapping para listar una pelicula por id
    @GetMapping("verPelicula/{id}")
    public Object verPelicula (@PathVariable(value="id")Integer id){

        Pelicula pelicula= peliculaService.findById(id);
        if (pelicula==null){
            return "No hay peliculas con ese id";
        }
        return pelicula;
    }
    //getmapping para listar peliculas por titulo
    @GetMapping("verPeliculaT/{titulo}")
    public Object verPeliculaT (@PathVariable(value="titulo")String titulo){
        List<Pelicula> pelicula=peliculaService.findByTitulo(titulo);
        if (pelicula.isEmpty()){
            return "No hay peliculas con ese titulo";
        }
        return pelicula;
    }
    //getmapping para listar peliculas por titulo
    @GetMapping("verPeliculaG/{genero}")
    public Object verPeliculaG (@PathVariable(value="genero")String genero){
        List<Pelicula> pelicula = peliculaService.findByGenero(genero);
       if (pelicula.isEmpty()){
           return "No hay peliculas con ese genero";
       }
        return pelicula;
    }
}
