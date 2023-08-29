/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectoSW.Registro;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroService implements IRegistroService{
    
    @Autowired
    private IRegistro data;
    
    @Override
    public List<Registro> Listar() {
       return (List<Registro>) data.findAll();
    }

    @Override
    public Optional<Registro> ConsultarId(int id) {
       return data.findById(id);
    }

    @Override
    public void Guardar(Registro r) {
        data.save(r);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }

    @Override
    public List<Registro> Buscar(String dato) {
        return data.buscarPorTodo(dato);
    }

    @Override
    public List<Registro> OrdenAscendente() {
        return data.OrderAscReg();
    }

    @Override
    public List<Registro> OrdenDescendente() {
        return data.OrderDescReg();
    }

    @Override
    public List<Registro> RegistroPorCliente(int id) {
        return data.RegistroPorCliente(id);
    }
}
