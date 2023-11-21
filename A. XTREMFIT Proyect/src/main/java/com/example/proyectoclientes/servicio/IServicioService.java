/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.proyectoclientes.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;

/**
 *
 * @author player
 */
public interface IServicioService {
    public List<Servicio> Listar();
    public Optional<Servicio> ConsultarId(int id);
    public void Guardar(Servicio p);
    public void Eliminar(int id);
    public List<Servicio> Buscar(String dato);
    public List<Servicio> OrdenAscendente();
    public List<Servicio> OrdenDescendente();
   // public Page<Servicio> getServiciosPaginados(int page, int pageSize);
}
