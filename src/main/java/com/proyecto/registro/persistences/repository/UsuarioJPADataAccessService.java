package com.proyecto.registro.persistences.repository;

import com.proyecto.registro.dao.UsuarioDao;
import com.proyecto.registro.persistences.models.UserStatus;
import com.proyecto.registro.persistences.models.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jpa")
public class UsuarioJPADataAccessService implements UsuarioDao {
    // Aquí está toda la lógica relacionada con la BD utilizando la capa Models
    private final UsuarioRepository usuarioRepository;

    public UsuarioJPADataAccessService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> selectAllUsuarios() {
        return this.usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> selectUsuarioById(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario insertUsuario(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    @Override
    public boolean existsUsuarioById(Integer id) {
        return usuarioRepository.existsUsuarioById(id);
    }

    @Override
    public void updateUsuario(Usuario update) {
        this.usuarioRepository.save(update);
    }

    @Override
    public void deleteUsuario(Integer id) {
        this.usuarioRepository.deleteById(id);
    }

    @Override
    public List<Usuario> selectAllUsuariosByStatus(UserStatus userStatus) {
        return this.usuarioRepository.findAllByUserStatus(userStatus);
    }
}
