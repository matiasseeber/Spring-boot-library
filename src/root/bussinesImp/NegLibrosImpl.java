package root.bussinesImp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bussines.NegLibros;
import root.daoImpl.DaoLibrosImpl;
import root.entities.Libro;

@Service("NegLibrosImpl")
public class NegLibrosImpl implements NegLibros{

	@Autowired
	DaoLibrosImpl daoLibrosImpl;
	
	@Override
	public boolean addBook(Libro libro) {
		return daoLibrosImpl.addBook(libro);
	}

	@Override
	public ArrayList<Libro> getBooks() {
		return daoLibrosImpl.getBooks();
	}

	@Override
	public boolean modifyBook(Libro libro) {
		return daoLibrosImpl.modifyBook(libro);
	}

}
