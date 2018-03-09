package com.example.algamoneyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.algamoneyapi.model.Categoria;

/**
 * @author vitor
 *
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
