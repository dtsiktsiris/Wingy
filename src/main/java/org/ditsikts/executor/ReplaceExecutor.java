package org.ditsikts.executor;

import org.ditsikts.jsonModels.Request;
import org.ditsikts.replacer.Replacer;

import java.util.Map;

public class ReplaceExecutor {
    private Replacer replacer = new Replacer();

    public Request replaceRequest(Request r, Map<String,String> environment){
        Request updatedRequest = new Request();

        updatedRequest.setURL(replacer.replace(r.getURL(),environment));
        updatedRequest.setMethod(r.getMethod());
        updatedRequest.setHeaders(r.getHeaders());

        return updatedRequest;
    }
}
