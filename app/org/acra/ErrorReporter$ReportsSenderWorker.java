package org.acra;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import org.acra.util.PackageManagerWrapper;

final class ErrorReporter$ReportsSenderWorker extends Thread
{
  private boolean mApprovePendingReports = false;
  private String mCommentedReportFileName = null;
  private boolean mSendOnlySilentReports = false;
  private String mUserComment = null;
  private String mUserEmail = null;

  public ErrorReporter$ReportsSenderWorker(ErrorReporter paramErrorReporter)
  {
  }

  public ErrorReporter$ReportsSenderWorker(ErrorReporter paramErrorReporter, boolean paramBoolean)
  {
    this.mSendOnlySilentReports = paramBoolean;
  }

  private PowerManager.WakeLock acquireWakeLock()
  {
    PowerManager.WakeLock localWakeLock;
    if (!new PackageManagerWrapper(ErrorReporter.access$000()).hasPermission("android.permission.WAKE_LOCK"))
      localWakeLock = null;
    while (true)
    {
      return localWakeLock;
      localWakeLock = ((PowerManager)ErrorReporter.access$000().getSystemService("power")).newWakeLock(1, "ACRA wakelock");
      localWakeLock.acquire();
    }
  }

  public void run()
  {
    PowerManager.WakeLock localWakeLock = acquireWakeLock();
    try
    {
      if (this.mApprovePendingReports)
      {
        this.this$0.approvePendingReports();
        this.mCommentedReportFileName = this.mCommentedReportFileName.replace(".stacktrace", "-approved.stacktrace");
      }
      ErrorReporter.access$100(ErrorReporter.access$000(), this.mCommentedReportFileName, this.mUserComment, this.mUserEmail);
      this.this$0.checkAndSendReports(ErrorReporter.access$000(), this.mSendOnlySilentReports);
      return;
    }
    finally
    {
      if (localWakeLock != null)
        localWakeLock.release();
    }
    throw localObject;
  }

  public void setApprovePendingReports()
  {
    this.mApprovePendingReports = true;
  }

  void setUserComment(String paramString1, String paramString2)
  {
    this.mCommentedReportFileName = paramString1;
    this.mUserComment = paramString2;
  }

  void setUserEmail(String paramString1, String paramString2)
  {
    this.mCommentedReportFileName = paramString1;
    this.mUserEmail = paramString2;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.ErrorReporter.ReportsSenderWorker
 * JD-Core Version:    0.6.0
 */