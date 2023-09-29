package org.ditsikts;

import com.google.gson.Gson;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.ditsikts.executor.Executor;
import org.ditsikts.jsonModels.Test;

public class Main {
    public static void main(String[] args) {
        String json = """
                {
                    "request": {
                        "method": "GET",
                        "URL": "http://localhost:10000/articles",
                        "headers": {
                            "accept":"application/json",
                            "accept2":"application/json2"
                        }
                    },
                    "validations": {
                        "statusCode": 201,
                        "duration": 1000,
                        "body" : {
                            "$.[1].Title" : "Hello 2"
                        }
                    }
                }""";

        Gson gson = new Gson();

        Test t = gson.fromJson(json, Test.class);

        Executor executor = new Executor();
        executor.re.sendRequest(t);
        executor.ve.validate(t);
        System.out.println(t.getValidations().getBody());
        DocumentContext documentContext = JsonPath.parse(t.getHttpResponse().body());
        String s = documentContext.read("$.[1].Id").toString();
        System.out.println(s);
    }
}

//    String json = """
//                {
//                    "controllers":[
//                        {
//                            "type": "simple",
//                            "tests": [
//                                {
//                                    "request": {
//                                        "method": "GET",
//                                        "url": "https://gophercoding.com",
//                                        "headers": {
//                                            "accept":"application/json",
//                                            "accept2":"application/json2"
//                                        }
//                                    },
//                                    "validations": {
//                                        "statusCode": "200",
//                                        "body": {
//                                            "name": "james"
//                                        }
//                                    }
//                                }
//                            ]
//                        }
//                    ]
//                	}""";