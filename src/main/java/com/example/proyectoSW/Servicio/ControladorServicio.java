/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectoSW.Servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/servicio/") //http://localhost/empleado/
@Controller
public class ControladorServicio {
    
    String carpeta="Servicios/";
    
    @Autowired
    private IServicioService serviceS;
    
    @GetMapping("/")
    public String MostrarServ(Model model){
        
        List<Servicio> servicios=serviceS.Listar();
        model.addAttribute("servicios",servicios);
        return carpeta+"listaServicios";//listaClientes.html
    }
    
    @PostMapping("/buscarS")
    public String BuscarServ(@RequestParam("dato") String dato, Model model){
        
        List<Servicio> servicios=serviceS.Buscar(dato);
        model.addAttribute("servicios",servicios);
        return carpeta+"listaServicios";//listaClientes.html
    }
    
    @GetMapping("/eliminarS")
    public String EliminarServ(@RequestParam("id") int id, Model model){
        serviceS.Eliminar(id);
        return MostrarServ(model);
    }
    
    @PostMapping("/registrarS")
    public String RegistrarServ(@RequestParam("nom") String nom,
                            @RequestParam("prec") float prec,
                            Model model){
        
        Servicio s = new Servicio();
        s.setNombre(nom);
        s.setPrecio(prec);
        
        serviceS.Guardar(s);
        return MostrarServ(model);
    }
    
    @PostMapping("/actualizarS")
    public String ActualizarServ(@RequestParam("id") int id,
                            @RequestParam("nombre") String nom,
                            @RequestParam("precio") float prec,
                            Model model){
        
        Servicio s = new Servicio();
        s.setId(id);
        s.setNombre(nom);
        s.setPrecio(prec);
        
        serviceS.Guardar(s);
        return MostrarServ(model);
    }
    
    
    @GetMapping("/orden_ascS")
    public String OrdenarAscServ(Model model){
        List<Servicio> servicios = serviceS.OrdenAscendente();
        model.addAttribute("servicios",servicios);
        return carpeta+"listaServicios";
    }
    
    @GetMapping("/orden_descS")
    public String OrdenarDescServ(Model model){
        List<Servicio> servicios = serviceS.OrdenDescendente();
        model.addAttribute("servicios",servicios);
        return carpeta+"listaServicios";
    }
    
   /*@GetMapping("/PaginaServicios")
    public String listServicios(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        int pageSize = 20; // Tamaño de la página
        Page<Servicio> serviciosPage = serviceS.getServiciosPaginados(page, pageSize);

        model.addAttribute("servicios", serviciosPage.getContent());
        model.addAttribute("totalPages", serviciosPage.getTotalPages());
        model.addAttribute("currentPage", page);

        return carpeta+"listaServicios";
    }*/
    
}
