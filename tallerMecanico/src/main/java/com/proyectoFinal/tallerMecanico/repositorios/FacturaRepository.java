package com.proyectoFinal.tallerMecanico.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectoFinal.tallerMecanico.modelo.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Integer>{
	
		List<Factura> findAll();
		

}
