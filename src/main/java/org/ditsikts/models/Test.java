package org.ditsikts.models;

import java.net.http.HttpResponse;

public class Test {
    private Request request;
    private HttpResponse<String> httpResponse;
    private Validate validate;

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

    public Validate getValidate() {
        return validate;
    }

    public void setValidate(Validate validate) {
        this.validate = validate;
    }
}
