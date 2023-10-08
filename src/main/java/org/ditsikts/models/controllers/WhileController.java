package org.ditsikts.models.controllers;

import org.ditsikts.models.RequestResult;

import java.util.Map;

public class WhileController extends Controller {

    @Override
    public void exec(Map<String, String> env) {
        test.exec(env);
    }
}
