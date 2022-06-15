package com.edudemic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edudemic.entities.Calificacion;




public interface CalificacionRepository extends JpaRepository<Calificacion, Long> {
	
	
	
	
}