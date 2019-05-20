package com.proyectoFinal.tallerMecanico.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_factura;

	@ManyToOne
	private Usuario id_usuario;

	@ManyToOne
	private Coche id_coche;

	@CreatedDate
	//@Temporal(TemporalType.TIMESTAMP) PARA FECHA Y HORA
	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String descripcion;
	private float importe;
	private String pagada;

	public Factura() {

	}

	public Factura(int id_factura, Usuario id_usuario, Coche id_coche, Date fecha, String descripcion, float importe,
			String pagada) {
		super();
		this.id_factura = id_factura;
		this.id_usuario = id_usuario;
		this.id_coche = id_coche;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.importe = importe;
		this.pagada = pagada;
	}

	public int getId_factura() {
		return id_factura;
	}

	public void setId_factura(int id_factura) {
		this.id_factura = id_factura;
	}

	public Usuario getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Usuario id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Coche getId_coche() {
		return id_coche;
	}

	public void setId_coche(Coche id_coche) {
		this.id_coche = id_coche;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public String getPagada() {
		return pagada;
	}

	public void setPagada(String pagada) {
		this.pagada = pagada;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((id_coche == null) ? 0 : id_coche.hashCode());
		result = prime * result + id_factura;
		result = prime * result + ((id_usuario == null) ? 0 : id_usuario.hashCode());
		result = prime * result + Float.floatToIntBits(importe);
		result = prime * result + ((pagada == null) ? 0 : pagada.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Factura other = (Factura) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id_coche == null) {
			if (other.id_coche != null)
				return false;
		} else if (!id_coche.equals(other.id_coche))
			return false;
		if (id_factura != other.id_factura)
			return false;
		if (id_usuario == null) {
			if (other.id_usuario != null)
				return false;
		} else if (!id_usuario.equals(other.id_usuario))
			return false;
		if (Float.floatToIntBits(importe) != Float.floatToIntBits(other.importe))
			return false;
		if (pagada == null) {
			if (other.pagada != null)
				return false;
		} else if (!pagada.equals(other.pagada))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Factura [id_factura=" + id_factura + ", id_usuario=" + id_usuario + ", id_coche=" + id_coche
				+ ", fecha=" + fecha + ", descripcion=" + descripcion + ", importe=" + importe + ", pagada=" + pagada
				+ "]";
	}

}
