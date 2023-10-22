package org.ditsikts.executor;

import org.ditsikts.models.Request;
import org.ditsikts.models.RequestResult;
import org.ditsikts.models.Suite;

public class Executor {

    public void run(Suite s){

        for (var c: s.getControllers()) {
            System.out.println("### "+c.getClass().getSimpleName());
            c.exec(s.getEnvironment());
            System.out.println();
        }


    }
}
