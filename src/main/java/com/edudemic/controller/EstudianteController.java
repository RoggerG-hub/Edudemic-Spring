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
	private Estudiante estudianteSeleccionado;
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
	public String editEstudianteForm( @PathVariable("id") Long id, Estudiante estudiante,Model model) {
 
		try {
			estudiante = estudianteService.buscarEstudiantePorId(id);
			model.addAttribute("estudiante", estudiante);
			estudianteSeleccionado=estudianteService.buscarEstudiantePorId(id);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "/estudiante/editarE"; 
	}
	@GetMapping("/guardar")
	public String guardarEstudiante(@Validated @ModelAttribute("estudiante") Estudiante estudiante,BindingResult result,Model model) {

		try {
    			estudianteSeleccionado.setId(estudiante.getId());
    			estudianteSeleccionado.setApellidos(estudiante.getApellidos());
    			estudianteSeleccionado.setContraseña(estudiante.getContraseña());
    			estudianteSeleccionado.setCorreo(estudiante.getCorreo());
    			estudianteSeleccionado.setDni(estudiante.getDni());
    			estudianteSeleccionado.setEdad(estudiante.getEdad());
    			estudianteSeleccionado.setFecha(estudiante.getFecha());
    			estudianteSeleccionado.setNombres(estudiante.getNombres());
    			estudianteSeleccionado.setTelefono(estudiante.getTelefono());

    			estudianteService.EditarEstudiante(estudianteSeleccionado);
			    model.addAttribute("estudiante",estudianteSeleccionado);
    			model.addAttribute("mensaje", "El estudiante se modificó correctamente");
    			
        }catch (Exception e) {
			System.out.println(e.getMessage());
			model.addAttribute("mensaje", "El estudiante no se modificó correctamente");

		}
		
		return "estudiante/editarE";
	}	
	
}
