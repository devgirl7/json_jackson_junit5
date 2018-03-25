package com.github.mrsuvez.json_jackson.domain;

import com.github.mrsuvez.json_jackson.dataHandler.DataHandler;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {


    private DataHandler dataHandler = new DataHandler();

    @Test
    @DisplayName("Reading Person FirstName from file")
    @Tag("fast")
    public void testPerson_FirstName_From_Json() throws IOException {
        assertEquals("Jason",dataHandler.getPerson().getFirstName());
    }

    @Test
    @DisplayName("Reading Person List of Pets from file")
    @Tag("fast")
    public void testPerson_Pets_From_Json(){
        assertAll("pets",
                () -> assertEquals(dataHandler.getPerson().getPets().get(0), "james"),
                () -> assertEquals(dataHandler.getPerson().getPets().get(1), "spencer")
        );
    }

    @Test
    @DisplayName("Test the complex case of json within json")
    @Tag("fast")
    public void testPersonComplexCase() throws IOException {
        assertEquals(dataHandler.getPerson().getComplex().getAnotherKey(),"anotherValue");
    }

    @DisplayName("Write back to json file")
    @Tag("slow")
    @Test
    public void write_to_json() throws IOException {
        Person person = dataHandler.getPerson();
        if(person.getLocation().matches("Earth"))
        {
            System.out.println("Location is Earth setting to Mars");
            person.setLocation("Mars");
            dataHandler.getObjectWriter().writeValue(dataHandler.getMyJaonFilePath(), person);
            assertEquals("Mars", dataHandler.getPerson().getLocation());
        }
        else
         {
            person.setLocation("Earth");
            dataHandler.getObjectWriter().writeValue(dataHandler.getMyJaonFilePath(), person);
            assertEquals("Earth", dataHandler.getPerson().getLocation());
        }
    }

    @DisplayName("Disabled Test should not run")
    @Disabled
    @Tag("fast")
    @RepeatedTest(10)
    public void a_slow_test() throws IOException {
        Person person = dataHandler.getPerson();
        person.setLocation("Mars");
        dataHandler.getObjectWriter().writeValue(dataHandler.getMyJaonFilePath(),person);
    }

    @Test
    @Tag("fast")
    @DisplayName("Working with JsonObject from simple.json")
    public void testJsonObject() throws IOException, ParseException {
        assertEquals("Jason",dataHandler.getJson().get("firstName"));
    }

    @Test
    @Tag("fast")
    @DisplayName("Working with JsonObject from simple.json on complex json")
    public void testJsonObjectComplex() throws IOException, ParseException {
        JSONObject complex = (JSONObject) dataHandler.getJson().get("complex");
        assertEquals("yetAnotherValue",complex.get("yetAnotherKey"));
    }

    @Test
    @DisplayName("Reading Person FirstName from API")
    @Tag("fast")
    public void testPerson_FirstName_From_API(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Person> person = restTemplate.getForEntity("http://localhost:8080/person",Person.class);
        assertAll("api",
                () -> assertEquals("Jason",person.getBody().getFirstName()),
                () -> assertEquals((person.getStatusCodeValue()),200)
        );
    }
}
