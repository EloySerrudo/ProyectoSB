package com.proyecto.registro.dao;
// Esta capa DAO (Data Access Object) está relacionado con UsuarioService (GitLab No lo tiene)
import com.proyecto.registro.dto.UsuarioInDTO;
import com.proyecto.registro.persistences.models.Usuario;

public interface UsuarioDao {
    Usuario addUsuario(UsuarioInDTO usuarioInDTO);
}
