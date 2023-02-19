package com.proyecto.registro.dao;
// Esta capa DAO (Data Access Object) está relacionado con UsuarioService (GitLab No lo tiene)
import com.proyecto.registro.persistences.models.UserStatus;
import com.proyecto.registro.persistences.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioDao {
    List<Usuario> selectAllUsuarios();
    Optional<Usuario> selectUsuarioById(Integer id);
    Usuario insertUsuario(Usuario usuario);
    boolean existsUsuarioById(Integer id);
    void updateUsuario(Usuario updateRequest);
    void deleteUsuario(Integer id);
    List<Usuario> selectAllUsuariosByStatus(UserStatus userStatus);
    //Optional hace referencia a una variable que puede tener un valor o que puede contener un null.
}
