package com.edudemic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edudemic.entities.Estudiante;
import com.edudemic.repository.EstudianteRepository;

@Service
public class EstudianteService {
	private EstudianteRepository estudianteRepository;
	public EstudianteService(EstudianteRepository estudianteRepository) 
	{
		this.estudianteRepository=estudianteRepository;
	}
	public List<Estudiante> listaEstudiantes()
	{
		return estudianteRepository.findAll();
	}
	public Estudiante registrarEstudiante(Estudiante e) 
	{
		return estudianteRepository.save(e);
	}
}
