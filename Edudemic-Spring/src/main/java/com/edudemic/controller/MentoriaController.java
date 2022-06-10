package com.edudemic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.edudemic.entities.Profesor;
import com.edudemic.entities.Curso;
import com.edudemic.entities.Mentoria;
import com.edudemic.service.ProfesorService;
import com.edudemic.service.CursoService;
import com.edudemic.service.MentoriaService;

@Controller
public class MentoriaController {

	private MentoriaService mentoriaService;
	private ProfesorService profesorService;
	private List<Profesor> listaProfesores =new ArrayList<>();
	
	public MentoriaController(MentoriaService mentoriaService,ProfesorService profesorService) 
	{
		this.mentoriaService=mentoriaService;
		this.profesorService = profesorService;
	}
	
	@GetMapping("/registro/mentoria")
	public String registrarMentoriaForm(Model model) 
	{
		Mentoria mentoria = new Mentoria();
		this.listaProfesores = profesorService.listarProfesor();

		model.addAttribute("mentoria",mentoria);
		model.addAttribute("listaProfesores",listaProfesores);
		return "/mentoria/registroM";
	
	}
	
	@PostMapping("/mentorias")
	public String registrarMentoria(@ModelAttribute("mentoria") Mentoria mentoria) 
	{
		mentoriaService.registrarMentoria(mentoria);
		return "redirect:/";
	}
	
	
	
	
}
