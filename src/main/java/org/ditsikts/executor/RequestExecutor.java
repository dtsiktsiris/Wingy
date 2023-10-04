package org.ditsikts.executor;

import com.jayway.jsonpath.JsonPath;
import org.ditsikts.jsonModels.Request;
import org.ditsikts.jsonModels.RequestResult;
import org.ditsikts.jsonModels.Test;
import org.ditsikts.replacer.Replacer;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;

public class RequestExecutor {

    public RequestResult sendRequest(Test t){
        HttpRequest request = prepareHttpRequest(t.getRequest());

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

    private HttpRequest prepareHttpRequest(Request r){

        HttpRequest httpRequest;
        try {
            HttpRequest.Builder builder = HttpRequest.newBuilder()
                    .uri(new URI(r.getURL()))
                    .method(r.getMethod(), HttpRequest.BodyPublishers.noBody());
            for (Map.Entry<String,String> header: r.getHeaders().entrySet()) {
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
