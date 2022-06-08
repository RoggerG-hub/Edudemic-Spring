package com.edudemic.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.edudemic.entities.Profesor;
import com.edudemic.repository.ProfesorRepository;

@Service
public class ProfesorService {
	private ProfesorRepository profesorRepository;
	public ProfesorService(ProfesorRepository profesorRepository) 
	{
		this.profesorRepository=profesorRepository;
		}
	public Profesor registrarProfesor(Profesor p) 
	{
		return profesorRepository.save(p);
	}
	
	public List<Profesor> listarProfesor() 
	{
		return profesorRepository.findAll();
	}
	
}
