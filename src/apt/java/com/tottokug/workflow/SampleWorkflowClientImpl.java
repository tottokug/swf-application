/*
 * This code was generated by AWS Flow Framework Annotation Processor.
 * Refer to Amazon Simple Workflow Service documentation at http://aws.amazon.com/documentation/swf 
 *
 * Any changes made directly to this file will be lost when 
 * the code is regenerated.
 */
 package com.tottokug.workflow;

import com.amazonaws.services.simpleworkflow.flow.DataConverter;
import com.amazonaws.services.simpleworkflow.flow.StartWorkflowOptions;
import com.amazonaws.services.simpleworkflow.flow.WorkflowClientBase;
import com.amazonaws.services.simpleworkflow.flow.core.Promise;
import com.amazonaws.services.simpleworkflow.flow.generic.GenericWorkflowClient;
import com.amazonaws.services.simpleworkflow.model.WorkflowExecution;
import com.amazonaws.services.simpleworkflow.model.WorkflowType;

class SampleWorkflowClientImpl extends WorkflowClientBase implements SampleWorkflowClient {

    public SampleWorkflowClientImpl(WorkflowExecution workflowExecution, WorkflowType workflowType,  
            StartWorkflowOptions options, DataConverter dataConverter, GenericWorkflowClient genericClient) {
        super(workflowExecution, workflowType, options, dataConverter, genericClient);
    }
    
    @Override
    public final Promise<Void> workflow() {
        return workflow((StartWorkflowOptions)null);
    }

    @Override
    public final Promise<Void> workflow(Promise<?>... waitFor) {
        return workflow((StartWorkflowOptions)null, waitFor);
    }
    
    @Override
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public final Promise<Void> workflow(StartWorkflowOptions optionsOverride, Promise<?>... waitFor) {
        return (Promise) startWorkflowExecution(new Object[0], optionsOverride, Void.class, waitFor);
    }
    	

}