package org.ditsikts.executor;

import org.ditsikts.jsonModels.Request;
import org.ditsikts.jsonModels.RequestResult;
import org.ditsikts.jsonModels.Suite;

public class Executor {
    public ReplaceExecutor repe = new ReplaceExecutor();
    public RequestExecutor re = new RequestExecutor();
    public ValidationExecutor ve = new ValidationExecutor();
    public KeepExecutor ke = new KeepExecutor();

    public void run(Suite s){
        Request r =  repe.replaceAll(s.getControllers().get(0).test.getRequest(),s.getEnvironment());

//        s.getControllers().get(0).test.getSentRequest().add(r);
        s.getControllers().get(0).test.setRequest(r);

        RequestResult rr = re.sendRequest(s.getControllers().get(0).test);
        s.getControllers().get(0).test.setRequestResult(rr);
        ve.validate(s.getControllers().get(0).test);
        ke.keepValues(s.getControllers().get(0).test, s.getEnvironment());
    }
}
