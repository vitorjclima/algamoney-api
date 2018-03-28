package com.example.algamoneyapi.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author vitor
 *
 * created on 2018-03-20
 */
class CategoriaTest {

    Categoria categoria = new Categoria();
    /**
     * Test method for {@link com.example.algamoneyapi.model.Categoria#hashCode()}.
     */
    @Test
    final void testHashCode() {
        Long codigo = 10l;
        categoria.setCodigo(codigo);
        assertEquals(41l, categoria.hashCode());

        categoria.setCodigo(null);
        assertEquals(31l, categoria.hashCode());
    }

    /**
     * Test method for {@link com.example.algamoneyapi.model.Categoria#getCodigo()}.
     * Test method for {@link com.example.algamoneyapi.model.Categoria#setCodigo(java.lang.Long)}.
     */
    @Test
    final void testCodigo() {
        Long codigo = 10l;
        categoria.setCodigo(codigo);
        assertEquals(codigo, categoria.getCodigo());
    }

    /**
     * Test method for {@link com.example.algamoneyapi.model.Categoria#getNome()}.
     * Test method for {@link com.example.algamoneyapi.model.Categoria#setNome(java.lang.String)}.
     */
    @Test
    final void testNome() {
        String nome = "Alimentacao";
        categoria.setNome(nome);
        assertEquals(nome, categoria.getNome());
    }

    /**
     * Test method for {@link com.example.algamoneyapi.model.Categoria#equals(java.lang.Object)}.
     */
    @Test
    final void testEqualsObject() {
    }

}
