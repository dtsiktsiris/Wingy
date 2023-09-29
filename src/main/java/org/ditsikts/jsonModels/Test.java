package org.ditsikts.jsonModels;

import java.net.http.HttpResponse;

public class Test {
    private Request request;
    private HttpResponse<String> httpResponse;
    private Validations validations;
    private long duration;

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public HttpResponse<String> getHttpResponse() {
        return httpResponse;
    }

    public void setHttpResponse(HttpResponse<String> httpResponse) {
        this.httpResponse = httpResponse;
    }

    public Validations getValidations() {
        return validations;
    }

    public void setValidations(Validations validate) {
        this.validations = validate;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}
