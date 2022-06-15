package com.edudemic.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edudemic.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{
	
	@Query("SELECT c FROM Curso c  WHERE c.nombre=?1")
	List<Curso> buscarCursoByNombre(String nombre);
}
	