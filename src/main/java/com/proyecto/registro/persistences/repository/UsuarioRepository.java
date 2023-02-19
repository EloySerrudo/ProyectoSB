package com.proyecto.registro.persistences.repository;

import com.proyecto.registro.persistences.models.UserStatus;
import com.proyecto.registro.persistences.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findAllByUserStatus(UserStatus userStatus);
    // Petición creada propia a la Base de datos
    boolean existsUsuarioById(Integer id);
}
