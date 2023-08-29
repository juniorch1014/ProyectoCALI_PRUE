/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectoSW.Cliente;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/cliente/") //http://localhost/empleado/
@Controller
public class ControladorCliente {
    
    String carpeta="Clientes/";
    
    @Autowired
    private IClienteService serviceC;
    
    @GetMapping("/")
    public String MostrarCliente(Model model){
        
        List<Cliente> clientes=serviceC.Listar();
        model.addAttribute("clientes",clientes);
        return carpeta+"listaClientes";//listaClientes.html
    }
    
    @PostMapping("/buscarC")
    public String BuscarCliente(@RequestParam("dato") String dato, Model model){
        
        List<Cliente> clientes=serviceC.Buscar(dato);
        model.addAttribute("clientes",clientes);
        return carpeta+"listaClientes";//listaClientes.html
    }
    
    @GetMapping("/eliminarC")
    public String EliminarCliente(@RequestParam("id") int id, Model model){
        serviceC.Eliminar(id);
        return MostrarCliente(model);
    }
    
    @PostMapping("/registrarC")
    public String RegistrarCliente(@RequestParam("nom") String nom,
                            @RequestParam("ape") String ape,
                            @RequestParam("dni") String dni,
                            @RequestParam("cel") String cel,
                            @RequestParam("email") String email,
                            @RequestParam("dir") String dir,
                            Model model){
        
        Cliente c = new Cliente();
        c.setNombre(nom);
        c.setApellido(ape);
        c.setDni(dni);
        c.setCelular(cel);
        c.setEmail(email);
        c.setDireccion(dir);
        
        serviceC.Guardar(c);
        return MostrarCliente(model);
    }
    
    @PostMapping("/actualizarC")
    public String ActualizarCliente(@RequestParam("id") int id,
                            @RequestParam("nombre") String nom,
                            @RequestParam("apellido") String ape,
                            @RequestParam("dniC") String dni,
                            @RequestParam("celular") String cel,
                            @RequestParam("emailC") String email,
                            @RequestParam("direccion") String dir,
                            Model model){
        
        Cliente c = new Cliente();
        c.setId(id);
        c.setNombre(nom);
        c.setApellido(ape);
        c.setDni(dni);
        c.setCelular(cel);
        c.setEmail(email);
        c.setDireccion(dir);
        
        serviceC.Guardar(c);
        return MostrarCliente(model);
    }
    
    
    @GetMapping("/orden_ascC")
    public String OrdenarAscCli(Model model){
        List<Cliente> clientes = serviceC.OrdenAscendente();
        model.addAttribute("clientes",clientes);
        return carpeta+"listaClientes";
    }
    
    @GetMapping("/orden_descC")
    public String OrdenarDescCli(Model model){
        List<Cliente> clientes = serviceC.OrdenDescendente();
        model.addAttribute("clientes",clientes);
        return carpeta+"listaClientes";
    }
}
