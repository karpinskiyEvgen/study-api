package org.example.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PetApiTests {
    private static final PetApi API = new PetApi();

    @Test
    void When_Get_PetByUnknownId_Then_ReturnNotFound(){
        API.getPet(100500)
                .then()
                .statusCode(404);
    }

    @Test
    void getPetById() {
        API.getPet(1)
                .then()
                .statusCode(200)
                .extract().response().body().print();
    }

    @Test
    void findPetByStatus() {
        API.getPetByStatus("sold")
                .then()
                .statusCode(200)
                .extract().response().body().print();
    }

    @Test
    void postPet() {
        API.postPet()
                .then()
                .statusCode(200)
                .extract().response().body().print();
    }

    @Test
    void updateFieldsForPet() {
        API.putPet()
                .then()
                .statusCode(200)
                .extract().response().body().print();
    }
}
