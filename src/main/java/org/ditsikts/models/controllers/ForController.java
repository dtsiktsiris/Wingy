package org.ditsikts.models.controllers;

import java.util.Map;

public class ForController extends Controller {

    private String loop;
    private String val;

    @Override
    public void exec(Map<String, String> env) {

        if( loop.contains("to") && loop.contains("by")){
            var splitTo = loop.split("to");
            var splitBy = splitTo[1].split("by");

            var from = Integer.parseInt(splitTo[0]);
            var to = Integer.parseInt(splitBy[0]);
            var by = Integer.parseInt(splitBy[1]);

            for (int i = from; i<=to; i+=by){
                test.exec(env);
            }
        }
    }

    public String getLoop() {
        return loop;
    }

    public void setLoop(String loop) {
        this.loop = loop;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
