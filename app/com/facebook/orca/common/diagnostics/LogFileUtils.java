package com.facebook.orca.common.diagnostics;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogFileUtils
{
  private static final SimpleDateFormat a = new SimpleDateFormat("yyyyMMdd-HHmmss");

  public static File a(File paramFile, String paramString1, String paramString2, Date paramDate)
  {
    if (paramString2 != null);
    while (true)
    {
      String str = a(paramDate);
      return new File(paramFile, paramString1 + "-" + paramString2 + "-" + str);
      paramString2 = "UNKNOWN";
    }
  }

  public static String a(Date paramDate)
  {
    return a.format(paramDate);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.diagnostics.LogFileUtils
 * JD-Core Version:    0.6.0
 */