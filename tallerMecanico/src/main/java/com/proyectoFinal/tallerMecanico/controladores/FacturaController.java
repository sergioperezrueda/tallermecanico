package com.proyectoFinal.tallerMecanico.controladores;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyectoFinal.tallerMecanico.modelo.Coche;
import com.proyectoFinal.tallerMecanico.modelo.Factura;
import com.proyectoFinal.tallerMecanico.modelo.Usuario;
import com.proyectoFinal.tallerMecanico.repositorios.CocheRepository;
import com.proyectoFinal.tallerMecanico.repositorios.UsuarioRepository;
import com.proyectoFinal.tallerMecanico.servicios.CocheService;
import com.proyectoFinal.tallerMecanico.servicios.FacturaService;
import com.proyectoFinal.tallerMecanico.servicios.UsuarioService;

@Controller
public class FacturaController {
	
	@Autowired
	CocheRepository repositorioCoche;
	@Autowired
	UsuarioRepository repositorioUsuario;

	@Autowired
	CocheService cocheServicio;
	@Autowired
	FacturaService facturaServicio;
	@Autowired
	UsuarioService usuarioServicio;
	
	@GetMapping({ "/admin", "/admin/indexadmin" })
	public String indexAdmin(Model model, @RequestParam(name = "q", required = false) String query) {
		return "admin/facturasplantilla";
	}
	
	@GetMapping("/admin/facturasplantilla")
	public String conseguirTodasLasFacturas() {
		return "admin/facturasplantilla";
	}


	@GetMapping("/admin/borrarfactura/{id}")
	public String borradoDeFactura(@PathVariable(value = "id") Integer f) {
		facturaServicio.borrarFactura(f);
		return "redirect:/admin/facturasplantilla";
	}

	@PostMapping("/admin/nuevafactura")
	public String registroDeFactura(@ModelAttribute Factura factura) {
		if (factura.getId_factura() != null) {
			Factura facturaAntigua = facturaServicio.findByIdFactura(factura.getId_factura());
			factura.setFecha(facturaAntigua.getFecha());
		} else {
			Date fecha = new Date();
			factura.setFecha(fecha);
		}
		facturaServicio.registrarFactura(factura);
		return "redirect:/admin/facturasplantilla";
	}

	@GetMapping("/admin/formulariofacturanueva")
	public String nuevaFacturaForm(Model model, Model modeloFactura, Factura factura, Model modeloUsuario,
			Usuario usuario, Model modeloCoche, Coche coche) {
		model.addAttribute("facturaForm", new Factura());

		modeloUsuario.addAttribute("usuario", new Usuario());
		modeloUsuario.addAttribute("usuarios", usuarioServicio.findAll());

		modeloUsuario.addAttribute("coche", new Coche());
		modeloUsuario.addAttribute("coches", cocheServicio.findAll());
		return "admin/facturamodificar";
	}

	@GetMapping("/admin/modificarfactura/{id}")
	public String modificarFactura(@PathVariable Integer id, Model model, Model modeloUsuario, Usuario usuario,
			Model modeloCoche, Coche coche) {

		modeloUsuario.addAttribute("usuario", new Usuario());
		modeloUsuario.addAttribute("usuarios", usuarioServicio.findAll());

		modeloUsuario.addAttribute("coche", new Coche());
		modeloUsuario.addAttribute("coches", cocheServicio.findAll());
		Factura factura = facturaServicio.findByIdFactura(id);
		if (factura != null) {
			model.addAttribute("facturaForm", factura);
			return "admin/facturamodificar";
		} else
			return "redirect:/admin/facturamodificar";
	}
}
