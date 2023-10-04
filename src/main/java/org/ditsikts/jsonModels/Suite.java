package org.ditsikts.jsonModels;

import org.ditsikts.jsonModels.controllers.Controller;

import java.util.*;

public class Suite {
    Map<String,String> environment = new HashMap<>();
    private
    List<Controller> controllers = new ArrayList<>();

    public Map<String, String> getEnvironment() {
        return environment;
    }

    public void setEnvironment(Map<String, String> keeper) {
        this.environment = keeper;
    }

    public List<Controller> getControllers() {
        return controllers;
    }

    public void setControllers(List<Controller> controllers) {
        this.controllers = controllers;
    }
}
