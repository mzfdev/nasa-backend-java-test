package com.nasa.prueba.aspirante.aplicacion.services;

import java.util.List;
import com.nasa.prueba.aspirante.dominio.entities.PruebaEntity;

public interface PruebaService {
	void crearPruebaEntity(PruebaEntity pruebaEntity);
    List<PruebaEntity> obtenerPruebaEntities();
}
