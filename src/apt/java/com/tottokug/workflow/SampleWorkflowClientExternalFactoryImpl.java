/**
 * This code was generated from {@link com.tottokug.workflow.SampleWorkflow}.
 *
 * Any changes made directly to this file will be lost when 
 * the code is regenerated.
 */
package com.tottokug.workflow;

import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.flow.DataConverter;
import com.amazonaws.services.simpleworkflow.flow.StartWorkflowOptions;
import com.amazonaws.services.simpleworkflow.flow.WorkflowClientFactoryExternalBase;
import com.amazonaws.services.simpleworkflow.flow.generic.GenericWorkflowClientExternal;
import com.amazonaws.services.simpleworkflow.model.WorkflowExecution;
import com.amazonaws.services.simpleworkflow.model.WorkflowType;

public class SampleWorkflowClientExternalFactoryImpl extends WorkflowClientFactoryExternalBase<SampleWorkflowClientExternal>  implements SampleWorkflowClientExternalFactory {

    public SampleWorkflowClientExternalFactoryImpl(AmazonSimpleWorkflow service, String domain) {
		super(service, domain);
		setDataConverter(new com.amazonaws.services.simpleworkflow.flow.JsonDataConverter());
	}
	
	public SampleWorkflowClientExternalFactoryImpl() {
        super(null);
		setDataConverter(new com.amazonaws.services.simpleworkflow.flow.JsonDataConverter());
    }
    
    public SampleWorkflowClientExternalFactoryImpl(GenericWorkflowClientExternal genericClient) {
        super(genericClient);
		setDataConverter(new com.amazonaws.services.simpleworkflow.flow.JsonDataConverter());
    }
	
    @Override
    protected SampleWorkflowClientExternal createClientInstance(WorkflowExecution workflowExecution,
            StartWorkflowOptions options, DataConverter dataConverter, GenericWorkflowClientExternal genericClient) {
        WorkflowType workflowType = new WorkflowType();
        workflowType = new WorkflowType();
        workflowType.setName("SampleWorkflow.workflow");
        workflowType.setVersion("1.0.0-SNAPSHOT");
        return new SampleWorkflowClientExternalImpl(workflowExecution, workflowType, options, dataConverter, genericClient);
    }
    
}