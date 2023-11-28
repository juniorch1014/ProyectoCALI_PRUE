/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.example.proyectoclientes;

import com.example.proyectoclientes.Cliente.Cliente;
import com.example.proyectoclientes.Empleado.Empleado;
import com.example.proyectoclientes.servicio.Servicio;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.ui.Model;

/**
 *
 * @author LN_JCHG
 */
public class ControladorTest {
    
    public ControladorTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of PrimerInicio method, of class Controlador.
     */
    @Test
    public void testPrimerInicio() {
        System.out.println("PrimerInicio");
        Model model = null;
        Controlador instance = new Controlador();
        String expResult = "/ZInicios/primerInicio.html";
        String result = instance.PrimerInicio(model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Login method, of class Controlador.
     */
    @Test
    public void testLogin() {
        System.out.println("Login");
        Model model = null;
        Controlador instance = new Controlador();
        String expResult = "login";
        String result = instance.Login(model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Ingresar method, of class Controlador.
     */
    @Test
    public void testIngresar() {
        System.out.println("Ingresar");
        String user = "junior";
        String pass = "junior";
        Model model = null;
        Controlador instance = new Controlador();
        String expResult = "login";
        String result = instance.Ingresar(user, pass, model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RegistrarEmp method, of class Controlador.
     */
    @Test
    public void testRegistrarEmp() {
        System.out.println("RegistrarEmp");
        String nom = "pedro";
        String ape = "huaman";
        String dni = "71045565";
        String cel = "946380744";
        String dir = "Av. Moyococha #118";
        String user = "pedroh";
        String pass = "pedroh";
        Model model = null;
        Controlador instance = new Controlador();
        String expResult = "login";
        String result = instance.RegistrarEmp(nom, ape, dni, cel, dir, user, pass, model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RegistrarPlan method, of class Controlador.
     */
    @Test
    public void testRegistrarPlan() {
        System.out.println("RegistrarPlan");
        Empleado emp = null;
        Cliente cli = null;
        Servicio ser = null;
        int dur = 0;
        Model model = null;
        Controlador instance = new Controlador();
        String expResult = "planesMostrar";
        String result = instance.RegistrarPlan(emp, cli, ser, dur, model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GenerarCodigo method, of class Controlador.
     */
    @Test
    public void testGenerarCodigo() {
        System.out.println("GenerarCodigo");
        Controlador instance = new Controlador();
        String expResult = "";
        String result = instance.GenerarCodigo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RegistrarAsist method, of class Controlador.
     */
    @Test
    public void testRegistrarAsist() {
        System.out.println("RegistrarAsist");
        String hora = "12";
        String dia = "28";
        String mes = "11";
        String año = "2023";
        String estado = "Asistio";
        Model model = null;
        Controlador instance = new Controlador();
        String expResult = "pageCalendario";
        String result = instance.RegistrarAsist(hora, dia, mes, año, estado, model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inicio method, of class Controlador.
     */
    @Test
    public void testInicio() {
        System.out.println("inicio");
        Model model = null;
        Controlador instance = new Controlador();
        String expResult = "inicio";
        String result = instance.inicio(model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of PlanesMostrar method, of class Controlador.
     */
    @Test
    public void testPlanesMostrar() {
        System.out.println("PlanesMostrar");
        Model model = null;
        Controlador instance = new Controlador();
        String expResult = "planesMostrar";
        String result = instance.PlanesMostrar(model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of PageNoticias method, of class Controlador.
     */
    @Test
    public void testPageNoticias() {
        System.out.println("PageNoticias");
        Model model = null;
        Controlador instance = new Controlador();
        String expResult = "/ZInicios/pageNoticia.html";
        String result = instance.PageNoticias(model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of PageRecomendaciones method, of class Controlador.
     */
    @Test
    public void testPageRecomendaciones() {
        System.out.println("PageRecomendaciones");
        Model model = null;
        Controlador instance = new Controlador();
        String expResult = "/ZInicios/pageRecomendacion.html";
        String result = instance.PageRecomendaciones(model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Pagecalendario method, of class Controlador.
     */
    @Test
    public void testPagecalendario() {
        System.out.println("Pagecalendario");
        Model model = null;
        Controlador instance = new Controlador();
        String expResult = "/ZInicios/pageCalendario.html";
        String result = instance.Pagecalendario(model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
