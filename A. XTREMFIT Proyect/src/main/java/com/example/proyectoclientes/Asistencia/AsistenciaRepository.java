/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectoclientes.Asistencia;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsistenciaRepository extends CrudRepository<Asistencia, Integer>{
    
    @Query(value = " SELECT * FROM asistencia "
            + " INNER JOIN empleado ON asistencia.usuario_id = empleado.id "
            + " WHERE empleado.nombre LIKE %?1% "
            + " OR hora  LIKE %?1% "
            + " OR dia LIKE %?1% "
            + " OR mes LIKE %?1% "
            + " OR año LIKE %?1% "
            + " OR estado LIKE %?1% ", nativeQuery = true)
    List<Asistencia> buscarPorTodo(String dato);
    
    @Query(value = "SELECT * FROM asistencia "
            + " INNER JOIN empleado ON asistencia.usuario_id = empleado.id "
            + " ORDER BY asistencia.fecha ASC", nativeQuery = true)
    List<Asistencia> OrderAscReg();

    @Query(value = "SELECT * FROM asistencia "
            + " INNER JOIN empleado ON asistencia.usuario_id = empleado.id "
            + " ORDER BY asistencia.fecha DESC", nativeQuery = true)
    List<Asistencia> OrderDescReg();
    
    @Query(value = "SELECT* FROM asistencia "
            + " INNER JOIN empleado ON asistencia.usuario_id = empleado.id "
            + " WHERE asistencia.usuario_id LIKE ?1", nativeQuery = true)
    List<Asistencia> RegistroPorEmpleado(int id);
}
