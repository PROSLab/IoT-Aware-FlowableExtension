package delegateClasses;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class actuatorDelegate implements JavaDelegate{
	public void execute(DelegateExecution execution) {
        System.out.println("Check that actuator"+execution.getVariable("actuatorName")+" works");
	}
}
