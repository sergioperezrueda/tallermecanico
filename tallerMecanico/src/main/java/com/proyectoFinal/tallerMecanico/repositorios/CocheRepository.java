package com.proyectoFinal.tallerMecanico.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectoFinal.tallerMecanico.modelo.Coche;

public interface CocheRepository extends JpaRepository<Coche, Integer> {

	List<Coche> findAll();

//	List<Coche> findByMatriculaContainsIgnoreCase(String matricula);
//
//	List<Coche> findByModeloContainsIgnoreCase(String condicion);
//
//	List<Coche> findByMarcaContainsIgnoreCase(String condicion);

	List<Coche> findByMatriculaContainsIgnoreCaseOrMarcaContainsIgnoreCaseOrModeloContainsIgnoreCase(
			String matricula,String marca, String modelo);
}
