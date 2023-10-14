package org.ditsikts.models.controllers;

import java.util.Map;

public class ForController extends Controller {

    private String loop;
    private String val;

    @Override
    public void exec(Map<String, String> env) {

        if( loop.contains("to") && loop.contains("by")){
            int[] loopValues = getFromToBy(loop);

            for (int i = loopValues[0]; i<=loopValues[1]; i+=loopValues[2]){
                env.put(val, String.valueOf(i));

                test.exec(env);
            }
        }
    }

    private int[] getFromToBy(String loop){
        int[] loopValues = new int[3];
        var splitTo = loop.split("to");
        var splitBy = splitTo[1].split("by");

        loopValues[0] = Integer.parseInt(splitTo[0]);
        loopValues[1] = Integer.parseInt(splitBy[0]);
        loopValues[2] = Integer.parseInt(splitBy[1]);
        // [ <from>, <to>, <by>]
        return loopValues;
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
