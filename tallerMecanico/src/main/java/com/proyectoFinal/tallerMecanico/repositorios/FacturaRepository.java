package com.proyectoFinal.tallerMecanico.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyectoFinal.tallerMecanico.modelo.Factura;
import com.proyectoFinal.tallerMecanico.modelo.Usuario;

public interface FacturaRepository extends JpaRepository<Factura, Integer>{
	
		List<Factura> findAll();
		@Query("SELECT f FROM Factura f WHERE f.pagada='NO'")
		List<Factura> buscarFacturasNoPagadasConUnMesDeAntiguedad();
		
		@Query("SELECT f FROM Factura f WHERE f.id_usuario = ?1")
		List<Factura> findByUsuario(Usuario usuario);
		
		
//		@Query("SELECT F FROM Factura F WHERE F.id_usuario= :id ")
//		List<Factura> buscarFacturasPorIdUsuario(@Param("id") Integer id);
//		
		
//		@Query(value="SELECT * FROM FACTURA WHERE ID_USUARIO = ?1")
//		List<Factura> findAllById_usuario(Integer id_usuario);
		
		

}
