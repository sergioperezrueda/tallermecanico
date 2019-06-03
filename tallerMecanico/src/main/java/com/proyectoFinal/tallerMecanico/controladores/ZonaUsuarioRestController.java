package com.proyectoFinal.tallerMecanico.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoFinal.tallerMecanico.modelo.Factura;
import com.proyectoFinal.tallerMecanico.modelo.Usuario;
import com.proyectoFinal.tallerMecanico.servicios.FacturaService;
import com.proyectoFinal.tallerMecanico.servicios.UsuarioService;

@RestController
public class ZonaUsuarioRestController {

	@Autowired
	FacturaService facturaServicio;
	@Autowired
	UsuarioService usuarioServicio;

	public Usuario usuario;

	@RequestMapping(path = "/usuario/usuario", method = RequestMethod.GET)
	public List<Factura> conseguirTodosMisFacturas() {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		Usuario usuario = new Usuario();
		usuario = usuarioServicio.buscarPorEmail(email);
		return facturaServicio.facturasDeUnUsuario(usuario);
	}

	@RequestMapping(value = "/usuario/usuario/{id}", method = RequestMethod.GET)
	public Factura conseguirFacturaPorId(@PathVariable("id") Integer id) {
		return facturaServicio.findByIdFactura(id);
	}
}
