
package com.example.proyectoSW.Registro;

import com.example.proyectoSW.Cliente.Cliente;
import com.example.proyectoSW.Empleado.Empleado;
import com.example.proyectoSW.Servicio.Servicio;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.Generated;
import org.springframework.format.annotation.DateTimeFormat;


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
