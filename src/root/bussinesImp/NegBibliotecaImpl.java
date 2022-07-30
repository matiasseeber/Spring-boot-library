package root.bussinesImp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bussines.NegBiblioteca;
import root.daoImpl.DaoBibliotecaImpl;
import root.entities.Biblioteca;

@Service("NegBibliotecaImpl")
public class NegBibliotecaImpl implements NegBiblioteca{

	@Autowired
	DaoBibliotecaImpl daoBibliotecaImpl;
	
	@Override
	public boolean addBiblioteca(Biblioteca biblioteca) {
		return daoBibliotecaImpl.addBiblioteca(biblioteca);
	}

	@Override
	public ArrayList<Biblioteca> getBibliotecas() {
		return daoBibliotecaImpl.getBibliotecas();
	}

	@Override
	public boolean deleteBiblioteca(Biblioteca biblioteca) {
		return daoBibliotecaImpl.deleteBiblioteca(biblioteca);
	}

	@Override
	public Biblioteca getBibliotecaById(int id) {
		return daoBibliotecaImpl.getBibliotecaById(id);
	}

	@Override
	public ArrayList<Biblioteca> getAllAvailableBibliotecas() {
		return daoBibliotecaImpl.getAllAvailableBibliotecas();
	}

	@Override
	public boolean modifyBiblioteca(Biblioteca biblioteca) {
		return daoBibliotecaImpl.modifyBiblioteca(biblioteca);
	}

}
