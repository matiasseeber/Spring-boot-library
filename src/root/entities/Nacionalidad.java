package root.entities;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table (name = "Nacionalidad")
public class Nacionalidad implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column (name="ID")
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int ID;
	@Column (name="Descripcion")
	private String Descripcion;
	
	public Nacionalidad() {
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
}
