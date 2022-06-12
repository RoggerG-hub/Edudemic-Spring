package com.edudemic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

import com.edudemic.entities.Estudiante;
import com.edudemic.entities.Inscripcion;
import com.edudemic.entities.Mentoria;
import com.edudemic.service.EstudianteService;
import com.edudemic.service.InscripcionService;
import com.edudemic.service.MentoriaService;

@Controller
public class InscripcionController {
	private InscripcionService inscripcionService;
	private EstudianteService estudianteService;
	private List<Estudiante> listaEstudiantes = new ArrayList<>();
	private MentoriaService mentoriaService;
	private List<Mentoria> listaMentorias=new ArrayList<>();
	
	public InscripcionController(InscripcionService inscripcionService, EstudianteService estudianteService, MentoriaService mentoriaService) 
	{
		this.inscripcionService=inscripcionService;
		this.estudianteService=estudianteService;
		this.mentoriaService=mentoriaService;
	}
	@GetMapping("/lista/inscripcion")
	public String listarInscripciones(Model model) {
		
		model.addAttribute("inscripciones",inscripcionService.listarInscripcion());
		return "/inscripcion/listaI";
	}
	@GetMapping("/lista/inscripcion/estudiante/{id}")
	public String listarNotas(@PathVariable Long id,Model model) {
	
		model.addAttribute("inscripcionE",inscripcionService.listaIns(id));
		return "/estudiante/notasE";
	}
	
	@GetMapping("/registro/inscripciones")
	public String registrarInscripcionesForm(Model model) 
	{
		Inscripcion inscripcion = new Inscripcion();
		this.listaEstudiantes = estudianteService.listaEstudiantes();
		this.listaMentorias = mentoriaService.listarMentoria();

		model.addAttribute("inscripciones",inscripcion);
		model.addAttribute("listaEstudiantes",listaEstudiantes);
		model.addAttribute("listaMentorias",listaMentorias);
		
		return "/inscripcion/registroI";
	
	}
	
	@PostMapping("/inscripciones")
	public String registrarInscripcion(@ModelAttribute("inscripcion") Inscripcion inscripcion) 
	{
		inscripcionService.registrarInscripcion(inscripcion);
		return "redirect:/";
	}
	
	
	
}
