/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectoSW.Empleado;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/empleado/") //http://localhost/empleado/
@Controller
public class ControladorEmpleado {
    
    String carpeta="Empleados/";
    
    @Autowired
    private IEmpleadoService serviceE;
    
    @GetMapping("/")
    public String MostrarEmp(Model model){
        
        List<Empleado> empleados=serviceE.Listar();
        model.addAttribute("empleados",empleados);
        return carpeta+"listaEmpleados";//listaClientes.html
    }
    
    @PostMapping("/buscarE")
    public String BuscarEmp(@RequestParam("dato") String dato, Model model){
        
        List<Empleado> empleados=serviceE.Buscar(dato);
        model.addAttribute("empleados",empleados);
        return carpeta+"listaEmpleados";//listaClientes.html
    }
    
    @GetMapping("/eliminarE")
    public String EliminarEmp(@RequestParam("id") int id, Model model){
        serviceE.Eliminar(id);
        return MostrarEmp(model);
    }
    
    @PostMapping("/registrarE")
    public String RegistrarEmp(@RequestParam("nom") String nom,
                            @RequestParam("ape") String ape,
                            @RequestParam("dni") String dni,
                            @RequestParam("cel") String cel,
                            @RequestParam("dir") String dir,
                            @RequestParam("user") String user,
                            @RequestParam("pass") String pass,
                            Model model){
        
        Empleado e = new Empleado();
        e.setNombre(nom);
        e.setApellido(ape);
        e.setDni(dni);
        e.setCelular(cel);
        e.setDireccion(dir);
        e.setUsuario(user);
        e.setPassword(pass);
        
        serviceE.Guardar(e);
        return MostrarEmp(model);
    }
    
    @PostMapping("/actualizarE")
    public String ActualizarEmp(@RequestParam("id") int id,
                            @RequestParam("nombre") String nom,
                            @RequestParam("apellido") String ape,
                            @RequestParam("dniE") String dni,
                            @RequestParam("celular") String cel,
                            @RequestParam("direccion") String dir,
                            @RequestParam("usuario") String user,
                            @RequestParam("pass") String pass,
                            Model model){
        
        Empleado e = new Empleado();
        e.setId(id);
        e.setNombre(nom);
        e.setApellido(ape);
        e.setDni(dni);
        e.setCelular(cel);
        e.setDireccion(dir);
        e.setUsuario(user);
        e.setPassword(pass);
        
        serviceE.Guardar(e);
        return MostrarEmp(model);
    }
    
    
    @GetMapping("/orden_ascE")
    public String OrdenarAscEmp(Model model){
        List<Empleado> empleados = serviceE.OrdenAscendente();
        model.addAttribute("empleados",empleados);
        return carpeta+"listaEmpleados";
    }
    
    @GetMapping("/orden_descE")
    public String OrdenarDescEmp(Model model){
        List<Empleado> empleados = serviceE.OrdenDescendente();
        model.addAttribute("empleados",empleados);
        return carpeta+"listaEmpleados";
    }
    
}
