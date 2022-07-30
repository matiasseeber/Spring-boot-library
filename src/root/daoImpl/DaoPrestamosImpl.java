package root.daoImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import root.dao.DaoPrestamos;
import root.entities.Clientes;
import root.entities.Prestamos;

@Repository("DaoPrestamosImpl")
public class DaoPrestamosImpl implements DaoPrestamos{

	@Autowired
	private Conexion conexion;
	
	@Override
	public boolean addLoan(Prestamos prestamo) {
		System.out.println("addLoan");
		conexion.abrirConexion();
		boolean flag = true;
		try {
			conexion.InitTransaction();
			conexion.SaveObject(prestamo);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackTransaccion();
			flag = false;
		}
		conexion.cerrarSession();
		return flag;
	}

	@Override
	public ArrayList<Prestamos> getLoans() {
		conexion.abrirConexion();
		ArrayList<Prestamos> lista = (ArrayList<Prestamos>)conexion.getSession().createQuery("FROM Prestamos").list();
		conexion.cerrarSession();
		return lista;
	}

	@Override
	public boolean modifyLoan(Prestamos prestamo) {
		System.out.println("modifyLoan");
		conexion.abrirConexion();
		boolean flag = true;
		try {
			conexion.InitTransaction();
			conexion.UpdateObject(prestamo);
			conexion.CommitTransaccion();
		} catch (Exception e) {
			conexion.RollbackTransaccion();
			flag = false;
		}
		conexion.cerrarSession();
		return flag;
	}

	@Override
	public Prestamos getLoanByID(int id) {
		System.out.println("getLoanByID");
		conexion.abrirConexion();
		Prestamos prestamo = (Prestamos)conexion.getSession().createQuery("FROM Prestamos p where p.ID_Prestamo = '" + id + "'").uniqueResult();
		conexion.cerrarSession();
		return prestamo;
	}
	
	
}
