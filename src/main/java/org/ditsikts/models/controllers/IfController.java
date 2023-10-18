package org.ditsikts.models.controllers;

import org.ditsikts.models.utils.Condition;

import java.util.Map;
import java.util.Objects;

public class IfController extends Controller {
    private String lhs;
    private Condition condition;
    private String rhs;

    @Override
    public void exec(Map<String, String> env) {

        switch (condition){
            case EQUALS -> {
                if ((lhs.equals(rhs))) {
                    test.exec(env);
                }
            }
        }
    }

    public String getLhs() {
        return lhs;
    }

    public void setLhs(String lhs) {
        this.lhs = lhs;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public String getRhs() {
        return rhs;
    }

    public void setRhs(String rhs) {
        this.rhs = rhs;
    }
}
