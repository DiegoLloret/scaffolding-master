package com.scaffolding.scaffolding.entity;

import javax.persistence.*;

@Entity
@Table(name="pelicula")
public class Pelicula {

    /*Clase entity con los atributos id(que es la clave primaria), titulo de tipo string no puede ser nulo
    , genero de tipo string no puede ser nulo, año de tipo int no puede ser nulo, oscar de tipo int puede ser nulo
     y actores de tipo string no puede ser nulo.
     */
    @Id // Con esta anotación indicamos a hibernate que es un ID
    @GeneratedValue
    @Column(name="id") //Mapeo de columna y campo
    private int id;

    @Column(name="titulo", nullable = false)
    private String titulo;

    @Column(name="genero" , nullable = false)
    private String genero;

    @Column(name="anio" , nullable = false)
    private int anio;

    @Column(name="oscar" )
    private int oscar;

    @Column(name="actores" , nullable = false)
    private String actores;
// constructor con todos los atributos
    public Pelicula(int id, String titulo, String genero, int anio, int oscar, String actores) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.anio = anio;
        this.oscar = oscar;
        this.actores = actores;
    }
// constructor con todos los atributos menos id
    public Pelicula(String titulo, String genero, int anio, int oscar, String actores) {
        this.titulo = titulo;
        this.genero = genero;
        this.anio = anio;
        this.oscar = oscar;
        this.actores = actores;
    }
// constructor sin parametros
    public Pelicula() {
    }
// getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getOscar() {
        return oscar;
    }

    public void setOscar(int oscar) {
        this.oscar = oscar;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }
//metodo toString
    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", anio=" + anio +
                ", oscar=" + oscar +
                ", actores='" + actores + '\'' +
                '}';
    }
}
