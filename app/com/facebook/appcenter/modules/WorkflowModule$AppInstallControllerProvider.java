package com.facebook.appcenter.modules;

import android.content.pm.PackageManager;
import com.facebook.appcenter.workflow.AppInstallController;
import com.facebook.orca.inject.AbstractProvider;

class WorkflowModule$AppInstallControllerProvider extends AbstractProvider<AppInstallController>
{
  private WorkflowModule$AppInstallControllerProvider(WorkflowModule paramWorkflowModule)
  {
  }

  public AppInstallController a()
  {
    return new AppInstallController(WorkflowModule.a(this.a), (PackageManager)b(PackageManager.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.modules.WorkflowModule.AppInstallControllerProvider
 * JD-Core Version:    0.6.0
 */