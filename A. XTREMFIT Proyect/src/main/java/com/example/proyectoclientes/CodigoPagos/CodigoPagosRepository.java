/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.proyectoclientes.CodigoPagos;

import com.example.proyectoclientes.Asistencia.Asistencia;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodigoPagosRepository extends CrudRepository<CodigoPagos, Integer> {
     
    @Query(value = " SELECT * FROM codigopagos "
            + " INNER JOIN empleado ON codigopagos.usuario_id = empleado.id "
            + " WHERE empleado.nombre LIKE %?1% "
            + " OR hora  LIKE %?1% "
            + " OR codigo LIKE %?1% "
            + " OR estado LIKE %?1% ", nativeQuery = true)
    List<CodigoPagos> buscarPorTodo(String dato);
    
    @Query(value = "SELECT * FROM codigopagos "
            + " INNER JOIN empleado ON codigopagos.usuario_id = empleado.id "
            + " ORDER BY asistencia.fecha ASC", nativeQuery = true)
    List<CodigoPagos> OrderAscReg();

    @Query(value = "SELECT * FROM codigopagos "
            + " INNER JOIN empleado ON codigopagos.usuario_id = empleado.id "
            + " ORDER BY asistencia.fecha DESC", nativeQuery = true)
    List<CodigoPagos> OrderDescReg();

}
