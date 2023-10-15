package org.ditsikts.models.controllers;

import java.util.Map;
import java.util.Objects;

public class IfController extends Controller {
    private String lhs;
    private String condition;
    private String rhs;

    @Override
    public void exec(Map<String, String> env) {

        if (Objects.equals(condition, "==")) {
            if (lhs.equals(rhs)) {
                test.exec(env);
            }
        }

    }

    public String getLhs() {
        return lhs;
    }

    public void setLhs(String lhs) {
        this.lhs = lhs;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getRhs() {
        return rhs;
    }

    public void setRhs(String rhs) {
        this.rhs = rhs;
    }
}
