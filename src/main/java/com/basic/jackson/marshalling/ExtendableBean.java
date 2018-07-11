package com.basic.jackson.marshalling;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

@JsonPropertyOrder({ "properties", "name" })
public class ExtendableBean {

    private String name;
    private Map<String, String> properties;

    public ExtendableBean(String name) {
        this.name = name;
        this.properties = new HashMap<>();
    }

    public void addKeyValue(String key, String value) {
        properties.put(key, value);
    }

    @JsonGetter("beanName")
    public String getName() {
        return name;
    }

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }
}
