
package com.example.proyectoclientes.login;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author player
 */
public interface ILoginService {
    public List<login> Listar();
    public Optional<login> ConsultarId(int id);
    public void Guardar(login l);
}
