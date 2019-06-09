package com.proyectoFinal.tallerMecanico.servicios;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.proyectoFinal.tallerMecanico.modelo.Factura;
import com.proyectoFinal.tallerMecanico.modelo.Usuario;
import com.proyectoFinal.tallerMecanico.repositorios.FacturaRepository;

@Service
public class SchuledServicio {
	@Autowired
	FacturaRepository repositorio;
	@Autowired
	FacturaService servicio;

	@Autowired
	private JavaMailSender sender;

	@Scheduled(cron = "0 0 23 * * *", zone = "Europe/Madrid")
	public void EnviarCorreoFacturasSinPagarUnMes() throws Exception {
		Usuario usuario;
		List<Factura> facturas = servicio.buscarFacturasNoPagadasConUnMesDeAntiguedad();
		for (Factura factura : facturas) {
			usuario = factura.getId_usuario();
			String correo = usuario.getEmail();
			sendEmail(correo);
	}

	}

	private void sendEmail(String correo) throws Exception {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setTo(correo);
		helper.setText("El motivo de este correo es para informarle que tiene facturas pendientes con nuestro taller");
		helper.setSubject("Facturas pendientes");

		sender.send(message);
	}
}
