package root.dao;

import root.entities.Usuarios;

public interface DaoUsuarios {
	public boolean addUser(Usuarios usuario);
	public Usuarios obtainUserByPasswordAndEmail(String email, String password);
	public boolean doesUserExists(String email, String password);
}
