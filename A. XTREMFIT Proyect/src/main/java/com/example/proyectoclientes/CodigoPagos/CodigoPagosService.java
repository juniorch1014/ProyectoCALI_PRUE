/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectoclientes.CodigoPagos;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LN_JCHG
 */
@Service
public class CodigoPagosService implements CodigoPagosInterface{
    
    @Autowired
    private CodigoPagosRepository data;
    @Override
    public List<CodigoPagos> Listar() {
        return (List<CodigoPagos>) data.findAll();
    }

    @Override
    public Optional<CodigoPagos> ConsularId(int id) {
        return data.findById(id);
    }

    @Override
    public void Guardar(CodigoPagos cp) {
        data.save(cp);
    }

    @Override
    public void Eliminar(int id) {
         data.deleteById(id);
    }

    @Override
    public List<CodigoPagos> Buscar(String dato) {
        return data.buscarPorTodo(dato);
    }

    @Override
    public List<CodigoPagos> OrdenAscendente() {
        return data.OrderAscReg();
    }

    @Override
    public List<CodigoPagos> OrdenDescendente() {
        return data.OrderDescReg();
    }
    
}
