package com.proyectoFinal.tallerMecanico.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proyectoFinal.tallerMecanico.modelo.Factura;
import com.proyectoFinal.tallerMecanico.modelo.Usuario;
import com.proyectoFinal.tallerMecanico.servicios.FacturaService;
import com.proyectoFinal.tallerMecanico.servicios.UsuarioService;

@Controller
public class ZonaUsuarioController {
	@Autowired
	FacturaService facturaServicio;
	@Autowired
	UsuarioService usuarioServicio;

	public Usuario usuario;

	@RequestMapping(path = "/usuario/indexusuario", method = RequestMethod.GET)
	public String conseguirTodasMisFacturas() {
		return "usuario/indexusuario";
	}

	@GetMapping("/usuario/")
	public String indexZonaUsuario() {
		return "usuario/indexusuario";
	}

	@GetMapping("/usuario/verfactura/{id}")
	public String verFacturaPropia(@PathVariable(value = "id") Integer f, Model modeloFactura) {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		Factura facturaSolicitada = facturaServicio.findByIdFactura(f);
		usuario = usuarioServicio.buscarPorEmail(email);
		Usuario usuarioAuxiliar = facturaSolicitada.getId_usuario();
		if (usuario.equals(usuarioAuxiliar)) {
			Factura factura = facturaServicio.findByIdFactura(f);
			modeloFactura.addAttribute("factura", factura);
			return "usuario/usuariofacturas";
		}
		return "usuario/indexusuario";
	}

}
