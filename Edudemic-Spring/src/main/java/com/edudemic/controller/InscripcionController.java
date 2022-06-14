package com.edudemic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.edudemic.service.InscripcionService;

@Controller
public class InscripcionController {
	private InscripcionService inscripcionService;
	public InscripcionController(InscripcionService inscripcionService) 
	{
		this.inscripcionService=inscripcionService;
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
}
