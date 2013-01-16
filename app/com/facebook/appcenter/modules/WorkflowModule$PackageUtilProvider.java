package com.facebook.appcenter.modules;

import android.app.DownloadManager;
import android.content.pm.PackageManager;
import com.facebook.appcenter.workflow.PackageUtil;
import com.facebook.orca.inject.AbstractProvider;

class WorkflowModule$PackageUtilProvider extends AbstractProvider<PackageUtil>
{
  private WorkflowModule$PackageUtilProvider(WorkflowModule paramWorkflowModule)
  {
  }

  public PackageUtil a()
  {
    return new PackageUtil(WorkflowModule.a(this.a), (DownloadManager)b(DownloadManager.class), (PackageManager)b(PackageManager.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.modules.WorkflowModule.PackageUtilProvider
 * JD-Core Version:    0.6.0
 */