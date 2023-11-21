/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.proyectoclientes.servicio;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServicio extends CrudRepository<Servicio,Integer>{
    @Query(value="SELECT * FROM servicio "
            + "WHERE nombre LIKE %?1%  "
            + "OR precio LIKE %?1%",nativeQuery=true)
    List<Servicio> buscarPorTodo(String dato);
    
    @Query(value="SELECT * FROM servicio ORDER BY nombre ASC",nativeQuery=true)
    List<Servicio> OrderAscServ();
    
    @Query(value="SELECT * FROM servicio ORDER BY nombre DESC",nativeQuery=true)
    List<Servicio> OrderDescServ();

    public Page<Servicio> findAll(Pageable pageable);
}
