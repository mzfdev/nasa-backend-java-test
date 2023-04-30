package com.nasa.prueba.aspirante.infraestructura.clientrest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import com.nasa.prueba.aspirante.dominio.dto.PruebaDto;

public class PruebaClienteRest {
	
	private final RestTemplate restTemplate;

    @Value("${nasa.api.url}")
    private String nasaApiUrl;

    public PruebaClienteRest(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PruebaDto getPruebaDto() {
        String apiUrl = nasaApiUrl + "apollo%202011";
        return restTemplate.getForObject(apiUrl, PruebaDto.class);
    }
	
}
