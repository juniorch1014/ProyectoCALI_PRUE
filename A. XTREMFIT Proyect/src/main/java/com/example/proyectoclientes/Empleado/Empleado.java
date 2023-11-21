/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectoclientes.Empleado;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //Autoincremental
    private int id;
    private String dni;
    private String nombre;
    private String apellido;
    private String direccion;
    private String celular;
    private String usuario;
    private String password;
}
