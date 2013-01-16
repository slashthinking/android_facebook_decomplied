package com.facebook.appcenter.modules;

import android.app.DownloadManager;
import com.facebook.appcenter.workflow.AppDownloadController;
import com.facebook.appcenter.workflow.WorkflowDatabaseHelper;
import com.facebook.orca.inject.AbstractProvider;

class WorkflowModule$AppDownloadControllerProvider extends AbstractProvider<AppDownloadController>
{
  private WorkflowModule$AppDownloadControllerProvider(WorkflowModule paramWorkflowModule)
  {
  }

  public AppDownloadController a()
  {
    return new AppDownloadController(WorkflowModule.a(this.a), (DownloadManager)b(DownloadManager.class), (WorkflowDatabaseHelper)b(WorkflowDatabaseHelper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.modules.WorkflowModule.AppDownloadControllerProvider
 * JD-Core Version:    0.6.0
 */