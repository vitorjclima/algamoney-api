package com.example.algamoneyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.algamoneyapi.model.Pessoa;

/**
 * @author vitor
 *
 * created on 2018-03-25
 */
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
