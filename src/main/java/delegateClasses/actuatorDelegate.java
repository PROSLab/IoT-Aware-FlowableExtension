package delegateClasses;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.flowable.bpmn.model.FieldExtension;
import org.flowable.bpmn.model.FlowElement;
import org.flowable.bpmn.model.TaskWithFieldExtensions;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.flowable.engine.impl.el.FixedValue;
import org.json.JSONArray;
import org.json.JSONObject;

public class actuatorDelegate implements JavaDelegate{
	
	public FixedValue actuatorName;
	public FixedValue responseTyped;
	public FixedValue responseString;
	public FixedValue targetSource;
	public FixedValue response;
	
	public void execute(DelegateExecution execution) {	
		
		String name = actuatorName.getExpressionText();
		String responseType = responseTyped.getExpressionText();
		String response = responseString.getExpressionText();	
		String target = targetSource.getExpressionText();	
		
		try
		{
			if(name != null && responseType != null && response != null) {
				System.out.println("----------Start contacting: "+name+"-------------");
				System.out.println("The sensor id is: "+ execution.getCurrentActivityId());
				System.out.println("The actuator name: "+ name);
				System.out.println("The actuator's response type is: "+ responseType);
				System.out.println("The actuator's target source is: "+ target);
				
			}
		}
		catch(Exception m)
		{
			if(name == null)
				throw new IllegalStateException("Null " +name);
			if(response == null)
				throw new IllegalStateException("Null " +response);
			if(target == null)
				throw new IllegalStateException("Null " +target);
			if(responseType == null)
				throw new IllegalStateException("Null " +responseType);
		}
		
		
//		FlowElement flowElement = execution.getCurrentFlowElement();
//		List<FieldExtension> fieldExtensions = ((TaskWithFieldExtensions) flowElement).getFieldExtensions();
//		
//		for(int i = 0; i< fieldExtensions.size(); i++) {
//			System.out.println(+i+") Attribute name:  "+fieldExtensions.get(i).getFieldName());
//		}
		
		
		switch(responseType) {
		case "HTTP":
			try {

				URL url = new URL(target);
				HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
				httpCon.setDoOutput(true);
				httpCon.setRequestMethod("POST");
				OutputStream os = httpCon.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");    
				osw.write(response);
				osw.flush();
				osw.close();
				os.close();  
				httpCon.connect();
				BufferedInputStream bis = new BufferedInputStream(httpCon.getInputStream());
				ByteArrayOutputStream buf = new ByteArrayOutputStream();
				int result2 = bis.read();
				while(result2 != -1) {
				    buf.write((byte) result2);
				    result2 = bis.read();
				}  
			System.out.println("----------Start actuating: "+name+"-------------");	
			Thread.sleep(25000);
			System.out.println("The actuator response is: "+ response);
			HashMap<String, Object> variables = new HashMap<String, Object>();
		    variables.put("Response", response);
	        System.out.println("Setted the "+response);				
	        Thread.sleep(5000);
			}
			catch(Exception e){
				throw new IllegalStateException("Unable to contact " +target);
			}
			break;
			
		case "MQTT":
			System.out.println("The device "+name+" starts an MQTT connection to");
			//TODO MQTT
			break;
			
		case "Bluetooth":
			 System.out.println("The device "+name+" starts a Bluetooth connection");
			break;
		default:
			throw new IllegalStateException("Unknown response tipe value " +responseType);
		
		}
		
	}
}
