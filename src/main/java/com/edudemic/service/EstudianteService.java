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
	public int registrarEstudiante(Estudiante e) 
	{
		int existeEstudiante=estudianteRepository.verificarExistenciaEstudiante(e.getDni());
		if(existeEstudiante==0)
			estudianteRepository.save(e);

		return existeEstudiante;
	}
	
	public Estudiante EditarEstudiante(Estudiante e) 
	{
		return estudianteRepository.save(e);
	}
	
	public Estudiante getEstudianteById(Long id) {
		return estudianteRepository.findById(id).get();
	}
	
	public int modificarEstudiante(Estudiante e) 
	{
		int existeEstudiante=estudianteRepository.verificarExistenciaEstudiante(e.getDni());
		if(existeEstudiante==0)
			estudianteRepository.save(e);

		return existeEstudiante;
	}
	public Estudiante buscarEstudiantePorId(long id){
		Estudiante estudiante=estudianteRepository.buscarEstudiantePorId(id);
		return estudiante;
	}
	
}
