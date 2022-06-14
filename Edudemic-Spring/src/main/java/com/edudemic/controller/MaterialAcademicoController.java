package com.edudemic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/materialAcademico")
public class MaterialAcademicoController {

	@GetMapping("/lista")
	public String listarMaterial() {
		
		return "material_academico/list";
	}
	
	@GetMapping("/nuevo")
	public String nuevoMaterial() {
		
		return "material_academico/insertar";
	}
}
