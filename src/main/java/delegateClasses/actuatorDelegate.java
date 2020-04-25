package delegateClasses;

import java.util.HashMap;
import java.util.Map;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class actuatorDelegate implements JavaDelegate{
	public void execute(DelegateExecution execution) {	
		
		Map<String, Object> variables = new HashMap<String, Object>();

        System.out.println("Check that actuator works");
	}
}
