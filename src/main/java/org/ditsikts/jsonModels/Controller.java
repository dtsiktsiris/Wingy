package org.ditsikts.jsonModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SimpleController.class, name = "simple"),
        @JsonSubTypes.Type(value = WhileController.class, name = "while")}
)
public abstract class Controller {
    public String type;
    public Test test;
}
