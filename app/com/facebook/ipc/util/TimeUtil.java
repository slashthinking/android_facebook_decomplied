package com.facebook.ipc.util;

import java.util.TimeZone;

public class TimeUtil
{
  public static long a(long paramLong)
  {
    return 1000L * paramLong - TimeZone.getTimeZone("PST").getRawOffset();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.util.TimeUtil
 * JD-Core Version:    0.6.0
 */