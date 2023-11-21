package com.example.proyectoclientes.CodigoPagos;

import java.util.List;
import java.util.Optional;


public interface CodigoPagosInterface {
    public List<CodigoPagos> Listar();
    public Optional<CodigoPagos> ConsularId(int id);
    public void Guardar(CodigoPagos a);
    public void Eliminar(int id);
    public List<CodigoPagos> Buscar(String dato);
    public List<CodigoPagos> OrdenAscendente();
    public List<CodigoPagos> OrdenDescendente();
}
