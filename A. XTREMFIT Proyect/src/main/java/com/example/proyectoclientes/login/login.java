/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectoclientes.login;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="login")
public class login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    /*@OneToOne
    @JoinColumn(name="empleado_id")*/
    private int id_empleado;
    
    
}
