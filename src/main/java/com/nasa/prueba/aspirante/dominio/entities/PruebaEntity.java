package com.nasa.prueba.aspirante.dominio.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "prueba_entity")
public class PruebaEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "href")
    private String href;
    
    @Column(name = "center")
    private String center;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "nasa_id")
    private String nasa_id;
    
    @Column(name = "created_at")
    private LocalDateTime created_at;

	public PruebaEntity(String href, String center, String title, String nasa_id) {
		super();
		this.href = href;
		this.center = center;
		this.title = title;
		this.nasa_id = nasa_id;
	}

	public PruebaEntity() {
		super();
	}
	
	@PrePersist
    public void prePersist() {
        this.created_at = LocalDateTime.now();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
}
