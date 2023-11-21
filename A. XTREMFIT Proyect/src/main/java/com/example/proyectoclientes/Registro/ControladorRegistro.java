/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectoclientes.Registro;

import com.example.proyectoclientes.Cliente.Cliente;
import com.example.proyectoclientes.Cliente.IClienteService;
import com.example.proyectoclientes.Empleado.Empleado;
import com.example.proyectoclientes.Empleado.IEmpleadoService;
import com.example.proyectoclientes.servicio.IServicioService;
import com.example.proyectoclientes.servicio.Servicio;
import com.example.proyectoclientes.login.ILoginService;
import com.example.proyectoclientes.login.login;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Calendar;

@RequestMapping("/registro/") //http://localhost/empleado/
@Controller
public class ControladorRegistro {

    String carpeta = "Registro/";

    @Autowired
    private IClienteService serviceC;

    @Autowired
    private IEmpleadoService serviceE;

    @Autowired
    private IServicioService serviceS;

    @Autowired
    private IRegistroService serviceR;
    
    @Autowired
    private ILoginService serviceL;
    
    Empleado aux = new Empleado();

    @GetMapping("/")
    public String MostrarRegistro(Model model) {

        List<Cliente> clientes = serviceC.Listar();
        model.addAttribute("clientes", clientes);

        List<login> logeo = serviceL.Listar();
        
        int a= logeo.size()-1;
        
        List<Empleado> empleados = serviceE.Listar();
        
        for(int i=0;i<empleados.size();i++){
            if(empleados.get(i).getId() == (logeo.get(a).getId_empleado())){
                aux.setId(empleados.get(i).getId());
                aux.setNombre(empleados.get(i).getNombre());
                aux.setApellido(empleados.get(i).getApellido());
                aux.setDni(empleados.get(i).getDni());
                aux.setCelular(empleados.get(i).getCelular());
                aux.setDireccion(empleados.get(i).getDireccion());
                aux.setUsuario(empleados.get(i).getUsuario());
                aux.setPassword(empleados.get(i).getPassword());
            }
        }
    
        model.addAttribute("empleado", aux);
        

        List<Servicio> servicios = serviceS.Listar();
        model.addAttribute("servicios", servicios);

        List<Registro> registros = serviceR.Listar();
        model.addAttribute("registros", registros);

        return carpeta + "listaRegistros";//listaClientes.html
    }

    @PostMapping("/buscarR")
    public String BuscarCliente(@RequestParam("dato") String dato, Model model) {

        List<Registro> registros = serviceR.Buscar(dato);
        model.addAttribute("registros", registros);
        return carpeta + "listaRegistros";//listaClientes.html
    }

    @GetMapping("/eliminarR")
    public String EliminarCliente(@RequestParam("id") int id, Model model) {
        serviceR.Eliminar(id);
        return MostrarRegistro(model);
    }

    @PostMapping("/registrarR")
    public String RegistrarCliente(@RequestParam("emp") Empleado emp,
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
        return MostrarRegistro(model);
    }

    @PostMapping("/actualizarR")
    public String ActualizarCliente(@RequestParam("id") int id,
            @RequestParam("emp") Empleado emp,
            @RequestParam("cli") Cliente cli,
            @RequestParam("ser") Servicio ser,
            @RequestParam("dur") int dur,
            Model model) {

        Registro r = new Registro();

        r.setId(id);
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
        return MostrarRegistro(model);
    }

    @GetMapping("/orden_ascR")
    public String OrdenarAscReg(Model model) {

        List<Registro> registros = serviceR.OrdenAscendente();
        model.addAttribute("registros", registros);

        List<Cliente> clientes = serviceC.Listar();
        model.addAttribute("clientes", clientes);

        List<Empleado> empleados = serviceE.Listar();
        model.addAttribute("empleados", empleados);

        List<Servicio> servicios = serviceS.Listar();
        model.addAttribute("servicios", servicios);

        return carpeta + "listaRegistros";
    }

    @GetMapping("/orden_descR")
    public String OrdenarDescReg(Model model) {

        List<Registro> registros = serviceR.OrdenDescendente();
        model.addAttribute("registros", registros);

        List<Cliente> clientes = serviceC.Listar();
        model.addAttribute("clientes", clientes);

        List<Empleado> empleados = serviceE.Listar();
        model.addAttribute("empleados", empleados);

        List<Servicio> servicios = serviceS.Listar();
        model.addAttribute("servicios", servicios);

        return carpeta + "listaRegistros";
    }
}
