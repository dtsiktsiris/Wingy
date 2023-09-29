package org.ditsikts.validator;

import java.util.Objects;

public class Validator {
    public void assertEquals(String actual, String expected){
        System.out.print("Expect " + actual + " to be equal to " + expected);
        if (Objects.equals(actual, String.valueOf(expected))) {
            System.out.println(" SUCCESS");
        } else {
            System.out.println(" FAIL");
        }
    }

    public void assertLower(long actual, long expected) {
        System.out.print("Expect " + actual + " to be lower than " + expected);
        if (actual < expected) {
            System.out.println(" SUCCESS");
        } else {
            System.out.println(" FAIL");
        }
    }
}
