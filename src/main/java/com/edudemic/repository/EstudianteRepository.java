package com.edudemic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edudemic.entities.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long>{

}
