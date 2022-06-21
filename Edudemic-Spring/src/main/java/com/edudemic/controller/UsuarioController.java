package com.edudemic.controller;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.edudemic.entities.Usuario;
import com.edudemic.service.RolService;
import com.edudemic.service.UsuarioService;


@Controller
public class UsuarioController {
	
	private UsuarioService usuarioService;
	private RolService rolService;
	public UsuarioController(UsuarioService usuarioService,RolService rolService) 
	{
		this.usuarioService=usuarioService;
		this.rolService=rolService;
	}
	@GetMapping("/admin/registro")
	public String registrarAd(Model model) 
	{
		model.addAttribute("usuario",new Usuario());
		model.addAttribute("roles", rolService.listarRoles());
		return "registroA";
	}
	@PostMapping("/admins")
	public String registrarAdmin(@ModelAttribute("usuario") Usuario usuario) 
	{
		usuarioService.registrarUsuario(usuario);
		return "redirect:/admin/registro";
	}
}
