package com.tottokug.activity;

import com.amazonaws.services.simpleworkflow.flow.annotations.Activities;
import com.amazonaws.services.simpleworkflow.flow.annotations.Activity;
import com.amazonaws.services.simpleworkflow.flow.annotations.ActivityRegistrationOptions;

@Activities(activityNamePrefix="sample")
@ActivityRegistrationOptions(defaultTaskScheduleToStartTimeoutSeconds = 0, defaultTaskStartToCloseTimeoutSeconds = 0)
public interface SampleActivities {

  @Activity(version = "1.0.0",name="activity")
  public void activity();

}
