package org.ditsikts.models.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.ditsikts.models.RequestResult;
import org.ditsikts.models.Test;

import java.net.http.HttpRequest;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SimpleController.class, name = "simple"),
        @JsonSubTypes.Type(value = WhileController.class, name = "while"),
        @JsonSubTypes.Type(value = ForController.class, name = "for")}
)
public abstract class Controller {
    public Test test;

    public abstract void exec(Map<String, String> env);
}
