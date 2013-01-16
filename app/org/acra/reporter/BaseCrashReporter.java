package org.acra.reporter;

import android.app.Application;
import org.acra.ReportField;
import org.acra.ReportingInteractionMode;

public class BaseCrashReporter
  implements ReportsCrashes
{
  protected Application mApplication;

  public BaseCrashReporter(Application paramApplication)
  {
    if (paramApplication == null)
      throw new IllegalArgumentException("Application cannot be null");
    this.mApplication = paramApplication;
  }

  public String[] additionalDropBoxTags()
  {
    return new String[0];
  }

  public String[] additionalSharedPreferences()
  {
    return new String[0];
  }

  public boolean checkSSLCertsOnCrashReport()
  {
    return true;
  }

  public ReportField[] customReportContent()
  {
    return new ReportField[0];
  }

  public boolean deleteUnapprovedReportsOnApplicationStart()
  {
    return true;
  }

  public int dropboxCollectionMinutes()
  {
    return 5;
  }

  public boolean forceCloseDialogAfterToast()
  {
    return false;
  }

  public String formKey()
  {
    return "";
  }

  public String formUri()
  {
    return "";
  }

  public String formUriBasicAuthLogin()
  {
    return "ACRA-NULL-STRING";
  }

  public String formUriBasicAuthPassword()
  {
    return "ACRA-NULL-STRING";
  }

  public Application getApplication()
  {
    return this.mApplication;
  }

  public boolean includeDropBoxSystemTags()
  {
    return false;
  }

  public String[] logcatArguments()
  {
    return new String[] { "-t", "200", "-v", "time" };
  }

  public String mailTo()
  {
    return "";
  }

  public ReportingInteractionMode mode()
  {
    return ReportingInteractionMode.SILENT;
  }

  public int resDialogCommentPrompt()
  {
    return 0;
  }

  public int resDialogEmailPrompt()
  {
    return 0;
  }

  public int resDialogIcon()
  {
    return 17301543;
  }

  public int resDialogOkToast()
  {
    return 0;
  }

  public int resDialogText()
  {
    return 0;
  }

  public int resDialogTitle()
  {
    return 0;
  }

  public int resNotifIcon()
  {
    return 17301624;
  }

  public int resNotifText()
  {
    return 0;
  }

  public int resNotifTickerText()
  {
    return 0;
  }

  public int resNotifTitle()
  {
    return 0;
  }

  public int resToastText()
  {
    return 0;
  }

  public int sharedPreferencesMode()
  {
    return 0;
  }

  public String sharedPreferencesName()
  {
    return "";
  }

  public int socketTimeout()
  {
    return 3000;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.reporter.BaseCrashReporter
 * JD-Core Version:    0.6.0
 */