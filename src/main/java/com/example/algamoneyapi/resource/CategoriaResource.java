package com.example.algamoneyapi.resource;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.algamoneyapi.model.Categoria;
import com.example.algamoneyapi.repository.CategoriaRepository;

/**
 *
 * @author vitor
 *
 * created on 2018-03-08
 */
@RestController
@RequestMapping("/categoria")
public class CategoriaResource {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public ResponseEntity<?> listar(HttpServletResponse response){

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUri();
        response.setHeader("Location", uri.toASCIIString());

        return ResponseEntity.ok(categoriaRepository.findAll());

    }

    @PostMapping
    public ResponseEntity<Categoria> criar(@RequestBody Categoria categoria, HttpServletResponse response) {
        Categoria categoriaSalva = categoriaRepository.save(categoria);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}").
                buildAndExpand(categoriaSalva.getCodigo()).toUri();

        return ResponseEntity.created(uri).body(categoriaSalva);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> buscarPeloCodigo(@PathVariable Long codigo, HttpServletResponse response){
        Categoria categoria = categoriaRepository.findOne(codigo);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUri();

        response.setHeader("Location", uri.toASCIIString());

        return categoria==null ? ResponseEntity.notFound().build() :
            ResponseEntity.ok(categoria);
    }

}
