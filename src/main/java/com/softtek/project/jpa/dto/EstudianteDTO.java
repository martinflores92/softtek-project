package com.softtek.project.jpa.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteDTO {
	
	private Integer id;
	
    @NotBlank
    @Size(max = 40)
    private String nombre;

    @NotBlank
    @Size(max = 40)
    private String apellido;

    @NotBlank
    @Email
    @Size(max = 40)
    private String email;

    @NotNull(message = "El campo 'creditos' es obligatorio")
    private Integer creditos;

    @NotNull(message = "El campo 'semestre' es obligatorio")
    private Integer semestre;

    @NotNull(message = "El campo 'promedio' es obligatorio")
    private Integer promedio;
}