/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.proyectoclientes.Cliente;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author player
 */
public interface IClienteService {
    public List<Cliente> Listar();
    public Optional<Cliente> ConsultarId(int id);
    public void Guardar(Cliente p);
    public void Eliminar(int id);
    public List<Cliente> Buscar(String dato);
    public List<Cliente> OrdenAscendente();
    public List<Cliente> OrdenDescendente();
}
