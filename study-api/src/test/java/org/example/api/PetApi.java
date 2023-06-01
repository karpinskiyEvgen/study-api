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
}
