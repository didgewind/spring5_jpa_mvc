package es.profe.empleados.daos;
/**
 * 
 */


import java.util.List;

import es.profe.empleados.model.Empleado;

/**
 * @author Administrador
 *
 * Interfaz para acceder a los empleados
 */
public interface DAOEmpleados {

	/**
	 * Devuelve el conjunto de empleados
	 * @return
	 */
	public abstract List<Empleado> getEmpleados();
	
	/**
	 * Inserta el empleado emp. Devuelve true si todo ha sido correcto, y
	 * false en caso contrario. En caso de que el empleado exista, se deja la decisión de sustituirlo
	 * o no a la clase de implementación
	 * @param emp
	 * @return
	 */
	public abstract boolean insertaEmpleado(Empleado emp);
	
	public abstract boolean eliminaEmpleado(String cif);
	
	public abstract boolean modificaEmpleado(Empleado emp);
	
	public abstract Empleado getEmpleado(String cif);

}
