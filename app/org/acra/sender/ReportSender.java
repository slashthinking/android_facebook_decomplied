package org.acra.sender;

import org.acra.CrashReportData;

public abstract interface ReportSender
{
  public abstract void send(CrashReportData paramCrashReportData);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.sender.ReportSender
 * JD-Core Version:    0.6.0
 */