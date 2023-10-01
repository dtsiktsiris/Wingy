package org.ditsikts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ditsikts.executor.Executor;
import org.ditsikts.jsonModels.Controller;
import org.ditsikts.jsonModels.SimpleController;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String json = """
                [
                    {
                        "@type": "simple",
                        "test": {
                            "request": {
                                "method": "GET",
                                "url": "http://localhost:10000/articles",
                                "headers": {
                                    "accept":"application/json",
                                    "accept2":"application/json2"
                                }
                            },
                            "validations": {
                                "statusCode": 201,
                                "duration": 1000,
                                "body" : {
                                    "$.[1].Title" : "Hello 3"
                                }
                            }
                        }
                    },
                    {
                        "@type": "while",
                        "test": {
                            "request": {
                                "method": "GET",
                                "url": "http://localhost:10000/articles",
                                "headers": {
                                    "accept":"application/json",
                                    "accept2":"application/json2"
                                }
                            },
                            "validations": {
                                "statusCode": 201,
                                "duration": 1000,
                                "body" : {
                                    "$.[1].Title" : "Hello 3"
                                }
                            }
                        }
                    }
                ]""";

        ObjectMapper objectMapper = new ObjectMapper();

        List<Controller> c = null;
        try {
            c = objectMapper.readValue(json, new TypeReference<List<Controller>>(){});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        Executor executor = new Executor();
        executor.re.sendRequest(c.get(0).test);
        executor.ve.validate(c.get(0).test);
        System.out.println(c.get(0).getClass().getSimpleName());
        System.out.println(c.get(1).getClass().getSimpleName());

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