package com.cassul.gabrielaJoias.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cassul.gabrielaJoias.model.Usuario;
import com.cassul.gabrielaJoias.service.UsuarioService;

@Controller
public class HomePageController {

	@Autowired UsuarioService usuarioService;
	
	@GetMapping("/")
	public String init() {
		return "redirect:/login";
	}
	
	@GetMapping("/homePage")
	public String abrirPaginaInicial() {
		return "homePage";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("user", new Usuario());
		return "login";
	}
	
	@GetMapping({"/loginError"}) 
	public String loginError(Model model) {
		model.addAttribute("alerta", "erro"); 
		model.addAttribute("titulo", "Crendenciais inválidas!"); 
		model.addAttribute("texto", "Login ou senha incorretos, tente novamente."); 
		model.addAttribute("user", new Usuario());
		return "login"; 
	}
	
	@PostMapping("/auth")
	public String login(@RequestParam("username") String username, @RequestParam("senha") String senha) {
		UserDetails usuario = this.usuarioService.loadUserByUsername(username);
		if(usuario.isEnabled()) {
			
			return "homePage";
		} else {
			return "redirect:/loginError";
		}
	}
}
