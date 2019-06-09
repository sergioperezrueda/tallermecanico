package com.proyectoFinal.tallerMecanico.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoFinal.tallerMecanico.modelo.Coche;
import com.proyectoFinal.tallerMecanico.repositorios.CocheRepository;

@Service
public class CocheService {
	@Autowired
	CocheRepository repositorio;

	public List<Coche> findAll() {
		return repositorio.findAll();
	}

	public Coche registrarCoche(Coche c) {
		return repositorio.save(c);
	}

	public Coche findByIdCoche(Integer id) {
		return repositorio.findById(id).orElse(null);
	}

}
