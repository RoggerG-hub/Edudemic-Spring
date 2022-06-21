package com.edudemic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	@GetMapping("/lista/estudiante")
	public String listarEstudiante(Model model) {
		model.addAttribute("estudiantes",estudianteService.listaEstudiantes());
		return "/estudiante/listaE";
	}
	
	@GetMapping("/edit/{id}")
	public String editEstudianteForm( @PathVariable("id") long id, Estudiante estudiante,Model model) {
 
		try {
			estudiante = estudianteService.buscarEstudiantePorId(id);
			model.addAttribute("estudiante", estudiante);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "estudiante/editarE";
	}
	@GetMapping("/guardar")
	public String guardarEstudiante(@Validated @ModelAttribute("estudiante") Estudiante estudiante,BindingResult result,Model model) {
	//	Estudiante estudianteActualizado=estudianteService.EditarEstudiante(estudiante);
		if(result.hasErrors()) {
			estudianteService.EditarEstudiante(estudiante);
			//model.addAttribute("doctor",estudiante);
			model.addAttribute("estudiante",new Estudiante());
		}
		
		return "estudiante/editarE";
	}	
	
}
