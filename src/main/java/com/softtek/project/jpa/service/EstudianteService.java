package com.softtek.project.jpa.service;

import java.util.List;

import com.softtek.project.jpa.dto.EstudianteDTO;

public interface EstudianteService {
	public EstudianteDTO crear(EstudianteDTO dto);
	public EstudianteDTO actualizar(Integer id, EstudianteDTO dto);
	public void eliminar(Integer id);
	public EstudianteDTO obtener(Integer id);
	public List<EstudianteDTO> listar();

}
