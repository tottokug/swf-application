/**
 * This code was generated from {@link com.tottokug.workflow.SampleWorkflow}.
 *
 * Any changes made directly to this file will be lost when 
 * the code is regenerated.
 */
package com.tottokug.workflow;

import com.amazonaws.services.simpleworkflow.flow.core.Promise;
import com.amazonaws.services.simpleworkflow.flow.StartWorkflowOptions;
import com.amazonaws.services.simpleworkflow.flow.WorkflowSelfClient;

public interface SampleWorkflowSelfClient extends WorkflowSelfClient
{
    void workflow();
    void workflow(StartWorkflowOptions optionsOverride, Promise<?>... waitFor);
}