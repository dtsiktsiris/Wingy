package org.ditsikts.jsonModels.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.ditsikts.jsonModels.Test;
import org.ditsikts.jsonModels.controllers.SimpleController;
import org.ditsikts.jsonModels.controllers.WhileController;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SimpleController.class, name = "simple"),
        @JsonSubTypes.Type(value = WhileController.class, name = "while")}
)
public abstract class Controller {
    public Test test;
}
