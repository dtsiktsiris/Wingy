package org.ditsikts.executor;

import org.ditsikts.models.Request;
import org.ditsikts.models.Test;

import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Executor {

    public void sendRequest(Test t){
        HttpRequest request = prepareHttpRequest(t.getRequest());

        HttpResponse<String> response;
        try(HttpClient httpClient = HttpClient.newHttpClient()){
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        }  catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }

        t.setHttpResponse(response);
//        System.out.println(response.statusCode());
    }

    private HttpRequest prepareHttpRequest(Request r){
        HttpRequest httpRequest;
        try {
            httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(r.getURL()))
                    .method(r.getMethod(), HttpRequest.BodyPublishers.noBody())
                    .build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return httpRequest;
    }
}
