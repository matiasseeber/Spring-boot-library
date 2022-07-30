package root.bussinesImp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bussines.NegClientes;
import root.daoImpl.DaoClientesImpl;
import root.entities.Clientes;

@Service("NegClientesImpl")
public class NegClientesImpl implements NegClientes{

	@Autowired
	private DaoClientesImpl daoClientesImpl;
	
	@Override
	public boolean AddClient(Clientes cliente) {
		return daoClientesImpl.AddClient(cliente);
	}

	@Override
	public boolean ModifyClient(Clientes cliente) {
		return daoClientesImpl.ModifyClient(cliente);
	}

	@Override
	public ArrayList<Clientes> GetClients() {
		return daoClientesImpl.GetClients();
	}

	@Override
	public boolean doesClientExist(int dni, String email) {
		return daoClientesImpl.doesClientExist(dni, email);
	}

	@Override
	public boolean deleteClient(Clientes cliente) {
		return daoClientesImpl.deleteClient(cliente);
	}

	@Override
	public Clientes GetClientByID(int id) {
		return daoClientesImpl.GetClientByID(id);
	}
}
