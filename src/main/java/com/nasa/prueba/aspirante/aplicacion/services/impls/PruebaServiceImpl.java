package com.nasa.prueba.aspirante.aplicacion.services.impls;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nasa.prueba.aspirante.aplicacion.services.PruebaService;
import com.nasa.prueba.aspirante.dominio.dto.PruebaDto;
import com.nasa.prueba.aspirante.dominio.entities.PruebaEntity;
import com.nasa.prueba.aspirante.infraestructura.clientrest.PruebaClienteRest;
import com.nasa.prueba.aspirante.infraestructura.repository.PruebaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.JpaSort;


//PruebaServiceImpl.java

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


