package com.edudemic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edudemic.entities.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long>{
	@Query("SELECT count(e) FROM Estudiante e  WHERE e.dni=?1")
	int verificarExistenciaEstudiante(String dni);
	
	@Query("SELECT e FROM Estudiante e  WHERE e.dni=?1")
	List<Estudiante> buscarEstudiantes(String dni);
	
	@Query("SELECT e FROM Estudiante e  WHERE e.id=?1")
	Estudiante buscarEstudiantePorId(long id);
}
