package com.proyecto.registro.security;

import lombok.Data;

@Data
public class AuthenticationCredentials {
    private String email;
    private String password;
}
