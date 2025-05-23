package com.softtek.project.jpa.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EstudianteNoEncontradoException extends RuntimeException {
    public EstudianteNoEncontradoException(Integer id) {
        super("Estudiante no encontrado con ID: " + id);
    }
}