package org.ditsikts.jsonModels;

import java.net.http.HttpResponse;
import java.util.Map;

public class Test {
    private Request request;
    private RequestResult requestResult;
    private Validations validations;
    private Map<String,String> keep;

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public RequestResult getRequestResult() {
        return requestResult;
    }

    public void setRequestResult(RequestResult requestResult) {
        this.requestResult = requestResult;
    }

    public Validations getValidations() {
        return validations;
    }

    public void setValidations(Validations validate) {
        this.validations = validate;
    }


    public Map<String, String> getKeep() {
        return keep;
    }

    public void setKeep(Map<String, String> keep) {
        this.keep = keep;
    }
}
