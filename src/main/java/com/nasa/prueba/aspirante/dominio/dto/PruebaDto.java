package com.nasa.prueba.aspirante.dominio.dto;

import java.time.LocalDateTime;

public class PruebaDto {
	private String href;
    private String center;
    private String title;
    private String nasa_id;
    private LocalDateTime created_at;
    
    public PruebaDto() {
		super();
	}

	public PruebaDto(String href, String center, String title, String nasa_id, LocalDateTime created_at) {
		super();
		this.href = href;
		this.center = center;
		this.title = title;
		this.nasa_id = nasa_id;
		this.created_at = created_at;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getCenter() {
		return center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNasa_id() {
		return nasa_id;
	}

	public void setNasa_id(String nasa_id) {
		this.nasa_id = nasa_id;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
}
