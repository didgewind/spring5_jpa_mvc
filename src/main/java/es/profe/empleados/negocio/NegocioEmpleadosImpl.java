package es.profe.empleados.negocio;



import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import es.profe.empleados.daos.DAOEmpleados;
import es.profe.empleados.model.Empleado;

@Service("negocioEmpleados")
@Transactional
public class NegocioEmpleadosImpl implements NegocioEmpleados {

	@Resource(name="daoJpa")
	private DAOEmpleados dao;
	
	public NegocioEmpleadosImpl() {
		// TODO Auto-generated constructor stub
	}

	public void setDao(DAOEmpleados dao) {
		this.dao = dao;
	}

	/* (non-Javadoc)
	 * @see profe.empleados.negocio.NegocioEmpleados#getEmpleados()
	 */
	@Override
	public List<Empleado> getEmpleados() {
		return dao.getEmpleados();
	}


	/* (non-Javadoc)
	 * @see profe.empleados.negocio.NegocioEmpleados#insertaEmpleado(profe.empleados.model.Empleado)
	 */
	@Override
	public boolean insertaEmpleado(Empleado emp) {
		System.out.println("Insertando el empleado " + emp);
		return dao.insertaEmpleado(emp);
	}

	/* (non-Javadoc)
	 * @see profe.empleados.negocio.NegocioEmpleados#eliminaEmpleado(java.lang.String)
	 */
	public boolean eliminaEmpleado(String cif) {
		return dao.eliminaEmpleado(cif);
	}

	/* (non-Javadoc)
	 * @see profe.empleados.negocio.NegocioEmpleados#modificaEmpleado(profe.empleados.model.Empleado)
	 */
	@Override
	public boolean modificaEmpleado(Empleado emp) {
		return dao.modificaEmpleado(emp);
	}

	/* (non-Javadoc)
	 * @see profe.empleados.negocio.NegocioEmpleados#getEmpleado(java.lang.String)
	 */
	@Override
	public Empleado getEmpleado(String cif) {
		return dao.getEmpleado(cif);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public boolean insertaEmpleados(Collection<Empleado> emps) {
		for (Empleado emp : emps) {
				dao.insertaEmpleado(emp);
		}
		return true;
	}
	
}
