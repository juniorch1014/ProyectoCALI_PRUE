/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.proyectoclientes.Empleado;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author player
 */
public interface IEmpleadoService {
    public List<Empleado> Listar();
    public Optional<Empleado> ConsultarId(int id);
    public void Guardar(Empleado p);
    public void Eliminar(int id);
    public List<Empleado> Buscar(String dato);
    public List<Empleado> OrdenAscendente();
    public List<Empleado> OrdenDescendente();
}
