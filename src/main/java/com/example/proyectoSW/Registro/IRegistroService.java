/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.proyectoSW.Registro;

import com.example.proyectoSW.Servicio.*;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author player
 */
public interface IRegistroService {
    public List<Registro> Listar();
    public Optional<Registro> ConsultarId(int id);
    public void Guardar(Registro r);
    public void Eliminar(int id);
    public List<Registro> Buscar(String dato);
    public List<Registro> OrdenAscendente();
    public List<Registro> OrdenDescendente();
    public List<Registro> RegistroPorCliente(int id);
}
