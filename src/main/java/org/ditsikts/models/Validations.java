package org.ditsikts.models;

import org.ditsikts.validator.Validator;

import java.util.Map;

public class Validations {
    private String statusCode;
    private long duration;
    private Map<String,String> body;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public Map<String, String> getBody() {
        return body;
    }

    public void setBody(Map<String, String> body) {
        this.body = body;
    }

    public void validate(RequestResult rs){

        Validator validator = new Validator();

        if (statusCode != null) {
            validator.assertEqual(String.valueOf(rs.getStatusCode()), statusCode);
        }

        if (duration != 0) {
            validator.assertLower(rs.getDuration(), duration);
        }

        if(body != null){
            String s;
            for (Map.Entry<String,String> bodyValidation: body.entrySet()) {
                s = rs.getJsonBody().read(bodyValidation.getKey()).toString();
                validator.assertEqual(s, bodyValidation.getValue());
            }
        }
    }
}
