/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectoclientes;

import com.example.proyectoclientes.Asistencia.Asistencia;
import com.example.proyectoclientes.Asistencia.AsistenciaService;
import com.example.proyectoclientes.Cliente.Cliente;
import com.example.proyectoclientes.Cliente.IClienteService;
import com.example.proyectoclientes.CodigoPagos.CodigoPagos;
import com.example.proyectoclientes.CodigoPagos.CodigoPagosService;
import com.example.proyectoclientes.Empleado.Empleado;
import com.example.proyectoclientes.Empleado.IEmpleadoService;
import com.example.proyectoclientes.Registro.IRegistroService;
import com.example.proyectoclientes.Registro.Registro;
import com.example.proyectoclientes.servicio.IServicioService;
import com.example.proyectoclientes.servicio.Servicio;
import com.example.proyectoclientes.login.ILoginService;
import com.example.proyectoclientes.login.login;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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
    
    @Autowired
    private AsistenciaService serviceA;
    
    @Autowired
    private CodigoPagosService serviceCP;
    
    String carpeta="Registro/";
    
    Empleado aux = new Empleado();
    
    
    @GetMapping("/")
    public String PrimerInicio(Model model){
                List<Empleado> empleados=serviceE.Listar();                
                 model.addAttribute("empleado", empleados);
        
                List<Servicio> servicios = serviceS.Listar();
                model.addAttribute("servicios", servicios);
                
                List<CodigoPagos> codigoPagos = serviceCP.Listar();
                model.addAttribute("codigoPagos", codigoPagos);
                
        return  "/ZInicios/primerInicio.html";
    }
    
    @GetMapping("/login")
    public String Login(Model model){
                
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
                
                List<Asistencia> asistencias = serviceA.Listar();
                model.addAttribute("asistencias",asistencias);
                
                List<CodigoPagos> codigoPagos = serviceCP.Listar();
                model.addAttribute("codigoPagos", codigoPagos);
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
    //***PLAaaaaaaaaaaaaaaaaaaaNes
    @PostMapping("/registrarPlan")
    public String RegistrarPlan(@RequestParam("emp") Empleado emp,
            @RequestParam("cli") Cliente cli,
            @RequestParam("ser") Servicio ser,
            @RequestParam("dur") int dur,
            Model model) {
                
                model.addAttribute("empleado", aux);
                
                List<Cliente> clientes = serviceC.Listar();
                model.addAttribute("clientes", clientes);
                
                List<Servicio> servicios = serviceS.Listar();
                model.addAttribute("servicios", servicios);
                
                List<Registro> registros = serviceR.Listar();
                model.addAttribute("registros", registros);
                
                List<Asistencia> asistencias = serviceA.Listar();
                model.addAttribute("asistencias",asistencias);
                
                List<CodigoPagos> codigoPagos = serviceCP.Listar();
                model.addAttribute("codigoPagos", codigoPagos);
        
        Registro r = new Registro();

        r.setEmpleado(emp);
        r.setCliente(cli);
        r.setServicio(ser);
        r.setDuracion_serv(dur);

        Calendar fecha = Calendar.getInstance();

        int año = fecha.get(Calendar.YEAR);
        r.setAnho(año);
        int mes = fecha.get(Calendar.MONTH);
        r.setMes(mes);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        r.setDia(dia);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        r.setHora(hora);
        int minuto = fecha.get(Calendar.MINUTE);
        r.setMinuto(minuto);
        int segundo = fecha.get(Calendar.SECOND);

        String fe = String.valueOf(dia + "/" + mes + "/" + año + " || " + hora + ":" + minuto + ":" + segundo);

        r.setFecha(fe);
        
        LocalDate fechaActual = LocalDate.now();
        r.setFechaLocal(fechaActual);
        LocalDate nuevaFecha = fechaActual.plusMonths(dur);
        r.setFechaFinal(nuevaFecha);
        
        // Calcula la diferencia en días
        int diasFaltantes = (int) ChronoUnit.DAYS.between(fechaActual, nuevaFecha);

        // Imprime la cantidad de días que faltan como un número entero
        r.setDiasFaltantes(diasFaltantes);
      
        String nombreServicio = r.getServicio().getNombre().toString();
        
        float total = 0;
        for (int pos = 0; pos < servicios.size(); pos++) {
            if (servicios.get(pos).getNombre().equals(ser.getNombre())) {
                total = dur * servicios.get(pos).getPrecio();
                r.setCosto_total(total);
            }
        }
        
        
        ///////////CODIGO//////////
        for(int i = 0; i<dur; i++){
            CodigoPagos cp = new CodigoPagos();
            cp.setEmpleado(emp);
            cp.setCliente(cli);
            //cp.setRegistro(r);
            cp.setServicio(ser);
            cp.setCosto_total(total);
            
            String codigoG = GenerarCodigo();
                
            cp.setCodigo(codigoG);
            cp.setEstado("Por Pagar");
            serviceCP.Guardar(cp);
        }
        
        serviceR.Guardar(r);
        
        return "planesMostrar";
    }
    
    public String GenerarCodigo(){
        
            String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            SecureRandom random = new SecureRandom();
            StringBuilder codigoGenerado = new StringBuilder();

            for (int i = 0; i < 8; i++) {
                int index = random.nextInt(caracteres.length());
                codigoGenerado.append(caracteres.charAt(index));
            }

            System.out.println("Código Generado: " + codigoGenerado.toString());
            return codigoGenerado.toString();

    }
    
    
    
    @PostMapping("/registrarAsistencia")
    public String RegistrarAsist(@RequestParam("hora") String hora,
                                 @RequestParam("dia") String dia,
                                 @RequestParam("mes") String mes,
                                 @RequestParam("anho") String año,
                                 @RequestParam("est") String estado,
                                 
                                 Model model){
                model.addAttribute("empleado", aux);
                
                List<Cliente> clientes = serviceC.Listar();
                model.addAttribute("clientes", clientes);
                
                List<Servicio> servicios = serviceS.Listar();
                model.addAttribute("servicios", servicios);
                
                List<Registro> registros = serviceR.Listar();
                model.addAttribute("registros", registros);
                
                List<Asistencia> asistencias = serviceA.Listar();
                model.addAttribute("asistencias",asistencias);
                
                List<CodigoPagos> codigoPagos = serviceCP.Listar();
                model.addAttribute("codigoPagos", codigoPagos);
        
        Asistencia a = new Asistencia();
        a.setHora(hora);
        a.setDia(dia);
        a.setMes(mes);
        a.setAnho(año);
        a.setEstado(estado);
        a.setEmpleado(aux);
        
        serviceA.Guardar(a);
        
        return "pageCalendario";
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
                
                List<Asistencia> asistencias = serviceA.Listar();
                model.addAttribute("asistencias",asistencias);
                
                List<CodigoPagos> codigoPagos = serviceCP.Listar();
                model.addAttribute("codigoPagos", codigoPagos);
        return "inicio";
    }
    @GetMapping("/planesMostrar")
    public String PlanesMostrar(Model model){
         
                model.addAttribute("empleado", aux);
                
                List<Cliente> clientes = serviceC.Listar();
                model.addAttribute("clientes", clientes);
                
                List<Servicio> servicios = serviceS.Listar();
                model.addAttribute("servicios", servicios);
                
                List<Registro> registros = serviceR.Listar();
                model.addAttribute("registros", registros); 
                
                List<Asistencia> asistencias = serviceA.Listar();
                model.addAttribute("asistencias",asistencias);
                
                List<CodigoPagos> codigoPagos = serviceCP.Listar();
                model.addAttribute("codigoPagos", codigoPagos);
        return "planesMostrar";
    }
    @GetMapping("/pageNoticia")
    public String PageNoticias(Model model){
                List<Empleado> empleados=serviceE.Listar();
                model.addAttribute("empleado", aux);
                
                List<Cliente> clientes = serviceC.Listar();
                model.addAttribute("clientes", clientes);
                
                List<Servicio> servicios = serviceS.Listar();
                model.addAttribute("servicios", servicios);
                
                List<Registro> registros = serviceR.Listar();
                model.addAttribute("registros", registros); 
                List<Asistencia> asistencias = serviceA.Listar();
                
                model.addAttribute("asistencias",asistencias);
                
                List<CodigoPagos> codigoPagos = serviceCP.Listar();
                model.addAttribute("codigoPagos", codigoPagos);
        return  "/ZInicios/pageNoticia.html";
    }
    @GetMapping("/pageRecomendacion")
    public String PageRecomendaciones(Model model){
                List<Empleado> empleados=serviceE.Listar();
                model.addAttribute("empleado", aux);
                
                List<Cliente> clientes = serviceC.Listar();
                model.addAttribute("clientes", clientes);
                
                List<Servicio> servicios = serviceS.Listar();
                model.addAttribute("servicios", servicios);
                
                List<Registro> registros = serviceR.Listar();
                model.addAttribute("registros", registros); 
                
                List<Asistencia> asistencias = serviceA.Listar();
                model.addAttribute("asistencias",asistencias);
                
                List<CodigoPagos> codigoPagos = serviceCP.Listar();
                model.addAttribute("codigoPagos", codigoPagos);
                
        return  "/ZInicios/pageRecomendacion.html";
    }
    @GetMapping("/pageCalendario")
    public String Pagecalendario(Model model){
                List<Empleado> empleados=serviceE.Listar();
                model.addAttribute("empleado", aux);
                
                List<Cliente> clientes = serviceC.Listar();
                model.addAttribute("clientes", clientes);
                
                List<Servicio> servicios = serviceS.Listar();
                model.addAttribute("servicios", servicios);
                
                List<Registro> registros = serviceR.Listar();
                model.addAttribute("registros", registros); 
                
                List<Asistencia> asistencias = serviceA.Listar();
                model.addAttribute("asistencias",asistencias);
                
                List<CodigoPagos> codigoPagos = serviceCP.Listar();
                model.addAttribute("codigoPagos", codigoPagos);
        return  "/ZInicios/pageCalendario.html";
    }

    
}
