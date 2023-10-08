package org.ditsikts.executor;

import org.ditsikts.models.Test;

import java.util.Map;

public class KeepExecutor {

    public void keepValues(Test t, Map<String, String> m){
        for (Map.Entry<String,String> keepEntry: t.getKeep().entrySet()) {
            m.put(keepEntry.getKey(), t.getRequestResult().getJsonBody().read(keepEntry.getValue()).toString());
        }

    }
}
