package com.example.algamoneyapi.resource;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import com.jayway.restassured.http.ContentType;

/**
 * @author vitor
 *
 * created on 2018-03-27
 */
class PessoaResourceTest {

    /**
     * Test method for {@link com.example.algamoneyapi.resource.PessoaResource#listar(javax.servlet.http.HttpServletResponse)}.
     */
    @Test
    void testListar() {
        get("/pessoa").
        then().
        statusCode(200).
        and().
        contentType(ContentType.JSON);
    }

    /**
     * Test method for {@link
    void com.example.algamoneyapi.resource.PessoaResource#criar(com.example.algamoneyapi.model.Pessoa, javax.servlet.http.HttpServletResponse)}.
     */
    @Test
    void testCriar() {
        given().
        contentType(ContentType.JSON).
        body("{\"nome\": \"Andre\", \"ativo\": true}").
        post("pessoa").
        then().
        statusCode(201);
    }

}
