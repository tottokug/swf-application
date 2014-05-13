/**
 * This code was generated from {@link com.tottokug.workflow.SampleWorkflow}.
 *
 * Any changes made directly to this file will be lost when 
 * the code is regenerated.
 */
package com.tottokug.workflow;

import com.amazonaws.services.simpleworkflow.flow.core.Promise;
import com.amazonaws.services.simpleworkflow.flow.StartWorkflowOptions;
import com.amazonaws.services.simpleworkflow.flow.WorkflowClient;

public interface SampleWorkflowClient extends WorkflowClient
{
    Promise<Void> workflow();
    Promise<Void> workflow(Promise<?>... waitFor);
    Promise<Void> workflow(StartWorkflowOptions optionsOverride, Promise<?>... waitFor);
}