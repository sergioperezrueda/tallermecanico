package com.proyectoFinal.tallerMecanico.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.proyectoFinal.tallerMecanico.modelo.Coche;

public interface CocheRepository extends JpaRepository<Coche, Integer> {
	List<Coche> findAll();

}
