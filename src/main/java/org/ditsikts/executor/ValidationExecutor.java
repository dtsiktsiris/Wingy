package org.ditsikts.executor;

import org.ditsikts.models.Test;
import org.ditsikts.validator.Validator;

import java.util.Map;


public class ValidationExecutor {

    private final Validator validator = new Validator();
    public void validate(Test t) {
        if (t.getValidations().getStatusCode() != null) {
            validator.assertEqual(String.valueOf(t.getRequestResult().getStatusCode()), t.getValidations().getStatusCode());
        }

        if (t.getValidations().getDuration() != 0) {
            validator.assertLower(t.getRequestResult().getDuration(), t.getValidations().getDuration());
        }

        if(t.getValidations().getBody() != null){
            String s;
            for (Map.Entry<String,String> bodyValidation: t.getValidations().getBody().entrySet()) {
                s = t.getRequestResult().getJsonBody().read(bodyValidation.getKey()).toString();
                validator.assertEqual(s, bodyValidation.getValue());
            }
        }

    }
}
