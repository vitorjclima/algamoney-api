package com.example.algamoneyapi.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author vitor
 *
 * created on 2018-03-19
 */
class PessoaTest {

    Pessoa pessoa = new Pessoa();

    @Test
    public void testCodigo() {
        Long codigo = 10l;
        pessoa.setCodigo(codigo);
        assertEquals(codigo, pessoa.getCodigo());
    }

    @Test
    public void testNome() {
        String nome = "Test";
        pessoa.setNome(nome);
        assertEquals(nome, pessoa.getNome());
    }

    @Test
    public void testAtivo() {
        pessoa.setAtivo(true);
        assertNotEquals(false, pessoa.getAtivo());
    }

    @Test
    public void testEndereco() {
        Endereco endereco = new Endereco();
        endereco.setEstado("SP");
        pessoa.setEndereco(endereco);
        assertEquals(endereco, pessoa.getEndereco());
    }

}
