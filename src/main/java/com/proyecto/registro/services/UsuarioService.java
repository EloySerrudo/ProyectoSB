package com.proyecto.registro.services;

import com.proyecto.registro.dto.UsuarioInDTO;
import com.proyecto.registro.mappers.UsuarioInDTOToUsuario;
import com.proyecto.registro.persistences.models.UserStatus;
import com.proyecto.registro.persistences.models.Usuario;
import com.proyecto.registro.persistences.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {       //Toda la lógica de negocio, como crear nuevos usuarios
    private final UsuarioRepository usuarioRepository;  // Service se conecta a Repository y
    private final UsuarioInDTOToUsuario mapper;         // Repository a la Base de Datos
    //Final le da Inmutabilidad al atributo
    //Aquí se hace una inyección de dependencias:
    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioInDTOToUsuario mapper) {
        this.usuarioRepository = usuarioRepository;
        this.mapper = mapper;
    }
    // Aquí estarán los métodos que se harán con los usuarios:
    public List<Usuario> getUsuarios() {
        return this.usuarioRepository.findAll();
    }
    public Usuario addUsuario(UsuarioInDTO usuarioInDTO) {
        Usuario usuario = mapper.map(usuarioInDTO);
        return this.usuarioRepository.save(usuario);           // Esto convierte UsuarioInDTO en Usuario
    }
    public void deleteUsuario(Integer id) {
        this.usuarioRepository.deleteById(id);
    }
    public List<Usuario> getUsuariosByStatus(UserStatus userStatus) {
        return this.usuarioRepository.findAllByUserStatus(userStatus);
    }
}
