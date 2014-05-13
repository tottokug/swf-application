/*
 * This code was generated by AWS Flow Framework Annotation Processor.
 * Refer to Amazon Simple Workflow Service documentation at http://aws.amazon.com/documentation/swf 
 *
 * Any changes made directly to this file will be lost when 
 * the code is regenerated.
 */
 package com.tottokug.workflow;

import com.amazonaws.services.simpleworkflow.flow.WorkflowClientFactory;

/**
 * Generated from {@link com.tottokug.workflow.SampleWorkflow}. 
 * Used to create workflow clients for use within the scope of a parent workflow.
 * <p>
 * When running outside of the scope of a workflow use {@link SampleWorkflowClientExternalFactory} instead.
 */
public interface SampleWorkflowClientFactory extends WorkflowClientFactory<SampleWorkflowClient> {
    
}