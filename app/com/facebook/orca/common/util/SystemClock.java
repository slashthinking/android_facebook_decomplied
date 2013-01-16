package com.facebook.orca.common.util;

public class SystemClock
  implements Clock
{
  private static final SystemClock a = new SystemClock();

  public static SystemClock b()
  {
    return a;
  }

  public long a()
  {
    return System.currentTimeMillis();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.util.SystemClock
 * JD-Core Version:    0.6.0
 */