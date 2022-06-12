package com.edudemic.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.edudemic.entities.Inscripcion;
import com.edudemic.repository.InscripcionRepository;
@Service
public class InscripcionService {
	private InscripcionRepository inscripcionRepository;
	public InscripcionService(InscripcionRepository inscripcionRepository) 
	{
		this.inscripcionRepository=inscripcionRepository;
	}
	public List<Inscripcion> listarInscripcion() 
	{
		return inscripcionRepository.findAll();
	}
	public Inscripcion registrarInscripcion(Inscripcion c) 
	{
		return inscripcionRepository.save(c);
	}
	public List<Inscripcion> listaIns(Long id)
	{
		return inscripcionRepository.listaIns(id);
	}
	
}
