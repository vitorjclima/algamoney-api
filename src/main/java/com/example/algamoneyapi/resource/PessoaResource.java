package com.example.algamoneyapi.resource;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.algamoneyapi.model.Pessoa;
import com.example.algamoneyapi.repository.PessoaRepository;

/**
 * @author vitor
 *
 *         created on 2018-03-25
 */
@RestController
@RequestMapping("/pessoa")
public class PessoaResource {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public ResponseEntity<?> listar(HttpServletResponse response) {

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUri();
        response.setHeader("Location", uri.toASCIIString());

        return ResponseEntity.ok(pessoaRepository.findAll());

    }

    @PostMapping
    public ResponseEntity<Pessoa> criar(@RequestBody @Valid Pessoa pessoa, HttpServletResponse response) {
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
                .buildAndExpand(pessoaSalva.getCodigo()).toUri();

        return ResponseEntity.created(uri).body(pessoaSalva);
    }

}
