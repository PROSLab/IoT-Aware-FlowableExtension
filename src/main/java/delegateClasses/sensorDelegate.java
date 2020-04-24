package delegateClasses;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class sensorDelegate implements JavaDelegate{
	public void execute(DelegateExecution execution) {
        System.out.println("Check that sensor "+execution.getVariable("sensorName")+" works");
	}
}
