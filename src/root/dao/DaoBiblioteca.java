package root.dao;

import java.util.ArrayList;

import root.entities.Biblioteca;

public interface DaoBiblioteca {
	public boolean addBiblioteca(Biblioteca biblioteca);
	public ArrayList<Biblioteca> getBibliotecas();
	public ArrayList<Biblioteca> getAllAvailableBibliotecas();
	public boolean deleteBiblioteca(Biblioteca biblioteca);
	public Biblioteca getBibliotecaById(int id);
	public boolean modifyBiblioteca(Biblioteca biblioteca);
}
