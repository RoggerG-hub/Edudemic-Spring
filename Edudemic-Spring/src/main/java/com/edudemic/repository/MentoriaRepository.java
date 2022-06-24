package com.edudemic.repository;

import com.edudemic.entities.Mentoria;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MentoriaRepository extends JpaRepository<Mentoria, Long> {
	@Query("SELECT m FROM Mentoria m WHERE m.id=?1")
	List<Mentoria> listaMen(Long id);
	
	@Query("SELECT m FROM Mentoria m WHERE m.id=?1")
	Mentoria objetoM(Long id);
}
