package org.ditsikts.executor;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.ditsikts.jsonModels.Test;
import org.ditsikts.validator.Validator;

import java.util.Map;


public class ValidationExecutor {

    private final Validator validator = new Validator();
    public void validate(Test t) {
        if (t.getValidations().getStatusCode() != null) {
            validator.assertEqual(String.valueOf(t.getHttpResponse().statusCode()), t.getValidations().getStatusCode());
        }

        if (t.getValidations().getDuration() != 0) {
            validator.assertLower(t.getDuration(), t.getValidations().getDuration());
        }

        if(t.getValidations().getBody() != null){
            DocumentContext documentContext = JsonPath.parse(t.getHttpResponse().body());
            String s;
            for (Map.Entry<String,String> bodyValidation: t.getValidations().getBody().entrySet()) {
                s = documentContext.read(bodyValidation.getKey()).toString();
                validator.assertEqual(s, bodyValidation.getValue());
            }
        }

    }
}
