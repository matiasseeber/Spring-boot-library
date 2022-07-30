package root.bussinesImp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bussines.NegNacionalidad;
import bussines.NegUsuarios;
import root.daoImpl.DaoNacionalidadImpl;
import root.daoImpl.DaoUsuariosImpl;
import root.entities.Nacionalidad;
import root.entities.Usuarios;

@Service("NegNacionalidadImpl")
public class NegNacionalidadImpl implements NegNacionalidad{

	
	@Autowired
	private DaoNacionalidadImpl daoNacionalidadImpl;

	@Override
	public boolean addNationality(Nacionalidad nacionalidad) {
		return daoNacionalidadImpl.addNationality(nacionalidad);
	}

	@Override
	public ArrayList<Nacionalidad> getNationalities() {
		return daoNacionalidadImpl.getNationalities();
	}
}
