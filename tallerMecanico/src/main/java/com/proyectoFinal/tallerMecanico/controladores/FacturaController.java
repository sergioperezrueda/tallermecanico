package com.proyectoFinal.tallerMecanico.controladores;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyectoFinal.tallerMecanico.modelo.Factura;
import com.proyectoFinal.tallerMecanico.servicios.FacturaService;

@Controller
public class FacturaController {
	@Autowired
	FacturaService facturaServicio;
	

	@GetMapping("/facturasplantilla")
	public String listaDeTodasLasFacturas(Model modelo, Factura factura) {
		modelo.addAttribute("factura", new Factura());
		modelo.addAttribute("facturas", facturaServicio.findAll());
		return "facturasplantilla";
	}

	@PostMapping("/nuevafactura")
	public String registroDeFactura(@ModelAttribute Factura factura) {
		Date fecha = new Date();
		factura.setFecha(fecha);
		facturaServicio.registrarFactura(factura);
		return "redirect:/facturasplantilla";
	}
}
