package root.dao;

import java.util.ArrayList;

import root.entities.Clientes;

public interface DaoClientes {
	public boolean AddClient(Clientes cliente);
	public boolean ModifyClient(Clientes cliente);
	public boolean doesClientExist(int dni, String email);
	public ArrayList<Clientes> GetClients();
	public Clientes GetClientByID(int id);
	public boolean deleteClient(Clientes cliente);
}
