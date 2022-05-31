package com.edudemic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.edudemic.entities.Categoria;
import com.edudemic.entities.Libro;
import com.edudemic.service.CategoriaService;
import com.edudemic.service.LibroService;

@Controller
public class LibroController {

	private LibroService libroService;
	private CategoriaService categoriaService;
	private List<Categoria> listaCategorias = new ArrayList<>();

	public LibroController(LibroService libroService, CategoriaService categoriaService) {

		this.libroService = libroService;
		this.categoriaService = categoriaService;
	}

	@GetMapping("/registro/libro")
	public String registrarLibroForm(Model model) {

		Libro libro = new Libro();
		this.listaCategorias = categoriaService.listarCategoria();

		model.addAttribute("libro", libro);
		model.addAttribute("listaCategorias", listaCategorias);
		return "/libro/registroL";
	}

	@GetMapping("/listar/libro")
	public String listarLibros(Model model) {
		model.addAttribute("libros", libroService.getAllLibros());

		return "/libro/listL";
	}

	@PostMapping("/libros")
	public String registrarLibro(@Validated @ModelAttribute Libro libro,BindingResult result,Model model,SessionStatus status) {
		try {
			if(result.hasErrors()) {
				return "libro/regsistroL";
			}
		libroService.saveLibro(libro);
		status.setComplete();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return "redirect:/";
	}

	@GetMapping("/libros/edit/{id}")
	public String editLibroForm(@PathVariable Long id, Model model) {
		Libro st = libroService.getLibroById(id);

		model.addAttribute("libro", st);
		model.addAttribute("categoriasList", listaCategorias);

		return "libro/update";
	}

	@PostMapping("/libros/{id}")
	public String updateLibro(@PathVariable Long id, @ModelAttribute("libro") Libro libro, Model model) {
		// sacar al libro de la b.d. por el id
		Libro existentLibro = libroService.getLibroById(id);
		// cargarlo
		existentLibro.setId(id);
		existentLibro.setTitulo(libro.getTitulo());
		existentLibro.setfPublicacion(libro.getfPublicacion());
		existentLibro.setDescripcion(libro.getDescripcion());
		existentLibro.setAutor(libro.getAutor());
		existentLibro.setEnlace(libro.getEnlace());
		existentLibro.setLibros(libro.getLibros());
		// guardar el libro actualizado
		libroService.updateLibro(existentLibro);

		return "redirect:/";
		
	}
}
