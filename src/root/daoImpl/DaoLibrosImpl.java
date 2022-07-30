package root.daoImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import root.dao.DaoLibros;
import root.entities.Libro;

@Repository("DaoLibrosImpl")
public class DaoLibrosImpl implements DaoLibros{

	@Autowired
	private Conexion conexion;
	
	@Override
	public boolean addBook(Libro libro) {
		conexion.abrirConexion();
		boolean flag = true;
		try {
			conexion.InitTransaction();
			conexion.SaveObject(libro);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			conexion.RollbackTransaccion();
			flag = false;
		}
		conexion.cerrarSession();
		return flag;
	}

	@Override
	public ArrayList<Libro> getBooks() {
		conexion.abrirConexion();
		ArrayList<Libro> lista = (ArrayList<Libro>)conexion.getSession().createQuery("FROM Libro").list();
		conexion.cerrarSession();
		return lista;
	}

	@Override
	public boolean modifyBook(Libro libro) {
		conexion.abrirConexion();
		boolean flag = true;
		try {
			conexion.InitTransaction();
			conexion.UpdateObject(libro);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackTransaccion();
			flag = false;
		}
		conexion.cerrarSession();
		return flag;
	}

}
