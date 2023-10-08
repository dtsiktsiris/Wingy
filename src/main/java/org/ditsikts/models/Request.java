package org.ditsikts.models;

import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;

public class Request {
    private String method;
    private String URL;
    private Map<String, String> headers;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public RequestResult sendRequest(){
        HttpRequest request = prepareHttpRequest();

        HttpResponse<String> response;
        long difference;
        try(HttpClient httpClient = HttpClient.newHttpClient()){

            Instant start_time = Instant.now();
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            Instant end_time = Instant.now();
            difference = Duration.between(start_time,end_time).toMillis();

        }  catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }

        return prepareRequestResult(response, difference);
    }

    private HttpRequest prepareHttpRequest(){

        HttpRequest httpRequest;
        try {
            HttpRequest.Builder builder = HttpRequest.newBuilder()
                    .uri(new URI(getURL()))
                    .method(getMethod(), HttpRequest.BodyPublishers.noBody());
            for (Map.Entry<String,String> header: getHeaders().entrySet()) {
                builder.header(header.getKey(), header.getValue());
            }
            httpRequest = builder.build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return httpRequest;
    }

    private RequestResult prepareRequestResult(HttpResponse<String> h, long d){
        RequestResult rs = new RequestResult();
        rs.setDuration(d);
        rs.setStatusCode(h.statusCode());
        rs.setJsonBody(JsonPath.parse(h.body()));

        return rs;
    }
}
