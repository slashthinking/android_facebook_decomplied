package org.acra.sender;

import android.net.Uri;
import android.util.Log;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.acra.ACRA;
import org.acra.CrashReportData;
import org.acra.ReportField;
import org.acra.reporter.ReportsCrashes;
import org.acra.util.HttpUtils;

public class GoogleFormSender
  implements ReportSender
{
  private Uri mFormUri = null;

  public GoogleFormSender(String paramString)
  {
    this.mFormUri = Uri.parse("https://spreadsheets.google.com/formResponse?formkey=" + paramString + "&amp;ifq");
  }

  private Map<String, String> remap(Map<ReportField, String> paramMap)
  {
    HashMap localHashMap = new HashMap();
    ReportField[] arrayOfReportField1 = ACRA.getConfig().customReportContent();
    if (arrayOfReportField1.length == 0);
    for (ReportField[] arrayOfReportField2 = ACRA.DEFAULT_REPORT_FIELDS; ; arrayOfReportField2 = arrayOfReportField1)
    {
      int i = arrayOfReportField2.length;
      int j = 0;
      int k = 0;
      if (j < i)
      {
        ReportField localReportField = arrayOfReportField2[j];
        switch (GoogleFormSender.1.$SwitchMap$org$acra$ReportField[((ReportField)localReportField).ordinal()])
        {
        default:
          localHashMap.put("entry." + k + ".single", paramMap.get(localReportField));
        case 1:
        case 2:
        }
        while (true)
        {
          int m = k + 1;
          j++;
          k = m;
          break;
          localHashMap.put("entry." + k + ".single", "'" + (String)paramMap.get(localReportField));
          continue;
          localHashMap.put("entry." + k + ".single", "'" + (String)paramMap.get(localReportField));
        }
      }
      return localHashMap;
    }
  }

  public void send(CrashReportData paramCrashReportData)
  {
    Map localMap = remap(paramCrashReportData);
    localMap.put("pageNumber", "0");
    localMap.put("backupCache", "");
    localMap.put("submit", "Envoyer");
    try
    {
      URL localURL = new URL(this.mFormUri.toString());
      Log.d(ACRA.LOG_TAG, "Sending report " + (String)paramCrashReportData.get(ReportField.REPORT_ID));
      Log.d(ACRA.LOG_TAG, "Connect to " + localURL);
      HttpUtils.doPost(localMap, localURL);
      return;
    }
    catch (IOException localIOException)
    {
    }
    throw new ReportSenderException("Error while sending report to Google Form.", localIOException);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.sender.GoogleFormSender
 * JD-Core Version:    0.6.0
 */