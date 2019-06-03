package com.proyectoFinal.tallerMecanico.servicios;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoFinal.tallerMecanico.modelo.Factura;
import com.proyectoFinal.tallerMecanico.modelo.Usuario;
import com.proyectoFinal.tallerMecanico.repositorios.FacturaRepository;
import com.proyectoFinal.tallerMecanico.utilidades.fechasUtilidades;

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

	public void borrarFactura(Integer f) {
		repositorio.deleteById(f);
	}

	public Factura findByIdFactura(Integer id) {
		return repositorio.findById(id).orElse(null);
	}

	public List<Factura> buscarFacturasNoPagadasConUnMesDeAntiguedad() {
		List<Factura> facturas = repositorio.buscarFacturasNoPagadasConUnMesDeAntiguedad();
		List<Factura> facturasFinales = new ArrayList<Factura>();
		Date fechaActual = new Date();
		String fechaFactura;
		String fechaActualAuxiliar = new SimpleDateFormat("yyyy-MM-dd")
				.format(fechasUtilidades.restarDias(fechaActual, 30));
		for (Factura factura : facturas) {
			fechaFactura = new SimpleDateFormat("yyyy-MM-dd").format(factura.getFecha());
			if (fechaActualAuxiliar.equals(fechaFactura)) {
				facturasFinales.add(factura);
			}
		}
		return facturasFinales;
	}

	public List<Factura> facturasDeUnUsuario(Usuario u) {
		return repositorio.findByUsuario(u);
	}

	public Factura verFactura(Integer f) {
		return repositorio.findById(f).orElse(null);
	}
	
	
}
