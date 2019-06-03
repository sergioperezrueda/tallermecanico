package com.proyectoFinal.tallerMecanico.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyectoFinal.tallerMecanico.modelo.Usuario;
import com.proyectoFinal.tallerMecanico.servicios.UsuarioService;

@Controller
public class LoginController {

	@Autowired
	UsuarioService usuarioServicio;
	
	@GetMapping("/")
	public String welcome() {
		return "redirect:/auth/login";
	}
	
	@GetMapping("/auth/login")
	public String login(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login";
	}
	
	
	 @RequestMapping("/default")
	    public String defaultAfterLogin(HttpServletRequest request) {
	        if (request.isUserInRole("ROLE_ADMIN")) {
	            return "redirect:/admin/facturasplantilla";
	        }else {
	        return "redirect:/usuario/indexusuario";
	        }
	    }
	
	
}
