/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.proyectoSW.Cliente;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICliente extends CrudRepository<Cliente,Integer>{
    @Query(value="SELECT * FROM cliente "
            + "WHERE nombre LIKE %?1%  "
            + "OR apellido LIKE %?1% "
            + "OR dni LIKE %?1% "
            + "OR celular LIKE %?1% "
            + "OR email LIKE %?1% "
            + "OR direccion LIKE %?1%",nativeQuery=true)
    List<Cliente> buscarPorTodo(String dato);
    
    @Query(value="SELECT * FROM cliente ORDER BY nombre ASC",nativeQuery=true)
    List<Cliente> OrderAscCli();
    
    @Query(value="SELECT * FROM cliente ORDER BY nombre DESC",nativeQuery=true)
    List<Cliente> OrderDescCli();
}
