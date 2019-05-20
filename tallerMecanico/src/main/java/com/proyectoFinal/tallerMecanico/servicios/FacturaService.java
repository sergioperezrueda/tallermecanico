package com.proyectoFinal.tallerMecanico.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoFinal.tallerMecanico.modelo.Factura;
import com.proyectoFinal.tallerMecanico.repositorios.FacturaRepository;

@Service
public class FacturaService {
	
	@Autowired
	FacturaRepository repositorio;
	
	public List<Factura> findAll() {
		return repositorio.findAll();
	}
	
	public Factura registrarFactura(Factura f) {
		return repositorio.save(f);
	}

	

}
