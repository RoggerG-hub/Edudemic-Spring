package com.edudemic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.edudemic.entities.Comentario;
import com.edudemic.entities.Estudiante;
import com.edudemic.entities.Foro;
import com.edudemic.service.ComentarioService;
import com.edudemic.service.EstudianteService;
import com.edudemic.service.ForoService;

@Controller
public class ComentarioController {
	private ComentarioService comentarioService;
	private ForoService foroService;
	private List<Foro> listaForos = new ArrayList<>();
	private EstudianteService estudianteService;
	private List<Estudiante> listaEstudiantes = new ArrayList<>();
	
	public ComentarioController(ComentarioService comentarioService, ForoService foroService,EstudianteService estudianteService) {
		this.comentarioService = comentarioService;
		this.foroService = foroService;
		this.estudianteService = estudianteService;
	}
	
	@GetMapping("/registro/comentario")
	public String registrarComentarioForm(Model model) {

		Comentario comentario = new Comentario();
		this.listaForos = foroService.getAllForos();
		this.listaEstudiantes = estudianteService.listaEstudiantes();

		model.addAttribute("comentario", comentario);
		model.addAttribute("listaForos", listaForos);
		model.addAttribute("listaEstudiantes", listaEstudiantes);
		return "/comentario/registroC";
	}
	
	@GetMapping("/listar/comentario")
	public String listarComentarios(Model model) {
		model.addAttribute("comentarios", comentarioService.getAllComentarios());

		return "/comentario/listC";
	}
	
	@PostMapping("/comentarios")
	public String registrarComentario(@Validated @ModelAttribute Comentario comentario, BindingResult result, Model model,
			SessionStatus status) {
		try {
			if (result.hasErrors()) {
				model.addAttribute("listaForos", listaForos);
				model.addAttribute("listaEstudiantes", listaEstudiantes);
				return "comentario/registroC";
			}
			comentarioService.saveComentario(comentario);
			status.setComplete();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "redirect:/";
	}
	
}
