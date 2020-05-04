package es.profe.empleados.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import es.profe.empleados.model.Empleado;

@Repository("daoJpa")
public class DAOEmpJPA implements DAOEmpleados {

	@PersistenceContext
    private EntityManager em;
    
	@Override
	public List<Empleado> getEmpleados() {
		return em.createQuery("select e from Empleado e").getResultList();
	}

	@Override
	public boolean insertaEmpleado(Empleado emp) {
		em.persist(emp);
		return true;
	}

	@Override
	public boolean eliminaEmpleado(String cif) {
		javax.persistence.Query query = em.createQuery("DELETE From Empleado e WHERE e.cif =:cif");
	    query.setParameter("cif", cif);
	    query.executeUpdate();
	    return true;
	}

	@Override
	public boolean modificaEmpleado(Empleado emp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Empleado getEmpleado(String cif) {
		// TODO Auto-generated method stub
		return null;
	}


	/* Ésta operación no se encuentra en el dao, pero sí en el de empleados hibernate */
	public void eliminaAllEmpleados() {
		em.createQuery("delete Empleado").executeUpdate();
	}


}
