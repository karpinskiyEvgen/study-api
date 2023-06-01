package org.example.api;

import org.junit.jupiter.api.Test;

public class PetApiTests {
    private static final PetApi API = new PetApi();

    @Test
    void When_Get_PetByUnknownId_Then_ReturnNotFound(){
        API.getPet(100500)
                .then()
                .statusCode(404);
    }

}
