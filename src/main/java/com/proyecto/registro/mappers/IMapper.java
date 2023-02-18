package com.proyecto.registro.mappers;

public interface IMapper <I, O>{    // Esta es una interfaz genérica que recibe I y retorna O
    public O map(I in);
}
