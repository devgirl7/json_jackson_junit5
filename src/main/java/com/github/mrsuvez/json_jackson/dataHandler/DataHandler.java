package com.github.mrsuvez.json_jackson.dataHandler;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mrsuvez.json_jackson.domain.Person;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class DataHandler {

    private String myJaonFilePath = "src\\main\\resources\\MyPeople.json";
    private ObjectMapper objectMapper = new ObjectMapper();
    JSONParser jsonParser = new JSONParser();

    public DataHandler() throws IOException {
    }

    public Person getPerson() throws IOException {
        return objectMapper.readerFor(Person.class).readValue(new File(myJaonFilePath));
    }
    public void setPerson(Person person) throws IOException {
        objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);
    }

    public JSONObject getJson() throws IOException, ParseException {
        JSONObject myJson = (JSONObject) jsonParser.parse(new FileReader(myJaonFilePath));
        return myJson;
    }
}
