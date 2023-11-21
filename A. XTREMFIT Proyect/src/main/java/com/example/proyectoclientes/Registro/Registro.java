
package com.example.proyectoclientes.Registro;

import com.example.proyectoclientes.Cliente.Cliente;
import com.example.proyectoclientes.Empleado.Empleado;
import com.example.proyectoclientes.servicio.Servicio;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Data;


@Data
@Entity
@Table(name="registro")
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int dia;
    private int mes;
    private int anho;
    private int hora;
    private int minuto;
    private String fecha;
    private int duracion_serv;
    private float costo_total;
    private LocalDate fechaLocal;
    private LocalDate fechaFinal;
    private int diasFaltantes;

    
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
