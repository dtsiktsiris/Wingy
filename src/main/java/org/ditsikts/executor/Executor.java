package org.ditsikts.executor;

import org.ditsikts.models.Request;
import org.ditsikts.models.RequestResult;
import org.ditsikts.models.Suite;

public class Executor {
    public ReplaceExecutor repe = new ReplaceExecutor();
    public ValidationExecutor ve = new ValidationExecutor();
    public KeepExecutor ke = new KeepExecutor();

    public void run(Suite s){
        Request r =  repe.replaceAll(s.getControllers().get(0).test.getRequest(),s.getEnvironment());

        s.getControllers().get(0).test.setRequest(r);

        s.getControllers().get(0).exec();
        ve.validate(s.getControllers().get(0).test);
        ke.keepValues(s.getControllers().get(0).test, s.getEnvironment());
    }
}
