package root.dao;

import java.util.ArrayList;

import root.entities.Autor;

public interface DaoAutor {
	public boolean addWritter(Autor autor);
	public ArrayList<Autor> getAllWriters();
}
