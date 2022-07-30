package bussines;

import java.util.ArrayList;

import root.entities.Prestamos;

public interface NegPrestamos {
	public boolean addLoan(Prestamos prestamo);
	public ArrayList<Prestamos> getLoans();
	public boolean modifyLoan(Prestamos prestamo);
	public Prestamos getLoanByID(int id);
}
