
package com.example.proyectoSW.Asistencia;

import com.example.proyectoSW.Empleado.Empleado;
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
    private String año;
    private int estado;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Empleado empleado;
    
    
}
