/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.proyectoclientes.Empleado;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleado extends CrudRepository<Empleado,Integer>{
    @Query(value="SELECT * FROM empleado "
            + "WHERE nombre LIKE %?1%  "
            + "OR apellido LIKE %?1% "
            + "OR dni LIKE %?1% "
            + "OR celular LIKE %?1% "
            + "OR direccion LIKE %?1%",nativeQuery=true)
    List<Empleado> buscarPorTodo(String dato);
    
    @Query(value="SELECT * FROM empleado ORDER BY nombre ASC",nativeQuery=true)
    List<Empleado> OrderAscEmp();
    
    @Query(value="SELECT * FROM empleado ORDER BY nombre DESC",nativeQuery=true)
    List<Empleado> OrderDescEmp();
}
