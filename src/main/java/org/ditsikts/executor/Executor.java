package org.ditsikts.executor;

import org.ditsikts.jsonModels.RequestResult;
import org.ditsikts.jsonModels.Suite;
import org.ditsikts.jsonModels.controllers.Controller;

public class Executor {
    public RequestExecutor re = new RequestExecutor();
    public ValidationExecutor ve = new ValidationExecutor();
    public KeepExecutor ke = new KeepExecutor();

    public void run(Suite s){
        RequestResult rr = re.sendRequest(s.getControllers().get(0).test);
        s.getControllers().get(0).test.setRequestResult(rr);
        ve.validate(s.getControllers().get(0).test);
        ke.keepValues(s.getControllers().get(0).test, s.getKeeper());
    }
}
