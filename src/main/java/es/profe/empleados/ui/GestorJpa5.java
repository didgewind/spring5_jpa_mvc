package es.profe.empleados.ui;
/**
 * 
 */


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import es.profe.empleados.model.Empleado;
import es.profe.empleados.negocio.NegocioEmpleados;

/**
 * @author usuario1
 *
 */
@Component("gestor")
public class GestorJpa5 {
	
	@Autowired
	NegocioEmpleados negocio;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Además de beans.xml podríamos incluir otros ficheros de beans separados por comas 
		 * (i.e., new String[] {"daos.xml", "servicios.xml", "negocio.xml"});
		 */
		ApplicationContext context =
			    new ClassPathXmlApplicationContext(new String[] {"beans.xml"});
		GestorJpa5 gestor = (GestorJpa5) context.getBean("gestor");
		gestor.go();
	}

	public void go() {
		System.out.println("Comenzando proceso...");
		imprimeEmpleados();
		try {
			insertaEmpleado();
//			insertaEmpleados();
		} catch (Exception e) {
			e.printStackTrace();
		}
		imprimeEmpleados();
	}
	
	private void insertaEmpleado() {
		negocio.insertaEmpleado(new Empleado("23423432H", "Carlos", "Bacca", 27));
	}
	
	private void insertaEmpleados() {
		/*
		 * Borramos primero los empleados que queremos insertar, para partir de 0...
		 */
		negocio.eliminaEmpleado("03957234Y");
		negocio.eliminaEmpleado("57340934Z");
		negocio.eliminaEmpleado("21094387T");
		negocio.eliminaEmpleado("34534545U");
		List<Empleado> empsAInsertar = new ArrayList<Empleado>();
		empsAInsertar.add(new Empleado("03957234Y", "Manuel", "Pedraza", 70));
		empsAInsertar.add(new Empleado("57340934Z", "Inaru", "Escribano", 0));
		empsAInsertar.add(new Empleado("03957234Y", "J", "G", 40));
		empsAInsertar.add(new Empleado("34534545U", "Made", "Mata", 41));
		negocio.insertaEmpleados(empsAInsertar);
	}
	
	private void imprimeEmpleados() {
		List<Empleado> lEmpleados = negocio.getEmpleados();
		for (Empleado emp : lEmpleados) {
			System.out.println(emp);
		}
	}

	public void setNegocio(NegocioEmpleados negocio) {
		this.negocio = negocio;
	}
	
	
}
