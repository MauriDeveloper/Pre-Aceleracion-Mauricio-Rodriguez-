package com.alkemy.challenge.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pelicula")
@Getter
@Setter
public class PeliculaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String imagen;
	
	@Column(name = "Titulo", length = 60)
	private String titulo;
	
	@Column(name = "fecha_creacion")
	@DateTimeFormat(pattern = "yyy/MM/dd")
	private LocalDate fechaDeCreacion;
	
	private int calificacion;
	
	@ManyToMany(
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
				}
			)
	@JoinTable(
			name = "personaje_peli",
			joinColumns = @JoinColumn(name = "pelicula_id"),
			inverseJoinColumns = @JoinColumn(name = "personaje_id")
			)
	private Set<PersonajeEntity> personajes = new HashSet<>();

	public PeliculaEntity() {
		
	}

	public PeliculaEntity(Long id, String imagen, String titulo, LocalDate fechaDeCreacion, int calificacion,
			Set<PersonajeEntity> personajes) {
		super();
		this.id = id;
		this.imagen = imagen;
		this.titulo = titulo;
		this.fechaDeCreacion = fechaDeCreacion;
		this.calificacion = calificacion;
		this.personajes = personajes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getFechaDeCreacion() {
		return fechaDeCreacion;
	}

	public void setFechaDeCreacion(LocalDate fechaDeCreacion) {
		this.fechaDeCreacion = fechaDeCreacion;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public Set<PersonajeEntity> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(Set<PersonajeEntity> personajes) {
		this.personajes = personajes;
	}
	
	
	
}
