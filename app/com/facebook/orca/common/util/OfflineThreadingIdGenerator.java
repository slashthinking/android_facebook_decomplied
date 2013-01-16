package com.facebook.orca.common.util;

import java.util.Random;

public class OfflineThreadingIdGenerator
{
  private Random a = new Random();

  public long a()
  {
    long l = System.currentTimeMillis();
    int i = this.a.nextInt();
    return 0xFFFFFFFF & (l << 22 | i & 0x3FFFFF);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.util.OfflineThreadingIdGenerator
 * JD-Core Version:    0.6.0
 */