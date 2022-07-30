package root.bussinesImp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bussines.NegGenero;
import root.daoImpl.DaoGeneroImpl;
import root.entities.Genero;

@Service("NegGeneroImpl")
public class NegGeneroImpl implements NegGenero{

	@Autowired
	private DaoGeneroImpl daoGeneroImpl;
	
	@Override
	public boolean addGenre(Genero genero) {
		return daoGeneroImpl.addGenre(genero);
	}

	@Override
	public ArrayList<Genero> getAllGenres() {
		return daoGeneroImpl.getAllGenres();
	}

}
