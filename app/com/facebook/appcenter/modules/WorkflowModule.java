package com.facebook.appcenter.modules;

import android.app.DownloadManager;
import android.content.Context;
import android.content.pm.PackageManager;
import com.facebook.appcenter.workflow.AppDownloadController;
import com.facebook.appcenter.workflow.AppInstallController;
import com.facebook.appcenter.workflow.AppWorkflowManager;
import com.facebook.appcenter.workflow.PackageUtil;
import com.facebook.appcenter.workflow.WorkflowDatabaseHelper;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;
import com.google.common.base.Preconditions;

public class WorkflowModule extends AbstractModule
{
  private final Context a;

  public WorkflowModule(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    this.a = paramContext;
  }

  protected void a()
  {
    a(DownloadManager.class).a(new WorkflowModule.SystemServiceProvider(this, "download"));
    a(PackageManager.class).a(new WorkflowModule.SystemPackageManagerProvider(this, null));
    a(AppWorkflowManager.class).a(new WorkflowModule.AppWorkflowManagerProvider(this, null)).a();
    a(AppDownloadController.class).a(new WorkflowModule.AppDownloadControllerProvider(this, null)).a();
    a(AppInstallController.class).a(new WorkflowModule.AppInstallControllerProvider(this, null)).a();
    a(WorkflowDatabaseHelper.class).a(new WorkflowModule.WorkflowDatabaseHelperProvider(this, null)).a();
    a(PackageUtil.class).a(new WorkflowModule.PackageUtilProvider(this, null)).a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.modules.WorkflowModule
 * JD-Core Version:    0.6.0
 */