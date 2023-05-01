package com.nasa.prueba.aspirante.aplicacion.taskscheduler;

import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nasa.prueba.aspirante.infraestructura.clientrest.PruebaClienteRest;

@Component
public class PruebaTask {
	
	@Autowired
    private PruebaClienteRest pruebaClienteRest;

	@PostConstruct
    public void execute() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                pruebaClienteRest.search("apollo 2011"); // Realiza la búsqueda y guarda los datos en la base de datos
            }
        }, 0, 60000); // Ejecutar cada 1 minuto
    }
}

