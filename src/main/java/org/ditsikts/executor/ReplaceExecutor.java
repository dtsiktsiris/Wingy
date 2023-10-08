package org.ditsikts.executor;

import org.ditsikts.models.Request;
import org.ditsikts.replacer.Replacer;

import java.util.Map;

public class ReplaceExecutor {
    private Replacer replacer = new Replacer();

    public Request replaceAll(Request r, Map<String,String> environment){
        Request updatedRequest = new Request();

        updatedRequest.setURL(replacer.replaceInString(r.getURL(),environment));
        updatedRequest.setMethod(r.getMethod());
        updatedRequest.setHeaders(r.getHeaders());

        updatedRequest.setHeaders(replacer.replaceInMap(r.getHeaders(),environment));

        return updatedRequest;
    }

}
