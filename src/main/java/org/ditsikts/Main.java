package org.ditsikts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ditsikts.executor.Executor;
import org.ditsikts.models.Suite;

public class Main {
    public static void main(String[] args) {
        String json = """
                {
                    "environment": {
                        "baseURL" : "http://localhost:10000",
                        "value" : "25",
                        "valueb" : "24",
                        "accept":"application/json"
                    },
                    "controllers": [
                        {
                            "@type": "simple",
                            "test": {
                                "request": {
                                    "method": "GET",
                                    "url": "|#baseURL##/articles",
                                    "headers": {
                                        "accept":"|#accept##",
                                        "accept2":"application/json2"
                                    }
                                },
                                "validations": {
                                    "statusCode": 201,
                                    "duration": 1000,
                                    "body" : {
                                        "$.[0].Title" : "Hello 3"
                                    }
                                },
                                "keep": {
                                    "myArray": "$.[*]",
                                    "title": "$.[0].Title"
                                }
                            }
                        },
                                                {
                            "@type": "if",
                            "condition": {
                                "lhs": "|#value##",
                                "condition": "GREATER",
                                "rhs": "|#valueb##"
                            },
                            "test": {
                                "request": {
                                    "method": "GET",
                                    "url": "|#baseURL##/articles",
                                    "headers": {
                                        "accept":"|#accept##",
                                        "accept2":"application/json2"
                                    }
                                },
                                "validations": {
                                    "statusCode": 201,
                                    "duration": 1000,
                                    "body" : {
                                        "$.[0].Title" : "Hello 3"
                                    }
                                },
                                "keep": {
                                    "titleb": "$.[0].Title"
                                }
                            }
                        },
                        {
                            "@type": "iterator",
                            "array": "myArray",
                            "arrayValues": {
                                "ida": "Id"
                            },
                            "test": {
                                "request": {
                                    "method": "GET",
                                    "url": "http://localhost:10000/article/|#ida##",
                                    "headers": {
                                        "accept":"application/json",
                                        "accept2":"application/json2"
                                    }
                                },
                                "validations": {
                                    "statusCode": 200,
                                    "duration": 500,
                                    "body" : {
                                        "$.Title" : "Hello 2"
                                    }
                                }
                            }
                        },
                        {
                            "@type": "for",
                            "from": 1,
                            "to": 1,
                            "by": 1,
                            "val": "index",
                            "test": {
                                "request": {
                                    "method": "GET",
                                    "url": "http://localhost:10000/article/|#index##",
                                    "headers": {
                                        "accept":"application/json",
                                        "accept2":"application/json2"
                                    }
                                },
                                "validations": {
                                    "statusCode": 200,
                                    "duration": 500,
                                    "body" : {
                                        "$.Title" : "Hello 2"
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
        System.out.println(s.getEnvironment());
//        System.out.println(c.get(1).getClass().getSimpleName());

    }
}