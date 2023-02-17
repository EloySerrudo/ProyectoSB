package com.proyecto.registro.persistences.repository;

import com.proyecto.registro.persistences.models.UserStatus;
import com.proyecto.registro.persistences.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    public List<Usuario> findAllByUserStatus(UserStatus userStatus);
    // Petición creada propia a la Base de datos
}
