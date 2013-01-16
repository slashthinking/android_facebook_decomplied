package com.facebook.katana.util;

import java.util.TimeZone;

public class TimeUtils
{
  public static long a(long paramLong)
  {
    return (paramLong + TimeZone.getTimeZone("PST").getRawOffset()) / 1000L;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.TimeUtils
 * JD-Core Version:    0.6.0
 */