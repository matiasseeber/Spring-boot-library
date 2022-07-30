package root.daoImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import root.dao.DaoNacionalidad;
import root.entities.Autor;
import root.entities.Nacionalidad;

@Repository("DaoNacionalidadImpl")
public class DaoNacionalidadImpl implements DaoNacionalidad{

	@Autowired
	private Conexion conexion;
	
	public DaoNacionalidadImpl() {
	}

	@Override
	public boolean addNationality(Nacionalidad nacionalidad) {
		conexion.abrirConexion();
		boolean flag = true;
		try {
			conexion.InitTransaction();
			conexion.SaveObject(nacionalidad);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackTransaccion();
			flag = false;
		}
		conexion.cerrarSession();
		return flag;
	}

	@Override
	public ArrayList<Nacionalidad> getNationalities() {
		conexion.abrirConexion();
		ArrayList<Nacionalidad> lista = (ArrayList<Nacionalidad>)conexion.getSession().createQuery("FROM Nacionalidad").list();
		conexion.cerrarSession();
		return lista;
	}
}
