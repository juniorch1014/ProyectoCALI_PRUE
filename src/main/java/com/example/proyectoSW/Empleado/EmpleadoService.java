/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectoSW.Empleado;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService implements IEmpleadoService{
    
    @Autowired
    private IEmpleado data;
    
    @Override
    public List<Empleado> Listar() {
       return (List<Empleado>) data.findAll();
    }

    @Override
    public Optional<Empleado> ConsultarId(int id) {
       return data.findById(id);
    }

    @Override
    public void Guardar(Empleado p) {
        data.save(p);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }

    @Override
    public List<Empleado> Buscar(String dato) {
        return data.buscarPorTodo(dato);
    }

    @Override
    public List<Empleado> OrdenAscendente() {
        return data.OrderAscEmp();
    }

    @Override
    public List<Empleado> OrdenDescendente() {
        return data.OrderDescEmp();
    }
    
}
