/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectoSW.Reporte;

import com.example.proyectoSW.Cliente.Cliente;
import com.example.proyectoSW.Cliente.IClienteService;
import com.example.proyectoSW.Empleado.Empleado;
import com.example.proyectoSW.Empleado.IEmpleadoService;
import com.example.proyectoSW.Registro.IRegistroService;
import com.example.proyectoSW.Registro.Registro;
import com.example.proyectoSW.Servicio.IServicioService;
import com.example.proyectoSW.Servicio.Servicio;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/reporte/")
@Controller
public class ControladorReporte {

    String carpeta = "Reporte/";

    @Autowired
    private IClienteService serviceC;

    @Autowired
    private IEmpleadoService serviceE;

    @Autowired
    private IServicioService serviceS;

    @Autowired
    private IRegistroService serviceR;

    @GetMapping("/")
    public String reporte(Model model) {

        List<Cliente> clientes = serviceC.Listar();
        List<Empleado> empleados = serviceE.Listar();
        List<Servicio> servicios = serviceS.Listar();
        List<Registro> registros = serviceR.Listar();

        model.addAttribute("nroClientes", clientes.size());
        model.addAttribute("nroEmpleados", empleados.size());
        model.addAttribute("nroServicios", servicios.size());
        model.addAttribute("nroRegistros", registros.size());

        float total = 0;
        for (int i = 0; i < registros.size(); i++) {
            total += registros.get(i).getCosto_total();
        }
        model.addAttribute("total", total);

        Map<String, Integer> graphData = new TreeMap<>();
        for (int j = 0; j < clientes.size(); j++) {
            int id = clientes.get(j).getId();
            String nombre = clientes.get(j).getNombre();
            

            registros = serviceR.RegistroPorCliente(id);
            int cant = registros.size();

            graphData.put(nombre, cant);

        }
        model.addAttribute("graphData", graphData);


        return carpeta + "reporte";
    }

}
