package com.example.algamoneyapi.resource;

import static com.jayway.restassured.RestAssured.baseURI;
import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.containsString;

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
    void test() {
        get("/categoria").
        then().
        statusCode(200).
        and().
        contentType(ContentType.JSON).
        and().
        body(containsString("Farmacia"));
    }
}
