package root.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table (name = "Prestamos")
public class Prestamos implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column (name="ID_Prestamo")
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int ID_Prestamo;
	@ManyToOne(cascade= {})
	@JoinColumn(name="ID")
	private Biblioteca biblioteca;
	@Column (name="fechaPrestamo")
	private Date fechaDePrestamo;
	@Column (name="cantidadDias")
	private int cantDias;
	@ManyToOne(cascade= {})
	@JoinColumn (name="ID_Cliente")
	private Clientes cliente;
	@Column (name="estado")
	private boolean estado;
	public Prestamos() {
		
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getID() {
		return ID_Prestamo;
	}

	public void setID(int iD) {
		ID_Prestamo = iD;
	}

	public Biblioteca getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}

	public Date getFechaDePrestamo() {
		return fechaDePrestamo;
	}

	public void setFechaDePrestamo(Date fechaDePrestamo) {
		this.fechaDePrestamo = fechaDePrestamo;
	}

	public int getCantDias() {
		return cantDias;
	}

	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}
}
