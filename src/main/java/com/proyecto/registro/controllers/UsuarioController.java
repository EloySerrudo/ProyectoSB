package com.proyecto.registro.controllers;

import com.proyecto.registro.dto.UsuarioInDTO;
import com.proyecto.registro.persistences.models.UserStatus;
import com.proyecto.registro.persistences.models.Usuario;
import com.proyecto.registro.services.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {
    // La capa del controlador solo debería comunicarse con la capa de servicio.
    // Aquí se definen las rutas según la Request(petición) y URL
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    // Crear una tarea o elementos
    @GetMapping                     //A veces aquí se especifica la URL
    public List<Usuario> getUsuarios(){
        return this.usuarioService.getUsuarios();
    }
    @GetMapping("{usuarioId}")
    public Usuario getUsuario(@PathVariable("usuarioId") Integer id){
        return usuarioService.getUsuario(id);
    }
    @PostMapping
    public Usuario addUsuario(@RequestBody UsuarioInDTO usuarioInDTO) {
        return this.usuarioService.addUsuario(usuarioInDTO);
    }
    @PutMapping("{usuarioId}")
    public void updateUsuario(@PathVariable("usuarioId") Integer id, @RequestBody Usuario request){
        this.usuarioService.updateUsuario(id, request);
    }
    @DeleteMapping("{usuarioId}")
    public void deleteUsuario(@PathVariable("usuarioId") Integer id) {
        this.usuarioService.deleteUsuario(id);
    }
    @GetMapping("/status/{status}")
    public List<Usuario> getUsuariosByStatus(@PathVariable("status") UserStatus userStatus) {
        return this.usuarioService.getUsuariosByStatus(userStatus);
    }
}
