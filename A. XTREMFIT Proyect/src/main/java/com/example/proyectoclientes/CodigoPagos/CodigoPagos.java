package com.example.proyectoclientes.CodigoPagos;

import com.example.proyectoclientes.Cliente.Cliente;
import com.example.proyectoclientes.Empleado.Empleado;
import com.example.proyectoclientes.Registro.Registro;
import com.example.proyectoclientes.servicio.Servicio;
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
@Table(name="codigopago")
public class CodigoPagos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String codigo;
    private float costo_total;
    private String estado;
    
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Empleado empleado;
    
    @ManyToOne
    @JoinColumn(name = "registro_id")
    private Registro registro;
    
    @ManyToOne
    @JoinColumn(name="servicio_id")
    private Servicio servicio;
    
    @ManyToOne
    @JoinColumn(name="entrenador_id")
    private Cliente cliente;
    
}
