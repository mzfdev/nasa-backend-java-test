package com.nasa.prueba.aspirante.infraestructura.restcontroller;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.prueba.aspirante.aplicacion.services.PruebaService;
import com.nasa.prueba.aspirante.dominio.entities.PruebaEntity;

@RestController
@RequestMapping("/Pruebas")
@CrossOrigin(origins = "http://localhost:3000")
public class PruebaRestController {
	
	@Autowired
	private PruebaService pruebaService;
	
	@GetMapping("/Pruebas_view")
	public ResponseEntity<List<PruebaEntity>> ObtenerPruebas(){
		try {
			List<PruebaEntity> pruebas = pruebaService.obtenerPruebaEntities();
			pruebas.sort(Comparator.comparingLong(PruebaEntity::getId).reversed());
			return new ResponseEntity<>(
					pruebas,
					HttpStatus.OK
					);
			
		}catch(Exception e) {
			return new ResponseEntity<>(
					null,
					HttpStatus.INTERNAL_SERVER_ERROR
					);
		}
	}
}
