/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectoSW.login;

import com.example.proyectoSW.Empleado.Empleado;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
