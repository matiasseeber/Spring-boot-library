package root.dao;

import java.util.ArrayList;

import root.entities.Nacionalidad;

public interface DaoNacionalidad {
	public boolean addNationality(Nacionalidad nacionalidad);
	public ArrayList<Nacionalidad> getNationalities();
}
