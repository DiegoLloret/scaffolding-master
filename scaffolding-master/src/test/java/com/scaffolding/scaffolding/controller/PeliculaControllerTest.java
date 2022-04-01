package com.scaffolding.scaffolding.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scaffolding.scaffolding.entity.Pelicula;
import com.scaffolding.scaffolding.service.PeliculaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PeliculaController.class)
class PeliculaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    @Qualifier("peliculaServiceImpl")
    private PeliculaService peliculaService;



    @Test
    void verPeliculas() throws Exception {
        mockMvc.perform((get("/verPeliculas")).contentType("application/json"))
                .andExpect(status().isOk());
    }

/*
    @Test
    void insertarPelicula() throws Exception{
        mockMvc.perform((get("/addPelicula")).contentType("application/json"))
                .andExpect(status().isOk());
    }
*/
    @Test
    void verPelicula() throws Exception{
        mockMvc.perform((get("/verPelicula/{id}",2)).contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void verPeliculaT() throws Exception{
        mockMvc.perform((get("/verPeliculaT/{titulo}","hola")).contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void verPeliculaG() throws Exception{
        mockMvc.perform((get("/verPeliculaG/{genero}","accion")).contentType("application/json"))
                .andExpect(status().isOk());
    }
}