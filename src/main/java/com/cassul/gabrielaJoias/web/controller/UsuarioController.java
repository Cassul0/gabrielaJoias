package com.cassul.gabrielaJoias.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cassul.gabrielaJoias.model.Usuario;
import com.cassul.gabrielaJoias.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/cadastro")
	public String cadastroUsuario(Usuario usuario) {
		return "usuario/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(Usuario usuario, BindingResult result, RedirectAttributes attr) {
		usuarioService.salvar(usuario);
		return "redirect:/usuario/cadastro";
	}
	
	@GetMapping("/lista")
	public String listarUsuarios() {
		return "usuario/lista";
	}
}
