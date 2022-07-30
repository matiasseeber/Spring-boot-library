package root.bussinesImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bussines.NegUsuarios;
import root.daoImpl.DaoUsuariosImpl;
import root.entities.Usuarios;

@Service("NegUsuariosImpl")
public class NegUsuariosImpl implements NegUsuarios{

	
	@Autowired
	private DaoUsuariosImpl daoUsuarios;
	
	@Override
	public boolean addUser(Usuarios usuario) {
		return daoUsuarios.addUser(usuario);
	}

	@Override
	public Usuarios obtainUserByPasswordAndEmail(String email, String password) {
		return daoUsuarios.obtainUserByPasswordAndEmail(email, password);
	}

	@Override
	public boolean doesUserExists(String email, String password) {
		return daoUsuarios.doesUserExists(email, password);
	}
}
