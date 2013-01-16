package org.acra;

public enum ReportingInteractionMode
{
  static
  {
    NOTIFICATION = new ReportingInteractionMode("NOTIFICATION", 1);
    TOAST = new ReportingInteractionMode("TOAST", 2);
    ReportingInteractionMode[] arrayOfReportingInteractionMode = new ReportingInteractionMode[3];
    arrayOfReportingInteractionMode[0] = SILENT;
    arrayOfReportingInteractionMode[1] = NOTIFICATION;
    arrayOfReportingInteractionMode[2] = TOAST;
    $VALUES = arrayOfReportingInteractionMode;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.ReportingInteractionMode
 * JD-Core Version:    0.6.0
 */