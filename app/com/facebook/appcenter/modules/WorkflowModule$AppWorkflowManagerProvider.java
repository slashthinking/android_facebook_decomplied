package com.facebook.appcenter.modules;

import android.content.pm.PackageManager;
import com.facebook.appcenter.cache.AppServerStateCache;
import com.facebook.appcenter.workflow.AppDownloadController;
import com.facebook.appcenter.workflow.AppInstallController;
import com.facebook.appcenter.workflow.AppWorkflowManager;
import com.facebook.appcenter.workflow.PackageUtil;
import com.facebook.appcenter.workflow.WorkflowDatabaseHelper;
import com.facebook.orca.inject.AbstractProvider;

class WorkflowModule$AppWorkflowManagerProvider extends AbstractProvider<AppWorkflowManager>
{
  private WorkflowModule$AppWorkflowManagerProvider(WorkflowModule paramWorkflowModule)
  {
  }

  public AppWorkflowManager a()
  {
    return new AppWorkflowManager(WorkflowModule.a(this.a), (AppServerStateCache)b(AppServerStateCache.class), (AppDownloadController)b(AppDownloadController.class), (AppInstallController)b(AppInstallController.class), (PackageUtil)b(PackageUtil.class), (WorkflowDatabaseHelper)b(WorkflowDatabaseHelper.class), (PackageManager)b(PackageManager.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.modules.WorkflowModule.AppWorkflowManagerProvider
 * JD-Core Version:    0.6.0
 */