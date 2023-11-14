/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.example.proyectoSW.Empleado;

import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.ui.Model;

/**
 *
 * @author LN_JCHG
 */
public class ControladorEmpleadoTest {
    
    public ControladorEmpleadoTest() {
    }

    /**
     * Test of MostrarEmp method, of class ControladorEmpleado.
     */
    @Test
    public void testMostrarEmp() {
        System.out.println("MostrarEmp");
        Model model = null;
        ControladorEmpleado instance = new ControladorEmpleado();
        String expResult = "";
        String result = instance.MostrarEmp(model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarEmp method, of class ControladorEmpleado.
     */
    @Test
    public void testBuscarEmp() {
        System.out.println("BuscarEmp");
        String dato = "";
        Model model = null;
        ControladorEmpleado instance = new ControladorEmpleado();
        String expResult = "";
        String result = instance.BuscarEmp(dato, model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of EliminarEmp method, of class ControladorEmpleado.
     */
    @Test
    public void testEliminarEmp() {
        System.out.println("EliminarEmp");
        int id = 0;
        Model model = null;
        ControladorEmpleado instance = new ControladorEmpleado();
        String expResult = "";
        String result = instance.EliminarEmp(id, model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RegistrarEmp method, of class ControladorEmpleado.
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
        ControladorEmpleado instance = new ControladorEmpleado();
        String expResult = "";
        String result = instance.RegistrarEmp(nom, ape, dni, cel, dir, user, pass, model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ActualizarEmp method, of class ControladorEmpleado.
     */
    @Test
    public void testActualizarEmp() {
        System.out.println("ActualizarEmp");
        int id = 0;
        String nom = "";
        String ape = "";
        String dni = "";
        String cel = "";
        String dir = "";
        String user = "";
        String pass = "";
        Model model = null;
        ControladorEmpleado instance = new ControladorEmpleado();
        String expResult = "";
        String result = instance.ActualizarEmp(id, nom, ape, dni, cel, dir, user, pass, model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of OrdenarAscEmp method, of class ControladorEmpleado.
     */
    @Test
    public void testOrdenarAscEmp() {
        System.out.println("OrdenarAscEmp");
        Model model = null;
        ControladorEmpleado instance = new ControladorEmpleado();
        String expResult = "";
        String result = instance.OrdenarAscEmp(model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of OrdenarDescEmp method, of class ControladorEmpleado.
     */
    @Test
    public void testOrdenarDescEmp() {
        System.out.println("OrdenarDescEmp");
        Model model = null;
        ControladorEmpleado instance = new ControladorEmpleado();
        String expResult = "";
        String result = instance.OrdenarDescEmp(model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
