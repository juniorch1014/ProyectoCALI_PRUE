/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.example.proyectoSW;

import com.example.proyectoSW.Cliente.Cliente;
import com.example.proyectoSW.Empleado.Empleado;
import com.example.proyectoSW.Servicio.Servicio;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.ui.Model;

/**
 *
 * @author LN_JCHG
 */
@RunWith(JUnit4.class)
public class ControladorTest {
    
    public ControladorTest() {
    }

    /**
     * Test of Primer_Inicio method, of class Controlador.
     */
    @Test
    public void testPrimer_Inicio() {
        System.out.println("Primer_Inicio");
        Model model = null;
        Controlador instance = new Controlador();
        String expResult = "/ZInicios/primerInicio.html";
        String result = instance.Primer_Inicio(model);
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
        String expResult = "";
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
        String user = "";
        String pass = "";
        Model model = null;
        Controlador instance = new Controlador();
        String expResult = "";
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
        String nom = "";
        String ape = "";
        String dni = "";
        String cel = "";
        String dir = "";
        String user = "";
        String pass = "";
        Model model = null;
        Controlador instance = new Controlador();
        String expResult = "";
        String result = instance.RegistrarEmp(nom, ape, dni, cel, dir, user, pass, model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RegistrarPl method, of class Controlador.
     */
    @Test
    public void testRegistrarPl() {
        System.out.println("RegistrarPl");
        Empleado emp = null;
        Cliente cli = null;
        Servicio ser = null;
        int dur = 0;
        Model model = null;
        Controlador instance = new Controlador();
        String expResult = "";
        String result = instance.RegistrarPl(emp, cli, ser, dur, model);
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
        String expResult = "";
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
        String expResult = "";
        String result = instance.PlanesMostrar(model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
