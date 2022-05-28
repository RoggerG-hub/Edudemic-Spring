package com.edudemic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edudemic.entities.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long>{

}
