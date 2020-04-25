package delegateClasses;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.flowable.bpmn.model.FieldExtension;
import org.flowable.bpmn.model.FlowElement;
import org.flowable.bpmn.model.TaskWithFieldExtensions;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.flowable.engine.impl.el.FixedValue;

public class actuatorDelegate implements JavaDelegate{
	
	public FixedValue actuatorName;
	public FixedValue responseTyped;
	public FixedValue Response;
	public FixedValue sensorGeolocalization;
	
	public void execute(DelegateExecution execution) {	
		
		String name = actuatorName.getExpressionText();
		String responseType = responseTyped.getExpressionText();
		String response = Response.getExpressionText();
		String geolocalization = sensorGeolocalization.getExpressionText();		
		
		try
		{
			if(name != null && responseType != null && response != null) {
				System.out.println("The sensor id is: "+ execution.getCurrentActivityId());
				System.out.println("The sensor name: "+ name);
				System.out.println("The actuator's response type is: "+ responseType);
				System.out.println("The actuator response is: "+ response);
				System.out.println("The sensor position is: "+ geolocalization);
			}
		}
		catch(Exception m)
		{
			if(name == null)
				System.out.println("Actuator task's name is null");
			if(response == null)
				System.out.println("The actuator task's destination is null");
		}
		
		
		FlowElement flowElement = execution.getCurrentFlowElement();
		List<FieldExtension> fieldExtensions = ((TaskWithFieldExtensions) flowElement).getFieldExtensions();
		
		for(int i = 0; i< fieldExtensions.size(); i++) {
			System.out.println(+i+") Attribute name:  "+fieldExtensions.get(i).getFieldName());
		}
	}
}
