package com.proyectoFinal.tallerMecanico.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoFinal.tallerMecanico.modelo.Factura;
import com.proyectoFinal.tallerMecanico.servicios.FacturaService;
@RestController
public class FacturaRestController {
	@Autowired
	FacturaService facturaServicio;
	@RequestMapping(path="/admin/factura", method=RequestMethod.GET)
	public List<Factura> conseguirTodosLosCoches(){
		return facturaServicio.findAll();
	}
    @RequestMapping(value = "/admin/factura/{id}", method = RequestMethod.GET)
	public Factura conseguirCochePorId(@PathVariable("id") Integer id){
		return facturaServicio.findByIdFactura(id);
	}

}
