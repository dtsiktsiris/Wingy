package org.ditsikts.models.controllers;

import java.util.Map;

public class ForController extends Controller {

    private int from;
    private int to;
    private int by;
    private String val;

    @Override
    public void exec(Map<String, String> env) {
        for (int i = from; i <= to; i += by) {
            env.put(val, String.valueOf(i));

            test.exec(env);
        }
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getBy() {
        return by;
    }

    public void setBy(int by) {
        this.by = by;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
