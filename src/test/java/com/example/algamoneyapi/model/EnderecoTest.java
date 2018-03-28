package com.example.algamoneyapi.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author vitor
 *
 * created on 2018-03-20
 */
class EnderecoTest {

    Endereco endereco = new Endereco();

    /**
     * Test method for {@link com.example.algamoneyapi.model.Endereco#getLogradouro()}.
     * Test method for {@link com.example.algamoneyapi.model.Endereco#setLogradouro(java.lang.String)}.
     */
    @Test
    final void testLogradouro() {
        String logradouro = "Rua das Ostras";
        endereco.setLogradouro(logradouro);
        assertEquals(logradouro, endereco.getLogradouro());
    }

    /**
     * Test method for {@link com.example.algamoneyapi.model.Endereco#getNumero()}.
     * Test method for {@link com.example.algamoneyapi.model.Endereco#setNumero(java.lang.Integer)}.
     */
    @Test
    final void testGetNumero() {
        Integer numero = 10;
        endereco.setNumero(numero);
        assertEquals(numero, endereco.getNumero());
    }

    /**
     * Test method for {@link com.example.algamoneyapi.model.Endereco#getBairro()}.
     * Test method for {@link com.example.algamoneyapi.model.Endereco#setBairro(java.lang.String)}.
     */
    @Test
    final void testGetBairro() {
        String bairro = "Centro";
        endereco.setBairro(bairro);
        assertEquals(bairro, endereco.getBairro());
    }

    /**
     * Test method for {@link com.example.algamoneyapi.model.Endereco#getCidade()}.
     * Test method for {@link com.example.algamoneyapi.model.Endereco#setCidade(java.lang.String)}.
     */
    @Test
    final void testGetCidade() {
        String cidade = "Vancouver";
        endereco.setCidade(cidade);
        assertEquals(cidade, endereco.getCidade());
    }

    /**
     * Test method for {@link com.example.algamoneyapi.model.Endereco#getEstado()}.
     * Test method for {@link com.example.algamoneyapi.model.Endereco#setEstado(java.lang.String)}.
     */
    @Test
    final void testGetEstado() {
        String estado = "BC";
        endereco.setEstado(estado);
        assertEquals(estado, endereco.getEstado());
    }

    /**
     * Test method for {@link com.example.algamoneyapi.model.Endereco#getComplemento()}.
     * Test method for {@link com.example.algamoneyapi.model.Endereco#setComplemento(java.lang.String)}.
     */
    @Test
    final void testGetComplemento() {
        String complemento = "Apto 123";
        endereco.setComplemento(complemento);
        assertEquals(complemento, endereco.getComplemento());
    }

    /**
     * Test method for {@link com.example.algamoneyapi.model.Endereco#getCep()}.
     * Test method for {@link com.example.algamoneyapi.model.Endereco#setCep(java.lang.String)}.
     */
    @Test
    final void testGetCep() {
        String cep = "12600-000";
        endereco.setCep(cep);
        assertEquals(cep, endereco.getCep());
    }
}
