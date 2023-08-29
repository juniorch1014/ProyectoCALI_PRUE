/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectoSW.Cliente;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService{
    @Autowired
    private ICliente data;
    
    @Override
    public List<Cliente> Listar() {
       return (List<Cliente>) data.findAll();
    }

    @Override
    public Optional<Cliente> ConsultarId(int id) {
       return data.findById(id);
    }

    @Override
    public void Guardar(Cliente p) {
        data.save(p);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }

    @Override
    public List<Cliente> Buscar(String dato) {
        return data.buscarPorTodo(dato);
    }

    @Override
    public List<Cliente> OrdenAscendente() {
        return data.OrderAscCli();
    }

    @Override
    public List<Cliente> OrdenDescendente() {
        return data.OrderDescCli();
    }
}
