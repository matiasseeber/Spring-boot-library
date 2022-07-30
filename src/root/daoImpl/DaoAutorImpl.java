package root.daoImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import root.dao.DaoAutor;
import root.entities.Autor;

@Repository("DaoAutorImpl")
public class DaoAutorImpl implements DaoAutor{

	@Autowired
	private Conexion conexion;
	
	@Override
	public boolean addWritter(Autor autor) {
		conexion.abrirConexion();
		boolean flag = true;
		try {
			conexion.InitTransaction();
			conexion.SaveObject(autor);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackTransaccion();
			flag = false;
		}
		conexion.cerrarSession();
		return flag;
	}

	@Override
	public ArrayList<Autor> getAllWriters() {
		conexion.abrirConexion();
		ArrayList<Autor> lista = (ArrayList<Autor>)conexion.getSession().createQuery("FROM Autor").list();
		conexion.cerrarSession();
		return lista;
	}
}
