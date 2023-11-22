package com.example.proyectoclientes.Asistencia;

import java.util.List;
import java.util.Optional;

public interface AsistenciaInterface {
    public List<Asistencia> Listar();
    public Optional<Asistencia> ConsularId(int id);
    public void Guardar(Asistencia a);
    public void Eliminar(int id);
    public List<Asistencia> Buscar(String dato);
    public List<Asistencia> OrdenAscendente();
    public List<Asistencia> OrdenDescendente();
    public List<Asistencia> RegistroPorEmpleado(int id);


}
