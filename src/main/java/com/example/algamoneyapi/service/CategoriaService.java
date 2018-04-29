package com.example.algamoneyapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.algamoneyapi.model.Categoria;
import com.example.algamoneyapi.repository.CategoriaRepository;

/**
 * @author Vitor Lima
 *
 * created on 2018-04-28
 */
@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public Categoria atualizar(Long codigo, Categoria categoria) {
        Categoria categoriaSalva = categoriaRepository.save(categoria);
        if (categoriaSalva == null) {
            throw new EmptyResultDataAccessException(1);
        }
        BeanUtils.copyProperties(categoria, categoriaSalva, "codigo");
        return categoriaRepository.save(categoriaSalva);
    }
}
