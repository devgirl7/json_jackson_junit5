package com.github.mrsuvez.json_jackson.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("mobile")
    private String mobile;
    @JsonProperty("location")
    private String location;
    @JsonProperty("pets")
    private List<String> pets;
    @JsonProperty("complex")
    private Complex complex;

    public Complex getComplex() {
        return complex;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getPets() {
        return pets;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", location='" + location + '\'' +
                ", pets=" + pets +
                ", complex=" + complex +
                '}';
    }
}
