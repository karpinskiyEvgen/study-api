package org.example.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Category;
import models.Pet;
import models.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

public class PetApiTests {
    private static final PetApi API = new PetApi();

    @Test
    void When_Get_PetByUnknownId_Then_ReturnNotFound() {
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
    void When_Post_Pet_Then_Return200() throws IOException {
        Category category = new Category("dogs", 1);

        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add("some url");
        Tag tag = new Tag(3, "dog");
        ArrayList<Tag> tagList = new ArrayList<>();
        tagList.add(tag);

        Pet pet = new Pet(category, "Sharik", photoUrls, tagList, "available");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(pet);

        API.postPet(json)
                .then()
                .statusCode(200);
    }


    @Test
    void When_Put_Pet_Then_Return200() throws JsonProcessingException {
        Category category = new Category("cats", 2);

        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add("photo url");
        Tag tag = new Tag(1, "cat");
        ArrayList<Tag> tagList = new ArrayList<>();
        tagList.add(tag);

        Pet pet = new Pet(category, "Myrzik", photoUrls, tagList, "sold");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(pet);

        API.putPet(json)
                .then()
                .statusCode(200);
    }
}