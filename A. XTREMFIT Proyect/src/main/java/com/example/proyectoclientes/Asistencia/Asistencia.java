
package com.example.proyectoclientes.Asistencia;

import com.example.proyectoclientes.Empleado.Empleado;
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
@Table(name="asistencia")
public class Asistencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String hora;
    private String dia;
    private String mes;
    private String anho;
    private String estado;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Empleado empleado;
    
    
}
