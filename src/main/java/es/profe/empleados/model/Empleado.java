package es.profe.empleados.model;
/**
 * 
 */


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Las anotaciones en esta clase son para JPA
 *
 */
@Entity 
@Table(name = "empleados") 
public class Empleado implements Serializable, Comparable<Empleado> {

	@Id
	private String cif;
	@Column(name = "nombre") // Esta línea no haría falta porque el atributo coincide con el campo
	private String nombre;
	private String apellidos;
	private int edad;
	
	/**
	 * 
	 */
	public Empleado() {
		// TODO Auto-generated constructor stub
	}

	public Empleado(String cif, String nombre, String apellidos, int edad) {
		super();
		this.cif = cif;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cif == null) ? 0 : cif.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (cif == null) {
			if (other.cif != null)
				return false;
		} else if (!cif.equals(other.cif))
			return false;
		return true;
	}

	@Override
	public int compareTo(Empleado emp) {
		return cif.compareTo(emp.cif);

	}

	@Override
	public String toString() {
		return cif + "\t" + nombre + "\t\t" + apellidos + "\t\t" + edad;
	}

}
