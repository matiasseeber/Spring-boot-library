package root.daoImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import root.dao.DaoGeneros;
import root.entities.Genero;

@Repository("DaoGeneroImpl")
public class DaoGeneroImpl implements DaoGeneros{

	@Autowired
	private Conexion conexion;
	
	@Override
	public boolean addGenre(Genero genero) {
		conexion.abrirConexion();
		boolean flag = true;
		try {
			conexion.InitTransaction();
			conexion.SaveObject(genero);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackTransaccion();
			flag = false;
		}
		conexion.cerrarSession();
		return flag;
	}

	@Override
	public ArrayList<Genero> getAllGenres() {
		conexion.abrirConexion();
		ArrayList<Genero> lista = (ArrayList<Genero>)conexion.getSession().createQuery("FROM Genero").list();
		conexion.cerrarSession();
		return lista;
	}

}
