package com.github.mrsuvez.json_jackson.domain;

import com.github.mrsuvez.json_jackson.dataHandler.DataHandler;
import org.junit.jupiter.api.*;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {

    private DataHandler dataHandler = new DataHandler();
    private PersonTest() throws IOException {
    }

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
    @Tag("fast")
    @Test
    public void write_to_json() throws IOException {
        Person person = dataHandler.getPerson();
        person.setLocation("Mars");
        dataHandler.setPerson(person);
    }

    @DisplayName("Disabled Test should not run")
    @Disabled
    @Tag("fast")
    @RepeatedTest(10)
    public void a_slow_test() throws IOException {
        Person person = dataHandler.getPerson();
        person.setLocation("Mars");
        dataHandler.setPerson(person);
    }
}
