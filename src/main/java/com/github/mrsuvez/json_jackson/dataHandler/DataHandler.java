package com.github.mrsuvez.json_jackson.dataHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mrsuvez.json_jackson.domain.Person;

import java.io.File;
import java.io.IOException;
public class DataHandler {


    private String myJaonFilePath = "src\\main\\resources\\MyPeople.json";
    private ObjectMapper objectMapper = new ObjectMapper();

    public DataHandler() throws IOException {
    }

    public Person getPerson() throws IOException {
        return objectMapper.readerFor(Person.class).readValue(new File(myJaonFilePath));
    }
    public void setPerson(Person person) throws IOException {
        objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);
    }
}

