package root.entities;

import java.io.Serializable;

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
@Table (name = "Autor")
public class Autor implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column (name="ID")
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int ID;
	@Column (name="Nombre")
	private String Nombre;
	@Column (name="Apellido")
	private String Apellido;
	@Column (name="Email")
	private String Email;
	@ManyToOne (cascade= {})
	@JoinColumn (name="Nacionalidad")
	private Nacionalidad nacionalidad;
	
	public Autor() {
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getNombreCompleto() {
		return Nombre + " " + Apellido;
	}
	
	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Nacionalidad getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
}
