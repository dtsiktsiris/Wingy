package org.ditsikts.models;

import org.ditsikts.replacer.Replacer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test {
    private Request request;
    private List<Request> sentRequest = new ArrayList<>();
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

    public List<Request> getSentRequest() {
        return sentRequest;
    }

    public void setSentRequest(List<Request> sentRequest) {
        this.sentRequest = sentRequest;
    }

    public void exec(Map<String, String> env) {
        sentRequest.add(replaceDynamicValues(env));

        RequestResult requestResult = sentRequest.getLast().sendRequest();
        setRequestResult(requestResult);

        validations.validate(requestResult);

        keepValues(env);
    }

    public void keepValues(Map<String, String> env){
        if(keep == null) return;

        for (Map.Entry<String,String> keepEntry: keep.entrySet()) {
            env.put(keepEntry.getKey(), requestResult.getJsonBody().read(keepEntry.getValue()).toString());
        }

    }

    public Request replaceDynamicValues(Map<String,String> env){
        Replacer replacer = new Replacer();

        Request updatedRequest = new Request();

        updatedRequest.setURL(replacer.replaceInString(request.getURL(),env));
        updatedRequest.setMethod(request.getMethod());
        updatedRequest.setHeaders(request.getHeaders());

        updatedRequest.setHeaders(replacer.replaceInMap(request.getHeaders(),env));

        return updatedRequest;
    }
}
