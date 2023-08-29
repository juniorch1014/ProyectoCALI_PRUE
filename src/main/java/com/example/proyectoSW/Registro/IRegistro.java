/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.proyectoSW.Registro;

import com.example.proyectoSW.Servicio.*;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegistro extends CrudRepository<Registro, Integer> {

    @Query(value = "SELECT* from registro "
            + "INNER JOIN empleado on registro.empleado_id=empleado.id "
            + "INNER JOIN cliente on registro.cliente_id=cliente.id "
            + "INNER JOIN servicio on registro.servicio_id=servicio.id "
            //+ "INNER JOIN cliente on registro.cliente_id=cliente.id "
            //+ "INNER JOIN servicio on registro.servicio_id=servicio.id "
            //+ "WHERE empleado.nombre LIKE %?1% "
            + "WHERE empleado.nombre LIKE %?1% "
            + "OR cliente.nombre LIKE %?1% "
            + "OR servicio.nombre LIKE %?1% "
            + "OR servicio.precio LIKE %?1% "
            + "OR duracion_serv LIKE %?1% "
            + "OR costo_total LIKE %?1% "
            //+ "WHERE servicio.nombre LIKE %?1% "
            + "OR fecha LIKE %?1% ", nativeQuery = true)
    List<Registro> buscarPorTodo(String dato);

    @Query(value = "SELECT * from registro inner join cliente on registro.cliente_id=cliente.id ORDER BY registro.fecha ASC", nativeQuery = true)

    List<Registro> OrderAscReg();

    @Query(value = "SELECT * from registro inner join cliente on registro.cliente_id=cliente.id ORDER BY registro.fecha DESC", nativeQuery = true)
    List<Registro> OrderDescReg();
    
    @Query(value = "SELECT* from registro "
            + "INNER JOIN cliente on registro.cliente_id=cliente.id "
            + "WHERE registro.cliente_id LIKE ?1", nativeQuery = true)
    List<Registro> RegistroPorCliente(int id);

}
