package com.edudemic.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.sql.Insert;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.edudemic.entities.Estudiante;
import com.edudemic.entities.Inscripcion;
import com.edudemic.entities.Calificacion;
import com.edudemic.entities.Libro;
import com.edudemic.entities.Mentoria;
import com.edudemic.service.EstudianteService;
import com.edudemic.service.InscripcionService;
import com.edudemic.service.CalificacionService;
import com.edudemic.service.LibroService;
import com.edudemic.service.MentoriaService;

@Controller
public class CalificacionController {
	private CalificacionService calificacionService;
	private EstudianteService estudianteService;
	private List<Estudiante> listaEstudiantes = new ArrayList<>();
	private LibroService libroService;
	private List<Libro> listaLibros=new ArrayList<>();
	
	public CalificacionController(CalificacionService calificacionService, EstudianteService estudianteService, LibroService libroService) 
	{
		this.calificacionService=calificacionService;
		this.estudianteService=estudianteService;
		this.libroService=libroService;
	}
	
	
	@GetMapping("/registro/calificacion/{id}")
	public String registrarCalificacionesForm(@PathVariable Long id,Model model) 
	{
		
		Calificacion calificacion = new Calificacion();
		this.listaEstudiantes = estudianteService.listaEstudiantes();
		this.listaLibros = libroService.getAllLibros();
		
		
		Libro st = libroService.getLibroById(id);
		
	
		
		model.addAttribute("libro", st);
		model.addAttribute("calificaciones",calificacion);
		model.addAttribute("listaEstudiantes",listaEstudiantes);
		model.addAttribute("listaLibros",listaLibros);
		
		
		return "/calificacion/registroCalificacion";
	}
	
	
	
	
	
	@PostMapping("/calificaciones")
	public String registrarCalificacion( @ModelAttribute("libro") Libro libro,@ModelAttribute("calificacion") Calificacion calificacion,Model model) 
	{
		
		
			if (calificacionService.validarCalificacion(calificacion)==0)
				{
				   calificacionService.registroCalificacion(calificacion);
			       return "redirect:/";
				}
			else
			    {
				this.listaEstudiantes = estudianteService.listaEstudiantes();
				this.listaLibros = libroService.getAllLibros();
				
				
				
				
			
				
			
				model.addAttribute("calificaciones",calificacion);
				model.addAttribute("listaEstudiantes",listaEstudiantes);
				model.addAttribute("listaLibros",listaLibros);
	
				    model.addAttribute("mensaje", "El estudiante ya calificó el libro");
				    return "/calificacion/registroCalificacion";
			    }

			
			
	}
	

}
