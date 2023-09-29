package org.ditsikts.executor;

import org.ditsikts.jsonModels.Test;
import org.ditsikts.validator.Validator;


public class ValidationExecutor {

    private final Validator validator = new Validator();
    public void validate(Test t) {
        if (t.getValidations().getStatusCode() != null) {
            validator.assertEquals(String.valueOf(t.getHttpResponse().statusCode()), t.getValidations().getStatusCode());
        }

        if (t.getValidations().getDuration() != 0) {
            validator.assertLower(t.getDuration(), t.getValidations().getDuration());
        }

    }
}
