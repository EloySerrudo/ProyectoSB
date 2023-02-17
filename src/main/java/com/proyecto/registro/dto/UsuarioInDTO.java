package com.proyecto.registro.dto;

import lombok.Data;

@Data
public class UsuarioInDTO {
    private String nombre;
    private String apellido;
    // Estos son los únicos datos que se le pedirán al usuario que llene.
    // El DTO sirve para indicar qué datos de la entidad pasar entre las capas de la Aplicación
    // Para no tener la necesidad de enviar todos los datos, esto es los que son automáticos
    // Mediante el uso de un mapper. Para convertir los datos que se piden al usuario y aumentar
    // Los datos automáticos que se necesitan para añadirlo a la base de datos
}
