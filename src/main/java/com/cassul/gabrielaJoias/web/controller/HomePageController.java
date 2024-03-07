package com.cassul.gabrielaJoias.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {

	@GetMapping("/")
	public String init() {
		return "redirect:/homePage";
	}
	
	@GetMapping("/homePage")
	public String abrirPaginaInicial() {
		return "homePage";
	}
}
