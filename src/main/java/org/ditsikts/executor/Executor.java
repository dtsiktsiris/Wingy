package org.ditsikts.executor;

import org.ditsikts.models.Request;
import org.ditsikts.models.Test;

import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Executor {
    public RequestExecutor re = new RequestExecutor();
    public ValidationExecutor ve = new ValidationExecutor();


}
