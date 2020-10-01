package flowable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.Execution;
import org.flowable.engine.runtime.ProcessInstance;


public class main {
	

	public static void main(String[] args) {
		 ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
			      .setJdbcUrl("jdbc:h2:mem:flowable;DB_CLOSE_DELAY=-1")
			      .setJdbcUsername("sa")
			      .setJdbcPassword("")
			      .setJdbcDriver("org.h2.Driver")
			      .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

			    ProcessEngine processEngine = cfg.buildProcessEngine();
			  
			    //Aggiunta del processo alla repository e deploy
			    RepositoryService repositoryService = processEngine.getRepositoryService();
			    Deployment deployment = repositoryService.createDeployment()
			      .addClasspathResource("MyIOTProcess.bpmn")
			      .deploy();
			    
			    
			    ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
			    		  .deploymentId(deployment.getId())
			    		  .singleResult();		    
			    
			    Map<String, Object> variables = new HashMap<String, Object>();
	    		variables.put("loop", 1);

			    
			    RuntimeService runtimeService = processEngine.getRuntimeService();
			    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myIOTProcess", variables);

	}
}
