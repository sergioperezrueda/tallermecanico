package com.proyectoFinal.tallerMecanico.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoFinal.tallerMecanico.modelo.Usuario;
import com.proyectoFinal.tallerMecanico.servicios.UsuarioService;

@RestController
public class UsuarioRestController {

	@Autowired
	UsuarioService usuarioServicio;

	@RequestMapping(path = "/admin/usuario", method = RequestMethod.GET)
	public List<Usuario> conseguirTodosLosUsuarios() {
		return usuarioServicio.findAll();
	}

	@RequestMapping(value = "/admin/usuario/{id}", method = RequestMethod.GET)
	public Usuario conseguirUsuarioPorId(@PathVariable("id") Integer id) {
		return usuarioServicio.findByIdUsuario(id);
	}
}
