package root.bussinesImp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bussines.NegAutor;
import root.daoImpl.DaoAutorImpl;
import root.entities.Autor;

@Service("NegAutorImpl")
public class NegAutorImpl implements NegAutor{

	@Autowired
	private DaoAutorImpl DaoAutorImpl;
	
	@Override
	public boolean addWritter(Autor autor) {
		return DaoAutorImpl.addWritter(autor);
	}

	@Override
	public ArrayList<Autor> getAllWriters() {
		return DaoAutorImpl.getAllWriters();
	}
}
