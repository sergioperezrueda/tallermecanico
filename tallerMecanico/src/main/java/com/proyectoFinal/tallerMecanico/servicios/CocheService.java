package com.proyectoFinal.tallerMecanico.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoFinal.tallerMecanico.modelo.Coche;
import com.proyectoFinal.tallerMecanico.repositorios.CocheRepository;

@Service
public class CocheService{
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

	public List<Coche> buscarPorMatriculaMarcaOModelo(String matricula, String marca, String modelo) {
//		if (filtrado != null) {
//			if (filtrado.equals("matricula")) {
//				return repositorio.findByMatriculaContainsIgnoreCase(condicion);
//			} else if (filtrado.equals("modelo")) {
//				return repositorio.findByModeloContainsIgnoreCase(condicion);
//			} else if (filtrado.equals("marca")) {
//				return repositorio.findByMarcaContainsIgnoreCase(condicion);
//			}
//		}
		if(matricula == null && marca == null && modelo == null) {
			return repositorio.findAll();
		}
		if(matricula == null) {
			matricula = "";
		}
		if(marca == null) {
			marca = "";
		}
		if(modelo == null) {
			modelo = "";
		}
		
		return repositorio.findByMatriculaContainsIgnoreCaseOrMarcaContainsIgnoreCaseOrModeloContainsIgnoreCase(matricula, marca, modelo);

	}

}
