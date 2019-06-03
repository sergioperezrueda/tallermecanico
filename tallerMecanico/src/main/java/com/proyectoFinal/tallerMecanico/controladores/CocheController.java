package com.proyectoFinal.tallerMecanico.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proyectoFinal.tallerMecanico.modelo.Coche;
import com.proyectoFinal.tallerMecanico.repositorios.CocheRepository;
import com.proyectoFinal.tallerMecanico.servicios.CocheService;

@Controller
public class CocheController {
	@Autowired
	CocheRepository repositorioCoche;

	@Autowired
	CocheService cocheServicio;

	@RequestMapping(path = "/admin/cochesplantilla", method = RequestMethod.GET)
	public String conseguirTodosLosCoches() {
		return "admin/cochesplantilla";
	}

	@PostMapping("/admin/nuevocoche")
	public String registroDeCoche(@ModelAttribute Coche coche) {
		cocheServicio.registrarCoche(coche);
		return "redirect:/admin/cochesplantilla";
	}

	@GetMapping("/admin/formulariocochenuevo")
	public String nuevoCocheForm(Model model, Coche coche) {
		model.addAttribute("cocheForm", new Coche());
		return "admin/cochemodificar";
	}

	@GetMapping("/admin/modificarcoche/{id}")
	public String modificarCoche(@PathVariable Integer id, Model model) {
		Coche coche = cocheServicio.findByIdCoche(id);
		if (coche != null) {
			model.addAttribute("cocheForm", coche);
			return "admin/cochemodificar";
		} else
			return "redirect:/admin/cochesplantilla";
	}
}
