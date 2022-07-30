package root.dao;

import java.util.ArrayList;

import root.entities.Genero;

public interface DaoGeneros {
	public boolean addGenre(Genero genero);
	public ArrayList<Genero> getAllGenres();
}
