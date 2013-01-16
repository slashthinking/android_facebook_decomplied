package com.facebook.bugreporter;

import android.app.NotificationManager;
import android.content.Context;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.base.SingleMethodRunner;

class BugReporterModule$BugReportUploadProvider extends AbstractProvider<BugReportUploader>
{
  private BugReporterModule$BugReportUploadProvider(BugReporterModule paramBugReporterModule)
  {
  }

  public BugReportUploader a()
  {
    return new BugReportUploader((Context)b(Context.class, FromApplication.class), (SingleMethodRunner)b(SingleMethodRunner.class), (BugReportUploadMethod)b(BugReportUploadMethod.class), (FbErrorReporter)b(FbErrorReporter.class), (NotificationManager)b(NotificationManager.class, FromApplication.class), (BugReporterFileUtil)b(BugReporterFileUtil.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.BugReporterModule.BugReportUploadProvider
 * JD-Core Version:    0.6.0
 */