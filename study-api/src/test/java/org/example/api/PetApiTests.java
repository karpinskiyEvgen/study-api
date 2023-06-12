package org.example.api;

import models.Category;
import models.Pet;
import models.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PetApiTests {
    private static final PetApi API = new PetApi();

    @Test
    void When_Get_PetByUnknownId_Then_ReturnNotFound(){
        API.getPet(100500)
                .then()
                .statusCode(404);
    }

    @Test
    void When_Get_PetById_Then_Return200() {
        API.getPet(1)
                .then()
                .statusCode(200);
    }

    @Test
    void When_Get_PetByStatus_Then_Return200() {
        API.getPetByStatus("sold")
                .then()
                .statusCode(200);
    }
    @Test
    void When_Post_Pet_Then_Return200() {
        Category category = new Category("dogs", 1);

        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add("some url");
            Tag tag = new Tag(3, "dog");
            ArrayList<Tag> tagList = new ArrayList<>();
            tagList.add(tag);

            Pet pet = new Pet(category, "Sharik", photoUrls, tagList, "available");

            API.postPet(pet)
                    .then()
                    .statusCode(200);
        }
    }