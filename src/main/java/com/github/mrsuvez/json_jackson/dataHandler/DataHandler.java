package com.github.mrsuvez.json_jackson.dataHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mrsuvez.json_jackson.domain.Person;

import java.io.File;
import java.io.IOException;
public class DataHandler {


    private String myJaonFilePath = "src\\main\\resources\\MyPeople.json";
    private Person person = new ObjectMapper().readerFor(Person.class).readValue(new File(myJaonFilePath));

    public DataHandler() throws IOException{}

    public Person getPerson() {
        return person;
    }
}

