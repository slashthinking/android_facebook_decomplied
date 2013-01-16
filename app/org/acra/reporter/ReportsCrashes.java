package org.acra.reporter;

import android.app.Application;
import org.acra.ReportField;
import org.acra.ReportingInteractionMode;

public abstract interface ReportsCrashes
{
  public abstract String[] additionalDropBoxTags();

  public abstract String[] additionalSharedPreferences();

  public abstract boolean checkSSLCertsOnCrashReport();

  public abstract ReportField[] customReportContent();

  public abstract boolean deleteUnapprovedReportsOnApplicationStart();

  public abstract int dropboxCollectionMinutes();

  public abstract boolean forceCloseDialogAfterToast();

  public abstract String formKey();

  public abstract String formUri();

  public abstract String formUriBasicAuthLogin();

  public abstract String formUriBasicAuthPassword();

  public abstract Application getApplication();

  public abstract boolean includeDropBoxSystemTags();

  public abstract String[] logcatArguments();

  public abstract String mailTo();

  public abstract ReportingInteractionMode mode();

  public abstract int resDialogCommentPrompt();

  public abstract int resDialogEmailPrompt();

  public abstract int resDialogIcon();

  public abstract int resDialogOkToast();

  public abstract int resDialogText();

  public abstract int resDialogTitle();

  public abstract int resNotifIcon();

  public abstract int resNotifText();

  public abstract int resNotifTickerText();

  public abstract int resNotifTitle();

  public abstract int resToastText();

  public abstract int sharedPreferencesMode();

  public abstract String sharedPreferencesName();

  public abstract int socketTimeout();
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.reporter.ReportsCrashes
 * JD-Core Version:    0.6.0
 */