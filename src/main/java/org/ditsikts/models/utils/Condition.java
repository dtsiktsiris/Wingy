package org.ditsikts.models.utils;

import org.ditsikts.replacer.Replacer;

import java.util.Map;

public class Condition {
    private String lhs;
    private ConditionEnum condition;
    private String rhs;

    public boolean apply(Map<String, String> env) {


        Replacer replacer = new Replacer();
        var tempLhs = replacer.replaceInString(lhs, env);
        var tempRhs = replacer.replaceInString(rhs, env);

        boolean result = false;

        switch (condition) {
            case EQUALS -> {
                if ((tempLhs.equals(tempRhs))) {
                    result = true;
//                    System.out.println("EQUALS");
                }
            }
            case GREATER -> {
                if ((tempLhs.compareTo(tempRhs)) > 0) {
                    result = true;
//                    System.out.println("GREATER");
                }
            }
        }

        return result;
    }

    public String getLhs() {
        return lhs;
    }

    public void setLhs(String lhs) {
        this.lhs = lhs;
    }

    public ConditionEnum getCondition() {
        return condition;
    }

    public void setCondition(ConditionEnum condition) {
        this.condition = condition;
    }

    public String getRhs() {
        return rhs;
    }

    public void setRhs(String rhs) {
        this.rhs = rhs;
    }
}
