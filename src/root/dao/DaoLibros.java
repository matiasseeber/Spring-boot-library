package root.dao;

import java.util.ArrayList;

import root.entities.Libro;

public interface DaoLibros {
	public boolean addBook(Libro libro);
	public ArrayList<Libro> getBooks();
	public boolean modifyBook(Libro libro);
}
