package org.ditsikts;

import com.google.gson.Gson;
import org.ditsikts.executor.Executor;
import org.ditsikts.models.Test;

public class Main {
    public static void main(String[] args) {
        String json = """
                {
                    request: {
                        "method": "GET",
                        "URL": "https://gophercoding.com",
                        "headers": {
                            "accept":"application/json",
                            "accept2":"application/json2"
                        }
                    },
                    validations: {
                        statusCode: 201,
                        duration: 1000
                    }
                }""";

        Gson gson = new Gson();

        Test t = gson.fromJson(json, Test.class);

        Executor executor = new Executor();
        executor.re.sendRequest(t);
        executor.ve.validate(t);
        System.out.println(t.getValidations().getDuration());
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