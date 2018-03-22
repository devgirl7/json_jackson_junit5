package com.github.mrsuvez.json_jackson.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Complex {

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonProperty("anotherKey")
    private String anotherKey;

    @JsonProperty("yetAnotherKey")
    private String yetAnotherKey;


    public String getYetAnotherKey() {
        return yetAnotherKey;
    }

    public void setYetAnotherKey(String yetAnotherKey) {
        this.yetAnotherKey = yetAnotherKey;
    }

    public String getAnotherKey() {
        return anotherKey;
    }

    public void setAnotherKey(String anotherKey) {
        this.anotherKey = anotherKey;
    }

    @Override
    public String toString() {
        return "Complex{" +
                "anotherKey='" + anotherKey + '\'' +
                ", yetAnotherKey='" + yetAnotherKey + '\'' +
                '}';
    }
}
