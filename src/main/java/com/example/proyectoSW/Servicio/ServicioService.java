/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectoSW.Servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioService implements IServicioService{
    
    @Autowired
    private IServicio data;
    
    @Override
    public List<Servicio> Listar() {
       return (List<Servicio>) data.findAll();
    }

    @Override
    public Optional<Servicio> ConsultarId(int id) {
       return data.findById(id);
    }

    @Override
    public void Guardar(Servicio p) {
        data.save(p);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }

    @Override
    public List<Servicio> Buscar(String dato) {
        return data.buscarPorTodo(dato);
    }

    @Override
    public List<Servicio> OrdenAscendente() {
        return data.OrderAscServ();
    }

    @Override
    public List<Servicio> OrdenDescendente() {
        return data.OrderDescServ();
    }
}
