package root.entities;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;


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
@Table (name = "Clientes")
public class Clientes implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column (name="ID_Cliente")
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int ID;
	@Column (name="DNI")
	private int Dni;
	@Column (name="Nombre")
	private String Nombre;
	@Column (name="Apellido")
	private String Apellido;
	@Column (name="Email")
	private String Email;
	@Column (name="Sexo")
	private String Sexo;
	@ManyToOne (cascade= {})
	@JoinColumn (name="Nacionalidad")
	private Nacionalidad nacionalidad;
	@Column (name="Direccion")
	private String Direccion;
	@Column (name="Localidad")
	private String Localidad;
	@Column (name="Telefono")
	private int Telefono;
	@Column (name="FechaNacimiento")
	private Date FechaNacimiento;
	
	public Clientes() {
		
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getDni() {
		return Dni;
	}
	public void setDni(int dni) {
		Dni = dni;
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
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Nacionalidad getNacionalidad() {
		return nacionalidad;
	}
	
	public String getNombreCompleto() {
		return Nombre + " " + Apellido;
	}
	
	public void setNacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getLocalidad() {
		return Localidad;
	}
	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}
	public Date getFechaNacimiento() {
		return FechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}
	public int getTelefono() {
		return Telefono;
	}
	public void setTelefono(int telefono) {
		Telefono = telefono;
	}
	public String getSexo() {
		return Sexo;
	}
	public void setSexo(String sexo) {
		Sexo = sexo;
	}
}
