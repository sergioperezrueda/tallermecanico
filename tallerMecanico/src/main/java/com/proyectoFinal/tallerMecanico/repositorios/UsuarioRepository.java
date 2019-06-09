package com.proyectoFinal.tallerMecanico.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.proyectoFinal.tallerMecanico.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	Usuario findFirstByEmail(String email);

	List<Usuario> findAll();
}
