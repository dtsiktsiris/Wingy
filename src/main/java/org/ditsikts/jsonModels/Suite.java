package org.ditsikts.jsonModels;

import org.ditsikts.jsonModels.controllers.Controller;

import java.util.*;

public class Suite {
    Map<String,String> keeper = new HashMap<>();
    List<Controller> controllers = new ArrayList<>();

    public Map<String, String> getKeeper() {
        return keeper;
    }

    public void setKeeper(Map<String, String> keeper) {
        this.keeper = keeper;
    }

    public List<Controller> getControllers() {
        return controllers;
    }

    public void setControllers(List<Controller> controllers) {
        this.controllers = controllers;
    }
}
