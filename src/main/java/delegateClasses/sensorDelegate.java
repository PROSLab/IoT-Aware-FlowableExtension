package delegateClasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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
import org.json.JSONArray;
import org.json.JSONObject;

import delegateClasses.Gateway;

public class sensorDelegate implements JavaDelegate {
	
	public FixedValue sensorName;
	public FixedValue sensorSource;
	public FixedValue sensorSourceType;
	
	public void execute(DelegateExecution execution) {
		
		String name = sensorName.getExpressionText();
		String source = sensorSource.getExpressionText();
		String sourceType = sensorSourceType.getExpressionText();
		
		try
		{
			if(name != null && source != null && sourceType != null) {
				System.out.println("----------Start to contacting the GATEWAY-------------");
				Thread.sleep(5000);				
				
			}
		}
		catch(Exception m)
		{
			if(name == null)
				throw new IllegalStateException("Null " +name);
			if(source == null)
				throw new IllegalStateException("Null " +source);
			if(sourceType == null)
				throw new IllegalStateException("Null " +sourceType);
			
		}
		

		switch(sourceType) {
		case "HTTP":
			try {
			String url = source;//"http://dweet.io/get/dweets/for/senderIOT";
	        URL obj = new URL(url);
	        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	        // optional default is GET
	        con.setRequestMethod("GET");
	        //add request header
	        int responseCode = con.getResponseCode();
	        System.out.println("\nSending 'GET' request to URL : " + url);
	        System.out.println("Response Code : " + responseCode);
	        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	        String inputLine;
	        StringBuffer response = new StringBuffer();
	        while ((inputLine = in.readLine()) != null) {
	        	response.append(inputLine);
	        }
	        in.close();
	        
	        JSONObject myResponse = new JSONObject(response.toString());       	        
	        JSONArray result = myResponse.getJSONArray("with"); 
	        JSONObject jsonObjectItem = result.getJSONObject(0);
	        JSONObject jsonObjectTempHum = jsonObjectItem.getJSONObject("content"); 
	        
	        float temp = jsonObjectTempHum.getFloat("Temperature");
	        float hum = jsonObjectTempHum.getFloat("Humidity");
	        String led = jsonObjectTempHum.getString("LED");
	        
	        HashMap<String, Object> variables = new HashMap<String, Object>();
	        variables.put("Temperature", temp);
	        variables.put("Humidity", hum);
	        variables.put("LED", led);
	            
	        execution.setVariable("Temperature", temp);
	        execution.setVariable("Humidity", hum);
	        execution.setVariable("LED", led);
	        
	        Gateway gateway=new Gateway();
	        gateway.setTemperature((int) temp);
	        gateway.setHumidity((int) hum);
	        gateway.setventilationStatus(true);
	        execution.setVariable("gateway", gateway);
			
			System.out.println("----------Devices parameters:-------------");
			System.out.println("The sensor id is: "+ execution.getCurrentActivityId());
			System.out.println("The sensor name: "+ name);
			System.out.println("The sensor source type: "+sourceType);
			System.out.println("The sensor source is: "+ source);
	        System.out.println("The temperature source is: "+ temp+ "\n The Humidity value is:"+hum+"\n The LED status is:"+led);
	        Thread.sleep(5000);
			
			}
			catch(Exception e){
				throw new IllegalStateException("Unable to contact " +source);
			}
			break;
			
		case "MQTT":
			System.out.println("The device "+name+"starts an MQTT connection");
			//TODO MQTT
			break;
			
		case "Bluetooth":
			 System.out.println("The device "+name+"starts a Bluetooth connection");
			break;
		default:
			throw new IllegalStateException("Unknown response tipe value " +sourceType);
		}
	}
}
