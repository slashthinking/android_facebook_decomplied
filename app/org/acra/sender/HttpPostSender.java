package org.acra.sender;

import android.net.Uri;
import android.util.Log;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.acra.ACRA;
import org.acra.CrashReportData;
import org.acra.ReportField;
import org.acra.reporter.ReportsCrashes;
import org.acra.util.HttpUtils;

public class HttpPostSender
  implements ReportSender
{
  private Uri mFormUri = null;
  private Map<ReportField, String> mMapping = null;

  public HttpPostSender(String paramString, Map<ReportField, String> paramMap)
  {
    this.mFormUri = Uri.parse(paramString);
    this.mMapping = paramMap;
  }

  private Map<String, String> remap(Map<ReportField, String> paramMap)
  {
    HashMap localHashMap = new HashMap(paramMap.size());
    ReportField[] arrayOfReportField = ACRA.getConfig().customReportContent();
    if (arrayOfReportField.length == 0)
      arrayOfReportField = ACRA.DEFAULT_REPORT_FIELDS;
    int i = arrayOfReportField.length;
    int j = 0;
    if (j < i)
    {
      ReportField localReportField = arrayOfReportField[j];
      if ((this.mMapping == null) || (this.mMapping.get(localReportField) == null))
        localHashMap.put(localReportField.toString(), paramMap.get(localReportField));
      while (true)
      {
        j++;
        break;
        localHashMap.put(this.mMapping.get(localReportField), paramMap.get(localReportField));
      }
    }
    return localHashMap;
  }

  public void send(CrashReportData paramCrashReportData)
  {
    try
    {
      Map localMap = remap(paramCrashReportData);
      URL localURL = new URL(this.mFormUri.toString());
      Log.d(ACRA.LOG_TAG, "Connect to " + localURL.toString());
      HttpUtils.doPost(localMap, localURL);
      return;
    }
    catch (Exception localException)
    {
    }
    throw new ReportSenderException("Error while sending report to Http Post Form.", localException);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.sender.HttpPostSender
 * JD-Core Version:    0.6.0
 */