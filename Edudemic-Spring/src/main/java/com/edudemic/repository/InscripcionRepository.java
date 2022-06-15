package com.edudemic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edudemic.entities.Inscripcion;
import com.edudemic.entities.Libro;


public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
	@Query("SELECT i FROM Inscripcion i WHERE i.estudiante.id=?1")
	List<Inscripcion> listaIns(Long id);
	
}
