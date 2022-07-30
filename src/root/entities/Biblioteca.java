package root.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table (name = "Biblioteca")
public class Biblioteca implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column (name="ID")
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int ID;
	@ManyToOne (cascade= {})
	@JoinColumn (name="ISBN")
	private Libro libro;
	@Column (name="Fecha_de_alta")
	private Date FechaDeAlta;
	@Column (name="Estado")
	private String Estado;
	
	public Biblioteca() {
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Date getFechaDeAlta() {
		return FechaDeAlta;
	}

	public void setFechaDeAlta(Date fechaDeAlta) {
		FechaDeAlta = fechaDeAlta;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}
}
