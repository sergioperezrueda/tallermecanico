package com.proyectoFinal.tallerMecanico.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.proyectoFinal.tallerMecanico.modelo.Factura;
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
		return repositorio.save(u);
	}
	
	public List<Usuario> findAll() {
		return repositorio.findAll();
	}

	public Usuario buscarPorEmail(String email) {
		return repositorio.findFirstByEmail(email);
	}
	
	public Usuario findByIdUsuario(Integer id) {
		return repositorio.findById(id).orElse(null);
	}
	
//	public List<Usuario> buscarPorNombreApellidosEmailOPermisos(String condicion, String filtrado) {
//		if (filtrado != null) {
//			if (filtrado.equals("matricula")) {
//				return repositorio.findByMatriculaContainsIgnoreCase(condicion);
//			} else if (filtrado.equals("modelo")) {
//				return repositorio.findByModeloContainsIgnoreCase(condicion);
//			} else if (filtrado.equals("marca")) {
//				return repositorio.findByMarcaContainsIgnoreCase(condicion);
//			}
//		}
		
		
}