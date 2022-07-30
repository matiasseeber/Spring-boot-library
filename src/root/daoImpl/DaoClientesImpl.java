package root.daoImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import root.dao.DaoClientes;
import root.entities.Autor;
import root.entities.Clientes;

@Repository("DaoClientesImpl")
public class DaoClientesImpl implements DaoClientes{

	@Autowired
	private Conexion conexion;
	
	@Override
	public boolean AddClient(Clientes cliente) {
		conexion.abrirConexion();
		boolean flag = true;
		try {
			conexion.InitTransaction();
			conexion.SaveObject(cliente);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackTransaccion();
			flag = false;
		}
		conexion.cerrarSession();
		return flag;
	}

	@Override
	public boolean ModifyClient(Clientes cliente) {
		conexion.abrirConexion();
		boolean flag = true;
		try {
			conexion.InitTransaction();
			conexion.UpdateObject(cliente);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackTransaccion();
			flag = false;
		}
		conexion.cerrarSession();
		return flag;
	}

	@Override
	public ArrayList<Clientes> GetClients() {
		conexion.abrirConexion();
		ArrayList<Clientes> lista = (ArrayList<Clientes>)conexion.getSession().createQuery("FROM Clientes").list();
		conexion.cerrarSession();
		return lista;
	}

	@Override
	public Clientes GetClientByID(int id) {
		conexion.abrirConexion();
		Clientes client = (Clientes)conexion.getSession().createQuery("FROM Clientes where ID_Cliente = '" + id + "'").uniqueResult();
		conexion.cerrarSession();
		return client;
	}

	@Override
	public boolean doesClientExist(int dni, String email) {
		conexion.abrirConexion();
		String query = "FROM Clientes c where c.Dni = '" + dni + "' or c.Email = '" + email + "'";
		ArrayList<Clientes> lista = (ArrayList<Clientes>)conexion.getSession().createQuery(query).list();
		conexion.cerrarSession();
		if(lista.size() == 0)
			return false;
		return true;
	}

	@Override
	public boolean deleteClient(Clientes cliente) {
		conexion.abrirConexion();
		boolean flag = true;
		try {
			conexion.InitTransaction();
			conexion.EraseObject(cliente);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackTransaccion();
			flag = false;
		}
		conexion.cerrarSession();
		return flag;
	}

}
