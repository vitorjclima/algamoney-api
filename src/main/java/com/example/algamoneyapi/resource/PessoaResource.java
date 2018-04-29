package com.example.algamoneyapi.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.algamoneyapi.event.CreatedResourceEvent;
import com.example.algamoneyapi.model.Pessoa;
import com.example.algamoneyapi.repository.PessoaRepository;
import com.example.algamoneyapi.service.PessoaService;

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

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public ResponseEntity<?> listar(HttpServletResponse response) {
        return ResponseEntity.status(HttpStatus.OK).
                body(pessoaRepository.findAll());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> buscarPeloCodigo(@PathVariable Long codigo, HttpServletResponse response) {
        Pessoa pessoa = pessoaRepository.findOne(codigo);
        return pessoa == null ? ResponseEntity.notFound().build()
                : ResponseEntity.status(HttpStatus.OK).body(pessoa);
    }

    @PostMapping
    public ResponseEntity<Pessoa> criar(@RequestBody @Valid Pessoa pessoa, HttpServletResponse response) {
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);
        publisher.publishEvent(new CreatedResourceEvent(this, response, pessoaSalva.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Pessoa> remover(@PathVariable Long codigo, HttpServletResponse response){
        pessoaRepository.delete(codigo);
        publisher.publishEvent(new CreatedResourceEvent(this, response, codigo));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Pessoa> atualizar(@PathVariable Long codigo, @RequestBody @Valid Pessoa pessoa){
        Pessoa pessoaSalva = pessoaService.atualizar(codigo, pessoa);
        return ResponseEntity.ok(pessoaSalva);
    }

}
