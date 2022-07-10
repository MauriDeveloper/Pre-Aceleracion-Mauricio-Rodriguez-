package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="genero")
@Getter
@Setter
public class GeneroEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "Nombre")
	private String nombre;
	
	private String imagen;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "pelicula_id", insertable = false, updatable = false)
	private PeliculaEntity pelicula;
	
	@Column(name = "pelicula_id", nullable = false)
	private Long peliculaId;

	public GeneroEntity() {
		
	}

	public GeneroEntity(Long id, String nombre, String imagen, PeliculaEntity pelicula, Long peliculaId) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
		this.pelicula = pelicula;
		this.peliculaId = peliculaId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public PeliculaEntity getPelicula() {
		return pelicula;
	}

	public void setPelicula(PeliculaEntity pelicula) {
		this.pelicula = pelicula;
	}

	public Long getPeliculaId() {
		return peliculaId;
	}

	public void setPeliculaId(Long peliculaId) {
		this.peliculaId = peliculaId;
	}
	
	
	
}
