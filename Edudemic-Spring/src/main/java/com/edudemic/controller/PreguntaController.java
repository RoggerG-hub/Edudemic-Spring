package com.edudemic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.edudemic.entities.Pregunta;
import com.edudemic.entities.Reto;
import com.edudemic.service.PreguntaService;
import com.edudemic.service.RetoService;

@Controller
public class PreguntaController {
	private PreguntaService preguntaService;
	private List<Reto> listaRetos = new ArrayList<>();
	private RetoService retoService;
	public PreguntaController(PreguntaService preguntaService,RetoService retoService) 
	{
		this.preguntaService=preguntaService;
		this.retoService=retoService;
	}
	@GetMapping("/registro/pregunta")
	public String registrarForm(Model model) 
	{
		Pregunta pregunta = new Pregunta();
		this.listaRetos= retoService.listarReto();
		model.addAttribute("pregunta",pregunta);
		model.addAttribute("listaRetos",listaRetos);
		return "/reto/registroP";
	}
	@PostMapping("/preguntas")
	public String registrarPregunta(@ModelAttribute("pregunta") Pregunta pregunta) 
	{
		preguntaService.registrarPregunta(pregunta);
		return "redirect:/";
	}
}
