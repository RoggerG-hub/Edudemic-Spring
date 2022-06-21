package com.edudemic.entities;



import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name="estudiantes")
@PrimaryKeyJoinColumn(referencedColumnName = "usu_codigo")
public class Estudiante extends Usuario{
	String grado;

	public Estudiante(String grado) {
		super();
		this.grado = grado;
	}

	public Estudiante() {
		super();
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}
	
}

