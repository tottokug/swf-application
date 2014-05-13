/**
 * This code was generated from {@link com.tottokug.activity.SampleActivities}.
 *
 * Any changes made directly to this file will be lost when 
 * the code is regenerated.
 */
package com.tottokug.activity;

import com.amazonaws.services.simpleworkflow.flow.core.Promise;
import com.amazonaws.services.simpleworkflow.flow.ActivitiesClient;
import com.amazonaws.services.simpleworkflow.flow.ActivitySchedulingOptions;

public interface SampleActivitiesClient extends ActivitiesClient
{
    Promise<Void> activity();
    Promise<Void> activity(Promise<?>... waitFor);
    Promise<Void> activity(ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor);
}