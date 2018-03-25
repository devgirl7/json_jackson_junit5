package com.github.mrsuvez.json_jackson.dataHandler;


import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.github.mrsuvez.json_jackson.domain.Person;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Service
public class DataHandler {

    private String myJaonFilePath = "src\\main\\resources\\MyPeople.json";
    private ObjectMapper objectMapper = new ObjectMapper();
    private ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
    private JSONParser jsonParser = new JSONParser();

    public String getSpringTestThis() {
        return springTestThis;
    }

    private String springTestThis = "springTestThis";

    public ObjectWriter getObjectWriter() {
        return objectWriter;
    }
    public DataHandler(){
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
