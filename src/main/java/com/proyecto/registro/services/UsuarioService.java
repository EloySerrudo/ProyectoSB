package com.proyecto.registro.services;

import com.proyecto.registro.dao.UsuarioDao;
import com.proyecto.registro.dto.UsuarioInDTO;
import com.proyecto.registro.exceptions.UsuarioNotFoundException;
import com.proyecto.registro.mappers.UsuarioInDTOToUsuario;
import com.proyecto.registro.persistences.models.UserStatus;
import com.proyecto.registro.persistences.models.Usuario;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    //Aquí está toda la lógica de negocios u operaciones como crear nuevos usuarios
    private final UsuarioDao usuarioDao;
    private final UsuarioInDTOToUsuario mapper;
    //Final, le da Inmutabilidad al atributo
    //Aquí se hace una inyección de dependencias:
    public UsuarioService(@Qualifier("jpa") UsuarioDao usuarioDao,
                          UsuarioInDTOToUsuario mapper) {
        this.mapper = mapper;
        this.usuarioDao = usuarioDao;
    }
    // Aquí estarán los métodos que se harán con los usuarios:
    public List<Usuario> getUsuarios() {
        return this.usuarioDao.selectAllUsuarios();
    }
    public Usuario getUsuario(Integer id) {
        return this.usuarioDao.selectUsuarioById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(
                        "Usuario con id [%s] no encontrado".formatted(id)
                ));
    }
    public Usuario addUsuario(UsuarioInDTO usuarioInDTO) {
        Usuario usuario = mapper.map(usuarioInDTO);           // Esto convierte UsuarioInDTO en Usuario
        return this.usuarioDao.insertUsuario(usuario);
    }
    public void updateUsuario(Integer id, Usuario updateRequest) {
        Usuario usuario = usuarioDao.selectUsuarioById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(
                        "Usuario con id [%s] no encontrado".formatted(id)
                ));
        usuario.setNombre(updateRequest.getNombre());
        usuario.setApellido(updateRequest.getApellido());
        this.usuarioDao.updateUsuario(usuario);
    }
    public void deleteUsuario(Integer id) {
        if (!usuarioDao.existsUsuarioById(id)) {
            throw new UsuarioNotFoundException(
                    "Usuario con id [%s] no encontrado".formatted(id)
            );
        }
        this.usuarioDao.deleteUsuario(id);
    }
    public List<Usuario> getUsuariosByStatus(UserStatus userStatus) {
        return this.usuarioDao.selectAllUsuariosByStatus(userStatus);
    }
}
