package com.github.mrsuvez.json_jackson.domain;

import com.github.mrsuvez.json_jackson.dataHandler.DataHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {


    private DataHandler dataHandler = new DataHandler();
    private Logger logger = LoggerFactory.getLogger(PersonTest.class);
    private PersonTest() throws IOException {
    }

    @Test
    @DisplayName("Reading Person FirstName from file")
    public void testPerson_FirstName_From_Json(){
        assertEquals("Jason",dataHandler.getPerson().getFirstName());
    }

    @Test
    @DisplayName("Reading Person List of Pets from file")
    public void testPerson_Pets_From_Json(){
        assertAll("pets",
                () -> assertEquals(dataHandler.getPerson().getPets().get(0), "james"),
                () -> assertEquals(dataHandler.getPerson().getPets().get(1), "spencer")
        );
    }

    @Test
    @DisplayName("Test the complex case of json within json")
    public void testPersonComplexCase(){
        assertEquals(dataHandler.getPerson().getComplex().getAnotherKey(),"anotherValue");
    }
}
