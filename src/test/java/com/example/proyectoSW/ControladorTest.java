/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.example.proyectoSW;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest(Controlador.class) // Anotación para pruebas de controlador
public class ControladorTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testPrimerInicio() throws Exception {
        mockMvc.perform(get("/")) // Realiza una solicitud GET a la ruta "/"
               .andExpect(status().isOk()) // Espera una respuesta HTTP exitosa (código 200)
               .andExpect(view().name("/ZInicios/primerInicio.html")); // Espera que la vista sea la especificada
    }
}

