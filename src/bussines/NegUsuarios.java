package bussines;

import root.entities.*;

public interface NegUsuarios {
	public boolean addUser(Usuarios usuario);
	public Usuarios obtainUserByPasswordAndEmail(String email, String password);
	public boolean doesUserExists(String email, String password);
}
