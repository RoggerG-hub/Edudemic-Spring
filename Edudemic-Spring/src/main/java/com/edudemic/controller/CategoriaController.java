package com.edudemic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.edudemic.entities.Categoria;
import com.edudemic.service.CategoriaService;

@Controller
public class CategoriaController {
	private CategoriaService categoriaService;
	public CategoriaController(CategoriaService categoriaService) 
	{
		this.categoriaService=categoriaService;
	}
	
	@GetMapping("/registro/categoria")
	public String registrarCategoriaForm(Model model) 
	{
		Categoria categoria = new Categoria();
		model.addAttribute("categoria",categoria);
		return "/categoria/registroCa";
	}
	@PostMapping("/categorias")
	public String registrarCategoria(@ModelAttribute("categoria") Categoria categoria) 
	{
		categoriaService.registrarCategoria(categoria);
		return "redirect:/";
	}
	@GetMapping("/lista/categoria")
    public String showAllCategorias(Model model) {
		model.addAttribute("categorias", categoriaService.listarCategoria());
        return "categoria/lista";
    }  
    
    @GetMapping("/delete/{id}")
    public String deleteCategoria(@PathVariable Long id) {
        categoriaService.deleteCategoriaById(id);
        return "redirect:/";
    }
}
