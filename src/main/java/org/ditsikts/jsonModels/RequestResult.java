package org.ditsikts.jsonModels;

import com.jayway.jsonpath.DocumentContext;

public class RequestResult {
    private int statusCode;
    private long duration;
    private DocumentContext jsonBody;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public DocumentContext getJsonBody() {
        return jsonBody;
    }

    public void setJsonBody(DocumentContext jsonBody) {
        this.jsonBody = jsonBody;
    }
}
