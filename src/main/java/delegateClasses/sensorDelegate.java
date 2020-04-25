package delegateClasses;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.flowable.bpmn.model.BpmnModel;
import org.flowable.bpmn.model.FieldExtension;
import org.flowable.bpmn.model.FlowElement;
import org.flowable.bpmn.model.Task;
import org.flowable.bpmn.model.TaskWithFieldExtensions;
import org.flowable.engine.TaskService;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.DelegateHelper;
import org.flowable.engine.delegate.JavaDelegate;
import org.flowable.engine.impl.el.FixedValue;

public class sensorDelegate implements JavaDelegate {
	
	public FixedValue sensorName;
	public FixedValue sensorSource;
	public FixedValue sensorGeolocalization;
	
	public void execute(DelegateExecution execution) {
		
		String name = sensorName.getExpressionText();
		String source = sensorSource.getExpressionText();
		String geolocalization = sensorGeolocalization.getExpressionText();
		
		try
		{
			if(name != null && source != null) {
				System.out.println("The sensor id is: "+ execution.getCurrentActivityId());
				System.out.println("The sensor name: "+ name);
				System.out.println("The sensor source is: "+ source);
				System.out.println("The sensor position is: "+ geolocalization);
			}
		}
		catch(Exception m)
		{
			if(name == null)
				System.out.println("Sensing task's name is null");
			if(source == null)
				System.out.println("The sensing task's source is null");
		}
		
		
		FlowElement flowElement = execution.getCurrentFlowElement();
		List<FieldExtension> fieldExtensions = ((TaskWithFieldExtensions) flowElement).getFieldExtensions();
		
		for(int i = 0; i< fieldExtensions.size(); i++) {
			System.out.println(+i+") Attribute name:  "+fieldExtensions.get(i).getFieldName());
		}
		

	}
}
