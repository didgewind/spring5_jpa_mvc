package es.profe.empleados.daos;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.profe.empleados.model.Empleado;

/**
 * Implementaci�n de DAOEmpleados que trabaja en memoria
 * @author Administrador
 *
 */
public class DAOEmpFake implements DAOEmpleados {

	private Map<String, Empleado> mpEmpleados = 
			new HashMap<String, Empleado>();
	
	public DAOEmpFake() {
		mpEmpleados.put("2389471290H", new Empleado("2389471290H", "Luis", "Pascual", 32));
		mpEmpleados.put("3045893409Y", new Empleado("3045893409Y", "Bego�a", "Garc�a", 1));
		mpEmpleados.put("0938573904T", new Empleado("0938573904T", "Javier", "L�pez", 1));
		mpEmpleados.put("9234873942U", new Empleado("9234873942U", "Antonio", "Boniato", 11));
	}
	
	/*
	 * (non-Javadoc)
	 * @see profe.daos.DAOEmpleados#getEmpleados()
	 */
	@Override
	public List<Empleado> getEmpleados() {
		return new ArrayList<Empleado>
				(mpEmpleados.values());
	}

	@Override
	public boolean insertaEmpleado(Empleado emp) {

		// Comprobar si ya existe el empleado emp
		Empleado eAux = mpEmpleados.get(emp.getCif());
		// Si no existe
		if (eAux == null) {
			// inserto emp
			mpEmpleados.put(emp.getCif(), emp);
			// devuelvo true
			return true;
		} else { // Si no
			// devuelvo false
			return false;
		}
	}

	@Override
	public boolean eliminaEmpleado(String cif) {
		Object o = mpEmpleados.remove(cif);
		if (o!=null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean modificaEmpleado(Empleado emp) {
		// Comprobar si ya existe el empleado emp
		Empleado eAux = mpEmpleados.get(emp.getCif());
		// Si existe
		if (eAux != null) {
			// lo modifico
			mpEmpleados.put(emp.getCif(), emp);
			// devuelvo true
			return true;
		} else { // Si no
			// devuelvo false
			return false;
		}
	}

	@Override
	public Empleado getEmpleado(String cif) {
		// TODO Auto-generated method stub
		return mpEmpleados.get(cif);
	}


	public void sayHello() {
		
	}


}
