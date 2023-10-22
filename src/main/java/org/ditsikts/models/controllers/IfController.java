package org.ditsikts.models.controllers;

import org.ditsikts.models.utils.Condition;
import org.ditsikts.models.utils.ConditionEnum;
import org.ditsikts.replacer.Replacer;

import java.util.Map;


public class IfController extends Controller {
    private Condition condition;

    @Override
    public void exec(Map<String, String> env) {

        if (condition.apply(env)) {
            test.exec(env);
        }

    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
