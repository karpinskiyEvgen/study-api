package org.example.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.example.api.Constants.BASE_URL;

public class PetApi {
    public Response getPet(int id) {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get(BASE_URL + "/v2/pet/{id}", id);
    }


    public Response getPetByStatus(String status) {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get(BASE_URL + "/v2/pet/findByStatus?status={status}", status);
    }

    public Response postPet(String jsonString) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(jsonString)
                .when()
                .post(BASE_URL + "/v2/pet");
    }

    public Response putPet(String jsonString) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(jsonString)
                .when()
                .put(BASE_URL + "/v2/pet");
    }
}
