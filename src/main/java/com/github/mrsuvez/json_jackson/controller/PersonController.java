package com.github.mrsuvez.json_jackson.controller;

import com.github.mrsuvez.json_jackson.dataHandler.DataHandler;
import com.github.mrsuvez.json_jackson.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController()
public class PersonController {

    @Autowired
    private DataHandler dataHandler;

    public PersonController() throws IOException {
    }

    @RequestMapping(value = "/person",method = RequestMethod.GET, produces = "application/json")
    public Person personController() throws IOException {

        return dataHandler.getPerson();
    }
}
