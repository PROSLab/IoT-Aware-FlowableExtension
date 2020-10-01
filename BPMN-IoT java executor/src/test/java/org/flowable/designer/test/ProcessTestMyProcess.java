package org.flowable.designer.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipInputStream;
import java.io.FileInputStream;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.engine.test.FlowableRule;
import org.junit.Rule;
import org.junit.Test;

public class ProcessTestMyProcess {

	private String filename = "C:\\Users\\Ivan Compagnucci\\git\\BPMN-IoT\\deployment\\MyIOTProcess.bar";
	
	@Rule
	public FlowableRule activitiRule = new FlowableRule();

	@Test
	public void startProcess() throws Exception {
		RepositoryService repositoryService = activitiRule.getRepositoryService();
		
		ZipInputStream inputStream = new ZipInputStream(new
				FileInputStream(filename));
		String deploymentID =repositoryService.createDeployment().name("MyIOTProcess.bar").addZipInputStream(inputStream).deploy().getId();
		
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		Map<String, Object> variableMap = new HashMap<String, Object>();
		variableMap.put("loop", 1);

		
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myIOTProcess", variableMap);
		assertNotNull(processInstance.getId());

		
	}
}