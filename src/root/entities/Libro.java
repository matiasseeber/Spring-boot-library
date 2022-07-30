package root.entities;
import java.io.Serializable;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table (name="Libro")
public class Libro implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column (name="ISBN")
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int ISBN;
	@Column (name="Titulo")
	private String Titulo;
	@Column (name="Fecha_de_lanzamiento")
	private Date FechaLanzamiento;
	@Column (name="Idioma")
	private String idioma;
	@Column (name="Cantidad_de_paginas")
	private int cantidadPaginas;
	@Column (name="Descripcion")
	private String Descripcion;
	@ManyToOne (cascade= {})
	@JoinColumn (name="ID_Autor")
	private Autor autor;
	@ManyToMany (cascade = {}) 
	@JoinTable (name="Libros_X_Generos", joinColumns = {@JoinColumn(name="ISBN")}, inverseJoinColumns = {@JoinColumn(name="ID_Genero")})
	private Set<Genero> Generos;
	
	public Libro() {
		
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public Date getFechaLanzamiento() {
		return FechaLanzamiento;
	}

	public void setFechaLanzamiento(Date fechaLanzamiento) {
		FechaLanzamiento = fechaLanzamiento;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public int getCantidadPaginas() {
		return cantidadPaginas;
	}

	public void setCantidadPaginas(int cantidadPaginas) {
		this.cantidadPaginas = cantidadPaginas;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Set<Genero> getGeneros() {
		return Generos;
	}

	public void setGeneros(Set<Genero> generos) {
		Generos = generos;
	}
}
