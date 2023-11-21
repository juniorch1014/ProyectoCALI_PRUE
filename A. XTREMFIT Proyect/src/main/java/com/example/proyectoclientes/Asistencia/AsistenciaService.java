/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectoclientes.Asistencia;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsistenciaService implements AsistenciaInterface{
    
    @Autowired
    private AsistenciaRepository data;
    
    @Override
    public List<Asistencia> Listar() {
        return (List<Asistencia>) data.findAll();
    }

    @Override
    public Optional<Asistencia> ConsularId(int id) {
        return data.findById(id);
    }

    @Override
    public void Guardar(Asistencia a) {
        data.save(a);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }

    @Override
    public List<Asistencia> Buscar(String dato) {
        return data.buscarPorTodo(dato);
    }

    @Override
    public List<Asistencia> OrdenAscendente() {
        return data.OrderAscReg();
    }
    
    @Override
    public List<Asistencia> OrdenDescendente() {
        return data.OrderDescReg();
    }

    @Override
    public List<Asistencia> RegistroPorEmpleado(int id) {
        return data.RegistroPorEmpleado(id);
    }
    
}
