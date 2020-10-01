package flowable;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.flowable.engine.impl.el.FixedValue;

public class RuleManagement implements JavaDelegate{

	public void execute(DelegateExecution execution) {
		
		float temp = (float) execution.getVariable("Temperature");
        float hum = (float) execution.getVariable("Humidity");

		Gateway gateway = new Gateway();
		gateway.setTemperature((int) temp);
		gateway.setHumidity((int) hum);
		gateway.setventilationStatus(true);
		execution.setVariable("gateway", gateway);
		     
		System.out.println("Ecco i dati "+ gateway);
	}

}
