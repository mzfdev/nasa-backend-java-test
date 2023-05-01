package com.nasa.prueba.aspirante.infraestructura.clientrest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nasa.prueba.aspirante.dominio.dto.PruebaDto;
import com.nasa.prueba.aspirante.dominio.entities.PruebaEntity;
import com.nasa.prueba.aspirante.infraestructura.repository.PruebaRepository;

@Component
public class PruebaClienteRest {
	
	private static final String API_BASE_URL = "https://images-api.nasa.gov/search?q=";

	@Autowired
    private PruebaRepository pruebaRepository;

    public void search(String query) {
    	 RestTemplate restTemplate = new RestTemplate();
    	 String url = API_BASE_URL + query;
    	 String result = restTemplate.getForObject(url, String.class);
    	 Optional<PruebaEntity> entity = convertResponseToEntities(result);
    	 entity.ifPresent(pruebaRepository::save);
    }
    
    private int lastIndex = 0;
    
    private Optional<PruebaEntity> convertResponseToEntities(String response) {
    	 try {
    	        ObjectMapper mapper = new ObjectMapper();
    	        JsonNode root = mapper.readTree(response);
    	        JsonNode items = root.get("collection").get("items");
    	        if (items.isArray() && items.size() > 0) {
    	            if (lastIndex >= items.size()) {
    	                lastIndex = 0;
    	            }
    	            JsonNode item = items.get(lastIndex++);
    	            JsonNode data = item.get("data").get(0);
    	            String href = item.get("href").asText();
    	            String center = data.get("center").asText();
    	            String title = data.get("title").asText();
    	            String nasa_id = data.get("nasa_id").asText();
    	            return Optional.of(new PruebaEntity(href, center, title, nasa_id));
    	        }
    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    }
    	    return Optional.empty();
    }
}
