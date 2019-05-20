package com.proyectoFinal.tallerMecanico.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/public")
public class ZonaPublicaController {


	@GetMapping({ "/", "/index" })
	public String index(Model model, @RequestParam(name = "q", required = false) String query) {
		return "index";
	}

}
