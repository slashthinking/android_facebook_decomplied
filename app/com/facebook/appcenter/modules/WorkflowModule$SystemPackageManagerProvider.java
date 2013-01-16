package com.facebook.appcenter.modules;

import android.content.Context;
import android.content.pm.PackageManager;
import com.facebook.orca.inject.AbstractProvider;

class WorkflowModule$SystemPackageManagerProvider extends AbstractProvider<PackageManager>
{
  private WorkflowModule$SystemPackageManagerProvider(WorkflowModule paramWorkflowModule)
  {
  }

  public PackageManager a()
  {
    return WorkflowModule.a(this.a).getPackageManager();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.modules.WorkflowModule.SystemPackageManagerProvider
 * JD-Core Version:    0.6.0
 */