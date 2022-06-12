package com.edudemic.entities;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="retos")
public class Reto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Date fechaLimite;
	private double nota;
	@ManyToOne
	@JoinColumn(name = "mentoria_id", nullable = false)
	private Mentoria mentoria;
	public Reto() {
	}
	public Reto(Long id, String nombre,Date fechaLimite,double nota) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaLimite=fechaLimite;
		this.nota = nota;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaLimite() {
		return fechaLimite;
	}
	public void setFechaLimite(Date fechaLimite) {
		this.fechaLimite = fechaLimite;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public Mentoria getMentoria() {
		return mentoria;
	}
	public void setMentoria(Mentoria mentoria) {
		this.mentoria = mentoria;
	}
	
}
