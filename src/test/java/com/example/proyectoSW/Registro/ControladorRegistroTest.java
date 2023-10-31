/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.example.proyectoSW.Registro;

import com.example.proyectoSW.Cliente.Cliente;
import com.example.proyectoSW.Empleado.Empleado;
import com.example.proyectoSW.Servicio.Servicio;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.ui.Model;

/**
 *
 * @author LN_JCHG
 */
public class ControladorRegistroTest {
    
    public ControladorRegistroTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of MostrarRegistro method, of class ControladorRegistro.
     */
    @Test
    public void testMostrarRegistro() {
        System.out.println("MostrarRegistro");
        Model model = null;
        ControladorRegistro instance = new ControladorRegistro();
        String expResult = "";
        String result = instance.MostrarRegistro(model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarCliente method, of class ControladorRegistro.
     */
    @Test
    public void testBuscarCliente() {
        System.out.println("BuscarCliente");
        String dato = "";
        Model model = null;
        ControladorRegistro instance = new ControladorRegistro();
        String expResult = "";
        String result = instance.BuscarCliente(dato, model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of EliminarCliente method, of class ControladorRegistro.
     */
    @Test
    public void testEliminarCliente() {
        System.out.println("EliminarCliente");
        int id = 0;
        Model model = null;
        ControladorRegistro instance = new ControladorRegistro();
        String expResult = "";
        String result = instance.EliminarCliente(id, model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RegistrarCliente method, of class ControladorRegistro.
     */
    @Test
    public void testRegistrarCliente() {
        System.out.println("RegistrarCliente");
        Empleado emp = null;
        Cliente cli = null;
        Servicio ser = null;
        int dur = 0;
        Model model = null;
        ControladorRegistro instance = new ControladorRegistro();
        String expResult = "";
        String result = instance.RegistrarCliente(emp, cli, ser, dur, model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ActualizarCliente method, of class ControladorRegistro.
     */
    @Test
    public void testActualizarCliente() {
        System.out.println("ActualizarCliente");
        int id = 0;
        Empleado emp = null;
        Cliente cli = null;
        Servicio ser = null;
        int dur = 0;
        Model model = null;
        ControladorRegistro instance = new ControladorRegistro();
        String expResult = "";
        String result = instance.ActualizarCliente(id, emp, cli, ser, dur, model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of OrdenarAscReg method, of class ControladorRegistro.
     */
    @Test
    public void testOrdenarAscReg() {
        System.out.println("OrdenarAscReg");
        Model model = null;
        ControladorRegistro instance = new ControladorRegistro();
        String expResult = "";
        String result = instance.OrdenarAscReg(model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of OrdenarDescReg method, of class ControladorRegistro.
     */
    @Test
    public void testOrdenarDescReg() {
        System.out.println("OrdenarDescReg");
        Model model = null;
        ControladorRegistro instance = new ControladorRegistro();
        String expResult = "";
        String result = instance.OrdenarDescReg(model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
