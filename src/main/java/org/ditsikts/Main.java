package org.ditsikts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ditsikts.executor.Executor;
import org.ditsikts.jsonModels.Suite;
import org.ditsikts.jsonModels.controllers.Controller;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String json = """
                {
                    "controllers": [
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
                                },
                                "keep": {
                                    "title": "$.[1].Title"
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
                    ]
                }""";

        ObjectMapper objectMapper = new ObjectMapper();

//        List<Controller> c = null;
        Suite s;
        try {
//            c = objectMapper.readValue(json, new TypeReference<List<Controller>>(){});
            s = objectMapper.readValue(json, Suite.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        Executor executor = new Executor();
        executor.run(s);
        System.out.println(s.getKeeper());
//        System.out.println(c.get(1).getClass().getSimpleName());

    }
}