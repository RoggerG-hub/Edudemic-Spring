package com.edudemic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.edudemic.entities.Estudiante;
import com.edudemic.service.EstudianteService;

@Controller
public class EstudianteController {
	private EstudianteService estudianteService;
	public EstudianteController(EstudianteService estudianteService) 
	{
		this.estudianteService = estudianteService;
	}
	@GetMapping("/lista")
	public String lista(){
		return "/estudiante/listaE";
	}
	@GetMapping("/landing")
	public String land(){
		return "landing_page";
	}
	@GetMapping("/nosotros")
	public String nosotros(){
		return "/landing/nosotros";
	}
	@GetMapping("/admin")
	public String admin(){
		return "/admin/admin";
	}
	@GetMapping("/registro/estudiante")
	public String registrarEstudianteForm(Model model) 
	{
		Estudiante estudiante = new Estudiante();
		model.addAttribute("estudiante",estudiante);
		return "/estudiante/registroE";
	}
	@PostMapping("/estudiantes")
	public String registrarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) 
	{
		estudianteService.registrarEstudiante(estudiante);
		return "redirect:/";
	}
}
