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

import com.proyectoFinal.tallerMecanico.modelo.Usuario;
import com.proyectoFinal.tallerMecanico.repositorios.UsuarioRepository;
import com.proyectoFinal.tallerMecanico.servicios.UsuarioService;

@Controller
public class UsuarioController {
	@Autowired
	UsuarioRepository repositorioUsuario;

	@Autowired
	UsuarioService usuarioServicio;

	@RequestMapping(path = "/admin/usuariosplantilla", method = RequestMethod.GET)
	public String conseguirTodosLosCoches() {
		return "admin/usuariosplantilla";
	}

	@PostMapping("/admin/nuevousuario")
	public String registroDeUsuario(@ModelAttribute Usuario usuario) {
		usuarioServicio.registrar(usuario);
		return "redirect:/admin/usuariosplantilla";
	}

	@GetMapping("/admin/formulariousuarionuevo")
	public String nuevoUsuarioForm(Model model, Usuario usuario) {
		model.addAttribute("usuarioForm", new Usuario());
		return "admin/usuariomodificar";
	}

	@GetMapping("/admin/modificarusuario/{id}")
	public String modificarUsuario(@PathVariable Integer id, Model model) {
		Usuario usuario = usuarioServicio.findByIdUsuario(id);
		if (usuario != null) {
			model.addAttribute("usuarioForm", usuario);
			return "admin/usuariomodificar";
		} else
			return "redirect:/admin/usuariosplantilla";
	}

}
