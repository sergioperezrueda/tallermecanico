package com.proyectoFinal.tallerMecanico.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoFinal.tallerMecanico.modelo.Coche;
import com.proyectoFinal.tallerMecanico.servicios.CocheService;

@RestController
public class CocheRestController {
	@Autowired
	CocheService cocheServicio;
	@RequestMapping(path="/admin/coche", method=RequestMethod.GET)
	public List<Coche> conseguirTodosLosCoches(){
		return cocheServicio.findAll();
	}
    @RequestMapping(value = "/admin/coche/{id}", method = RequestMethod.GET)
	public Coche conseguirCochePorId(@PathVariable("id") Integer id){
		return cocheServicio.findByIdCoche(id);
	}

}
