package com.proyectoFinal.tallerMecanico.modelo;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Coche {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_coche;
	
	private String matricula;
	private String marca;
	private String modelo;
	
	
	public Coche() {
		
		
	}


	public Coche(Integer id_coche, String matricula, String marca, String modelo) {
		super();
		this.id_coche = id_coche;
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
	}


	public Integer getId_coche() {
		return id_coche;
	}


	public void setId_coche(Integer id_coche) {
		this.id_coche = id_coche;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_coche == null) ? 0 : id_coche.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
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
		Coche other = (Coche) obj;
		if (id_coche == null) {
			if (other.id_coche != null)
				return false;
		} else if (!id_coche.equals(other.id_coche))
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Coche [id_coche=" + id_coche + ", matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo
				+ "]";
	}
	
	
	
	
}
