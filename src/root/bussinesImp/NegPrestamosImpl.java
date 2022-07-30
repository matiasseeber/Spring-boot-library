package root.bussinesImp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bussines.NegPrestamos;
import root.daoImpl.DaoPrestamosImpl;
import root.entities.Prestamos;

@Service("NegPrestamosImpl")
public class NegPrestamosImpl implements NegPrestamos{

	@Autowired
	DaoPrestamosImpl DaoPrestamosImpl;
	
	@Override
	public boolean addLoan(Prestamos prestamo) {
		return DaoPrestamosImpl.addLoan(prestamo);
	}

	@Override
	public ArrayList<Prestamos> getLoans() {
		return DaoPrestamosImpl.getLoans();
	}

	@Override
	public boolean modifyLoan(Prestamos prestamo) {
		return DaoPrestamosImpl.modifyLoan(prestamo);
	}

	@Override
	public Prestamos getLoanByID(int id) {
		return DaoPrestamosImpl.getLoanByID(id);
	}
}
