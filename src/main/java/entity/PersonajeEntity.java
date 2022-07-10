package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "personaje")
@Getter
@Setter
public class PersonajeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String imagen;
	
	@Column(name = "nombre", length = 40)
	private String nombre;
	
	@Column(name = "edad")
	private int edad;
	
	private float peso;
	
	private String historia;
	
	@ManyToMany(mappedBy = "personajes", cascade = CascadeType.ALL)
	private List<PeliculaEntity> peliculas = new ArrayList<>();
	
	public PersonajeEntity() {
		
	}
	
	public PersonajeEntity(Long id, String imagen, String nombre, int edad, float peso, String historia,
			List<PeliculaEntity> peliculas) {
		super();
		this.id = id;
		this.imagen = imagen;
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.historia = historia;
		this.peliculas = peliculas;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public String getHistoria() {
		return historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}

	public List<PeliculaEntity> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<PeliculaEntity> peliculas) {
		this.peliculas = peliculas;
	}
	
	
}
