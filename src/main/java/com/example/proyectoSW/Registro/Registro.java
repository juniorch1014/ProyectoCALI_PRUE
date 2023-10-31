
package com.example.proyectoSW.Registro;

import com.example.proyectoSW.Cliente.Cliente;
import com.example.proyectoSW.Empleado.Empleado;
import com.example.proyectoSW.Servicio.Servicio;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="registro")
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fecha;
    private int duracion_serv;
    private float costo_total;       
    
    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name="empleado_id")
    private Empleado empleado;
    
    @ManyToOne
    @JoinColumn(name="servicio_id")
    private Servicio servicio;
}
