package bussines;

import java.util.ArrayList;

import root.entities.Clientes;

public interface NegClientes {
	public boolean AddClient(Clientes cliente);
	public boolean ModifyClient(Clientes cliente);
	public ArrayList<Clientes> GetClients();
	public boolean doesClientExist(int dni, String email);
	public boolean deleteClient(Clientes cliente);
	public Clientes GetClientByID(int id);
}
