package com.edudemic.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.edudemic.service.EstudianteService;

@Controller
public class ReporteController {
	private EstudianteService estudianteService;
	public ReporteController(EstudianteService estudianteService) 
	{
		this.estudianteService = estudianteService;
	}
	@GetMapping("/reporte/estudiante/nota")
	public String reporteE(Model model){
		
		model.addAttribute("estudiantes",estudianteService.listaEstudiantes());

		return "/reporte/estudianteR";
	}
}
