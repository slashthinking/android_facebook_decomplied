package org.acra.sender;

import android.content.Context;
import android.content.Intent;
import org.acra.ACRA;
import org.acra.CrashReportData;
import org.acra.ReportField;
import org.acra.reporter.ReportsCrashes;

public class EmailIntentSender
  implements ReportSender
{
  Context mContext = null;

  public EmailIntentSender(Context paramContext)
  {
    this.mContext = paramContext;
  }

  private String buildBody(CrashReportData paramCrashReportData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    ReportField[] arrayOfReportField1 = ACRA.getConfig().customReportContent();
    if (arrayOfReportField1.length == 0);
    for (ReportField[] arrayOfReportField2 = ACRA.DEFAULT_MAIL_REPORT_FIELDS; ; arrayOfReportField2 = arrayOfReportField1)
    {
      int i = arrayOfReportField2.length;
      for (int j = 0; j < i; j++)
      {
        ReportField localReportField = arrayOfReportField2[j];
        localStringBuilder.append(localReportField.toString()).append("=");
        localStringBuilder.append((String)paramCrashReportData.get(localReportField));
        localStringBuilder.append('\n');
      }
      return localStringBuilder.toString();
    }
  }

  public void send(CrashReportData paramCrashReportData)
  {
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.addFlags(268435456);
    localIntent.setType("text/plain");
    String str1 = (String)paramCrashReportData.get(ReportField.PACKAGE_NAME) + " Crash Report";
    String str2 = buildBody(paramCrashReportData);
    localIntent.putExtra("android.intent.extra.SUBJECT", str1);
    localIntent.putExtra("android.intent.extra.TEXT", str2);
    String[] arrayOfString = new String[1];
    arrayOfString[0] = ACRA.getConfig().mailTo();
    localIntent.putExtra("android.intent.extra.EMAIL", arrayOfString);
    this.mContext.startActivity(localIntent);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.sender.EmailIntentSender
 * JD-Core Version:    0.6.0
 */