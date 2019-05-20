package com.proyectoFinal.tallerMecanico.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyectoFinal.tallerMecanico.modelo.Coche;
import com.proyectoFinal.tallerMecanico.repositorios.CocheRepository;
import com.proyectoFinal.tallerMecanico.servicios.CocheService;

@Controller
public class CocheController {

	@Autowired
	CocheService cocheServicio;
	@Autowired
	CocheRepository repositorioCoche;
	
	@GetMapping("/cochesplantilla")
	public String listaDeTodosLosCoches(Model modelo, Coche coche) {
		modelo.addAttribute("coche", new Coche());
		modelo.addAttribute("coches", repositorioCoche.findAll());
		return "cochesplantilla";
	}
	
	@PostMapping("/nuevocoche")
	public String registroDeCoche(@ModelAttribute Coche coche) {
	cocheServicio.registrarCoche(coche);
	return "redirect:/cochesplantilla";
}
}
