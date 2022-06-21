package com.edudemic.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="estudiantes")
public class Estudiante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Debe ingresar nombre del estudiante*")
	@Column(name = "nombres", nullable = false, length = 45)
	private String nombres;
	
	@NotEmpty(message = "Debe ingresar apellido del estudiante*")
	@Column(name = "apellidos", nullable = false, length = 45)
	private String apellidos;
	
	@Max(18)
	@Min(6)
	@Column(name = "edad", nullable = false)
	private int edad;
	
	@Size(min = 9, max = 9, message = "El numero de teléfono debe tener 9 digitos")
	@NotEmpty(message = "Debe ingresar su telefono*")
	@Column(name = "telefono", nullable = false, length = 8)
	private String telefono;
	
	@NotEmpty(message = "Debe ingresar correo del estudiante*")
	@Column(name = "correo", nullable = false, length = 45)
	private String correo;
	
	@NotEmpty(message = "Debe ingresar contraseña del estudiante*")
	@Column(name = "contraseña", nullable = false, length = 45)
	private String contraseña;
	
	@Past(message = "Fecha de nacimiento no correcta")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_nacimiento", nullable = false)
	private Date fecha;
	
	@Size(min = 8, max = 8, message = "El numero de DNI debe tener 8 digitos")
	@NotEmpty(message = "Debe ingresar su DNI*")
	@Column(name = "dni", nullable = false, length = 8)
	private String dni;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
}
