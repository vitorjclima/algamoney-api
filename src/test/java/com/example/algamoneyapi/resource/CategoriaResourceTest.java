package com.example.algamoneyapi.resource;

import static com.jayway.restassured.RestAssured.baseURI;
import static com.jayway.restassured.RestAssured.get;

import org.junit.jupiter.api.Test;

import com.jayway.restassured.http.ContentType;

/**
 * @author vitor
 *
 * created on 2018-03-08
 */
class CategoriaResourceTest {

    public CategoriaResourceTest() {
        baseURI = "http://localhost:8080";
    }

    @Test
    void testListar() {
        get("/categoria").
        then().
        statusCode(200).
        and().
        contentType(ContentType.JSON);
    }
}
