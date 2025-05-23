package com.softtek.project.jpa.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.softtek.project.jpa.dto.EstudianteDTO;
import com.softtek.project.jpa.exception.EmailDuplicadoException;
import com.softtek.project.jpa.exception.EstudianteNoEncontradoException;
import com.softtek.project.jpa.mapper.EstudianteMapper;
import com.softtek.project.jpa.model.Estudiante;
import com.softtek.project.jpa.repository.EstudianteRepository;
import com.softtek.project.jpa.service.EstudianteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl implements EstudianteService {
	private final EstudianteRepository repository;
	private final EstudianteMapper mapper;
	private static final Logger logger = LoggerFactory.getLogger(EstudianteServiceImpl.class);

	@Override
	public EstudianteDTO crear(EstudianteDTO dto) {
		repository.findByEmail(dto.getEmail()).ifPresent(e -> {
			throw new EmailDuplicadoException(dto.getEmail());
		});
		Estudiante estudiante = mapper.toEntity(dto);
		Estudiante guardado = repository.save(estudiante);
		logger.info("Estudiante creado: {}", guardado);
		return mapper.toDto(guardado);
	}

	@Override
	public EstudianteDTO actualizar(Integer id, EstudianteDTO dto) {
		Estudiante existente = estudianteExistenteValidar(id);

		if (!existente.getEmail().equals(dto.getEmail()) && repository.findByEmail(dto.getEmail()).isPresent()) {
			throw new EmailDuplicadoException(dto.getEmail());
		}

		mapper.actualizarEntidadDesdeDto(dto, existente);

		Estudiante actualizado = repository.save(existente);
		logger.info("Estudiante actualizado: {}", actualizado);
		return mapper.toDto(actualizado);
	}

	@Override
	public void eliminar(Integer id) {
		Estudiante estudiante = estudianteExistenteValidar(id);
		repository.delete(estudiante);
		logger.info("Estudiante eliminado: {}", id);
	}

	@Override
	public EstudianteDTO obtener(Integer id) {
		return mapper.toDto(estudianteExistenteValidar(id));
	}

	@Override
	public List<EstudianteDTO> listar() {
		return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
	}
	
	public Estudiante estudianteExistenteValidar(Integer id) {
		return repository.findById(id).orElseThrow(() -> new EstudianteNoEncontradoException(id));
	}

}