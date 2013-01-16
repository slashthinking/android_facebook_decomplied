package com.facebook.appcenter.modules;

import com.facebook.appcenter.workflow.WorkflowDatabaseHelper;
import com.facebook.orca.inject.AbstractProvider;

class WorkflowModule$WorkflowDatabaseHelperProvider extends AbstractProvider<WorkflowDatabaseHelper>
{
  private WorkflowModule$WorkflowDatabaseHelperProvider(WorkflowModule paramWorkflowModule)
  {
  }

  public WorkflowDatabaseHelper a()
  {
    return new WorkflowDatabaseHelper(WorkflowModule.a(this.a));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.modules.WorkflowModule.WorkflowDatabaseHelperProvider
 * JD-Core Version:    0.6.0
 */