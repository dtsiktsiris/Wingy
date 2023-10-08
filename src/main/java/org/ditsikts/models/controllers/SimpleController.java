package org.ditsikts.models.controllers;

import org.ditsikts.models.RequestResult;

public class SimpleController extends Controller {

    @Override
    public void exec() {
        RequestResult requestResult = test.getRequest().sendRequest();
        test.setRequestResult(requestResult);
    }
}
