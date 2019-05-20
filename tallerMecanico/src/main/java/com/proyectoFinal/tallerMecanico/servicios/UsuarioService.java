package com.proyectoFinal.tallerMecanico.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.proyectoFinal.tallerMecanico.modelo.Usuario;
import com.proyectoFinal.tallerMecanico.repositorios.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository repositorio;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	public Usuario registrar(Usuario u) {
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		u.setPermisos("U");
		return repositorio.save(u);
	}

	public Usuario findById(Integer id) {
		return repositorio.findById(id).orElse(null);
	}
	
	public List<Usuario> findAll() {
		return repositorio.findAll();
	}

	public Usuario buscarPorEmail(String email) {
		return repositorio.findFirstByEmail(email);
	}
}