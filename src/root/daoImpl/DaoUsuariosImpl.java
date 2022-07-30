package root.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import root.dao.DaoUsuarios;
import root.entities.Usuarios;

@Repository("DaoUsuariosImpl")
public class DaoUsuariosImpl implements DaoUsuarios{

	@Autowired
	private Conexion conexion;
	
	public DaoUsuariosImpl() {
	}
	
	@Override
	public boolean addUser(Usuarios usuario) {
		conexion.abrirConexion();
		boolean flag = true;
		try {
			conexion.InitTransaction();
			conexion.SaveObject(usuario);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackTransaccion();
			flag = false;
		}
		conexion.cerrarSession();
		return flag;
	}
	
	@Override
	public Usuarios obtainUserByPasswordAndEmail(String email, String password) {
		conexion.abrirConexion();
		String query = "FROM Usuarios users WHERE users.email = '"+ email +"' OR users.username = '"+ email +"' AND users.password = '"+ password +"'";
		Usuarios dbUser = (Usuarios)conexion.getSession().createQuery(query).uniqueResult();
		conexion.cerrarSession();
		return dbUser;
	}

	@Override
	public boolean doesUserExists(String email, String password) {
		conexion.abrirConexion();
		String query = "FROM Usuarios users WHERE users.email = '"+ email +"' OR users.username = '"+ email +"' AND users.password = '"+ password +"'";
		Usuarios dbUser = (Usuarios)conexion.getSession().createQuery(query).uniqueResult();
		conexion.cerrarSession();
		if(dbUser == null)
			return false;
		return true;
	}
}
