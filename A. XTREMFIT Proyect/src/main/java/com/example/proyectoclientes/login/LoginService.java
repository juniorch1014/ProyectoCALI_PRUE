/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectoclientes.login;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements ILoginService{
    
    @Autowired
    private ILogin data;
    
    @Override
    public List<login> Listar() {
       return (List<login>) data.findAll();
    }

    @Override
    public Optional<login> ConsultarId(int id) {
       return data.findById(id);
    }

    @Override
    public void Guardar(login l) {
        data.save(l);
    }
}
