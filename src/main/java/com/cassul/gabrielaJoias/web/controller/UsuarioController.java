package com.cassul.gabrielaJoias.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String salvar(Usuario usuario) {
		usuarioService.save(usuario);
		return "redirect:/usuario/cadastro";
	}
	
	@GetMapping("/lista")
	public String listarUsuarios(ModelMap model) {
		model.addAttribute("usuarios", usuarioService.findAll());
		return "usuario/lista";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id) {
		usuarioService.deleteById(id);
		return "redirect:/usuario/lista";
	}
}
