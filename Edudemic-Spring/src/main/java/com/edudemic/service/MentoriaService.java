package com.edudemic.service;

import org.springframework.stereotype.Service;

import com.edudemic.entities.Mentoria;

import com.edudemic.repository.MentoriaRepository;


@Service
public class MentoriaService {
	
	
	private MentoriaRepository mentoriaRepository;
	public MentoriaService(MentoriaRepository mentoriaRepository) 
	{
		this.mentoriaRepository=mentoriaRepository;
	}
	public Mentoria registrarMentoria(Mentoria m) 
	{
		return mentoriaRepository.save(m);
	}
	

}
