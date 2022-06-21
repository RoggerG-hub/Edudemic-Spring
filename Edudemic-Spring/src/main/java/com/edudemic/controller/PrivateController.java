package com.edudemic.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edudemic.entities.Usuario;
import com.edudemic.repository.UsuarioRepository;

@Controller
@RequestMapping("/private")
public class PrivateController {
	@Autowired
	UsuarioRepository usuarioRepository;
	@GetMapping("/index")
	public String indx(Authentication auth, HttpSession session) 
	{
		String username = auth.getName(); 
		if(session.getAttribute("usuario")==null) 
		{
			Usuario user = usuarioRepository.findByDni(username);
			user.setPassword(null);
			session.setAttribute("usuario", user);
		}
		return "index";
	}
	
}
