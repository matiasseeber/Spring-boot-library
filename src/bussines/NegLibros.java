package bussines;

import java.util.ArrayList;

import root.entities.Libro;

public interface NegLibros {
	public boolean addBook(Libro libro);
	public ArrayList<Libro> getBooks();
	public boolean modifyBook(Libro libro);
}
