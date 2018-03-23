package com.github.mrsuvez.json_jackson.dataHandler;


import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.github.mrsuvez.json_jackson.domain.Person;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class DataHandler {

    private String myJaonFilePath = "src\\main\\resources\\MyPeople.json";
    private ObjectMapper objectMapper = new ObjectMapper();
    private ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
    private JSONParser jsonParser = new JSONParser();

    public ObjectWriter getObjectWriter() {
        return objectWriter;
    }
    public DataHandler() throws IOException {
    }
    public Person getPerson() throws IOException {
        return objectMapper.readerFor(Person.class).readValue(new File(myJaonFilePath));
    }
    public JSONObject getJson() throws IOException, ParseException {
        JSONObject myJson = (JSONObject) jsonParser.parse(new FileReader(myJaonFilePath));
        return myJson;
    }

    public File getMyJaonFilePath() {
        return new File(myJaonFilePath);
    }
}
