package com.proyecto.registro.mappers;

import com.proyecto.registro.dto.UsuarioInDTO;
import com.proyecto.registro.persistences.models.UserStatus;
import com.proyecto.registro.persistences.models.Usuario;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component              // Lo especificamos como componente Spring Boot
public class UsuarioInDTOToUsuario implements IMapper<UsuarioInDTO, Usuario>{
    @Override           // Esto implementa el mapper genérico
    public Usuario map(UsuarioInDTO in) {
        Usuario usuario = new Usuario();
        usuario.setNombre(in.getNombre());                  // Estos se
        usuario.setApellido(in.getApellido());              // piden
        usuario.setFechaInscripcion(LocalDateTime.now());   // Estos son
        usuario.setUserStatus(UserStatus.ON_TIME);          // Automáticos
        return usuario;
    }
    // Convierte un UsuarioDTO en un Usuario
}
