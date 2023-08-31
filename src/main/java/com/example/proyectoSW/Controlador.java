/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectoSW;

import com.example.proyectoSW.Cliente.Cliente;
import com.example.proyectoSW.Cliente.IClienteService;
import com.example.proyectoSW.Empleado.Empleado;
import com.example.proyectoSW.Empleado.IEmpleadoService;
import com.example.proyectoSW.Registro.IRegistroService;
import com.example.proyectoSW.Registro.Registro;
import com.example.proyectoSW.Servicio.IServicioService;
import com.example.proyectoSW.Servicio.Servicio;
import com.example.proyectoSW.login.ILoginService;
import com.example.proyectoSW.login.login;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author player
 */
@Controller
public class Controlador {
    
    
    @Autowired
    private IEmpleadoService serviceE;
    
    @Autowired
    private IClienteService serviceC;

    @Autowired
    private IServicioService serviceS;

    @Autowired
    private IRegistroService serviceR;
    
    @Autowired
    private ILoginService serviceL;
    
    String carpeta="Registro/";
    
    Empleado aux = new Empleado();
    
    @GetMapping("/")
    public String Login(Model model){
                model.addAttribute("empleado", aux);
                
                List<Cliente> clientes = serviceC.Listar();
                model.addAttribute("clientes", clientes);
                
                List<Servicio> servicios = serviceS.Listar();
                model.addAttribute("servicios", servicios);
                
                List<Registro> registros = serviceR.Listar();
                model.addAttribute("registros", registros);
        return "login";
    }
    
    
    @PostMapping("/ingresar")
    public String Ingresar(@RequestParam("user") String user, 
                        @RequestParam("password") String pass, 
                        Model model)
    {    
        List<Empleado> empleados=serviceE.Listar();
        
        for(int i=0;i<empleados.size();i++){
            if(empleados.get(i).getUsuario().equals(user) && empleados.get(i).getPassword().equals(pass)){
                
                aux.setId(empleados.get(i).getId());
                aux.setNombre(empleados.get(i).getNombre());
                aux.setApellido(empleados.get(i).getApellido());
                aux.setDni(empleados.get(i).getDni());
                aux.setCelular(empleados.get(i).getCelular());
                aux.setDireccion(empleados.get(i).getDireccion());
                aux.setUsuario(empleados.get(i).getUsuario());
                aux.setPassword(empleados.get(i).getPassword());
                
                
                login l = new login();
                l.setId_empleado(aux.getId());
                serviceL.Guardar(l);
                
                //List<login> logeo= serviceL.Listar();
                
                model.addAttribute("empleado", aux);
                
                List<Cliente> clientes = serviceC.Listar();
                model.addAttribute("clientes", clientes);
                
                List<Servicio> servicios = serviceS.Listar();
                model.addAttribute("servicios", servicios);
                
                List<Registro> registros = serviceR.Listar();
                model.addAttribute("registros", registros);
                
                return "inicio";
            }       
        }
        
        return "login";
    }
    @PostMapping("/registrarUs")
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
        return "login";
    }
    
    @PostMapping("/registrarPl")
    public String RegistrarPl(@RequestParam("emp") Empleado emp,
            @RequestParam("cli") Cliente cli,
            @RequestParam("ser") Servicio ser,
            @RequestParam("dur") int dur,
            Model model) {

        Registro r = new Registro();

        r.setEmpleado(emp);
        r.setCliente(cli);
        r.setServicio(ser);
        r.setDuracion_serv(dur);

        Calendar fecha = Calendar.getInstance();

        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        int segundo = fecha.get(Calendar.SECOND);

        String fe = String.valueOf(dia + "/" + mes + "/" + año + " || " + hora + ":" + minuto + ":" + segundo);

        r.setFecha(fe);

        String nombreServicio = r.getServicio().getNombre().toString();

        List<Servicio> servicios = serviceS.Listar();
        model.addAttribute("servicios", servicios);

        for (int pos = 0; pos < servicios.size(); pos++) {
            if (servicios.get(pos).getNombre().equals(ser.getNombre())) {
                float total = dur * servicios.get(pos).getPrecio();
                r.setCosto_total(total);
            }
        }

        serviceR.Guardar(r);
        return "planesMostrar";
    }
    
    @GetMapping("/inicio")
    public String inicio(Model model){
                model.addAttribute("empleado", aux);
                
                List<Cliente> clientes = serviceC.Listar();
                model.addAttribute("clientes", clientes);
                
                List<Servicio> servicios = serviceS.Listar();
                model.addAttribute("servicios", servicios);
                
                List<Registro> registros = serviceR.Listar();
                model.addAttribute("registros", registros);        
        return "inicio";
    }
    @GetMapping("/planesMostrar")
    public String PlanesMostrar(Model model){
                List<Empleado> empleados=serviceE.Listar();
                model.addAttribute("empleado", aux);
                
                List<Cliente> clientes = serviceC.Listar();
                model.addAttribute("clientes", clientes);
                
                List<Servicio> servicios = serviceS.Listar();
                model.addAttribute("servicios", servicios);
                
                List<Registro> registros = serviceR.Listar();
                model.addAttribute("registros", registros);        
        return "planesMostrar";
    }
   
    
}
