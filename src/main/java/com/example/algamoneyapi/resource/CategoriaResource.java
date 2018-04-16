package com.example.algamoneyapi.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.algamoneyapi.event.CreatedResourceEvent;
import com.example.algamoneyapi.model.Categoria;
import com.example.algamoneyapi.model.Pessoa;
import com.example.algamoneyapi.repository.CategoriaRepository;

/**
 *
 * @author vitor
 *
 *         created on 2018-03-08
 */
@RestController
@RequestMapping("/categoria")
public class CategoriaResource {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public ResponseEntity<?> listar(HttpServletResponse response) {
        return ResponseEntity.status(HttpStatus.OK).
                body(categoriaRepository.findAll());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> buscarPeloCodigo(@PathVariable Long codigo, HttpServletResponse response) {
        Categoria categoria = categoriaRepository.findOne(codigo);
        return categoria == null ? ResponseEntity.notFound().build()
                : ResponseEntity.status(HttpStatus.OK).body(categoria);
    }

    @PostMapping
    public ResponseEntity<Categoria> criar(@RequestBody @Valid Categoria categoria, HttpServletResponse response) {
        Categoria categoriaSalva = categoriaRepository.save(categoria);
        publisher.publishEvent(new CreatedResourceEvent(this, response, categoriaSalva.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Pessoa> remover(@PathVariable Long codigo, HttpServletResponse response){
        categoriaRepository.delete(codigo);
        publisher.publishEvent(new CreatedResourceEvent(this, response, codigo));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
