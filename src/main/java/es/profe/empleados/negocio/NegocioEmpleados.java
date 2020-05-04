package es.profe.empleados.negocio;


import java.util.Collection;
import java.util.List;

import es.profe.empleados.model.Empleado;

public interface NegocioEmpleados {

	/* (non-Javadoc)
	 * @see profe.empleados.negocio.NegocioEmpleados#getEmpleados()
	 */
	public abstract List<Empleado> getEmpleados();


	public abstract boolean insertaEmpleado(Empleado emp);

	/**
	 * Inserta ua lista de empleados. Para probar los atributos transaccionales
	 * @param emps
	 * @return
	 */
	public abstract boolean insertaEmpleados(Collection<Empleado> emps);

	public abstract boolean eliminaEmpleado(String cif);


	public abstract boolean modificaEmpleado(Empleado emp);


	public abstract Empleado getEmpleado(String cif);


}