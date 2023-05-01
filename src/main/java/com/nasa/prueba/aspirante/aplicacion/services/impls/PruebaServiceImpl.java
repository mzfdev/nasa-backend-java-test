package com.nasa.prueba.aspirante.aplicacion.services.impls;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nasa.prueba.aspirante.aplicacion.services.PruebaService;
import com.nasa.prueba.aspirante.dominio.entities.PruebaEntity;
import com.nasa.prueba.aspirante.infraestructura.repository.PruebaRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PruebaServiceImpl implements PruebaService {
    @Autowired
    private PruebaRepository pruebaRepository;

    @Override
    public List<PruebaEntity> obtenerPruebaEntities() {
        return pruebaRepository.findAll();
    }

	@Override
	public void crearPruebaEntity(PruebaEntity pruebaEntity) {
		// TODO Auto-generated method stub	
	}
}


