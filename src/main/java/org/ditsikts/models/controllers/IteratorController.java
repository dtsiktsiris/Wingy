package org.ditsikts.models.controllers;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import java.util.Map;

public class IteratorController extends Controller {
    private String array;
    private Map<String, String> arrayValues;

    @Override
    public void exec(Map<String, String> env) {
        DocumentContext arrayContent = JsonPath.parse(env.get(array));
        int arraySize = arrayContent.read("$.length()");
//        System.out.println(arraySize);
        for (int i=0; i<arraySize; i++) {


            for (Map.Entry<String, String> entry : arrayValues.entrySet()) {
                //get value
                String value = arrayContent.read("$.["+i+"]." +  entry.getValue());
                //set on env
                env.put(entry.getKey(), value);
            }

            test.exec(env);
        }
    }

    public String getArray() {
        return array;
    }

    public void setArray(String array) {
        this.array = array;
    }

    public Map<String, String> getArrayValues() {
        return arrayValues;
    }

    public void setArrayValues(Map<String, String> arrayValues) {
        this.arrayValues = arrayValues;
    }
}
