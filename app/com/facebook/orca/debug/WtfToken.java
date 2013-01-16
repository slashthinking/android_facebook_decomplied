package com.facebook.orca.debug;

import com.facebook.orca.common.util.RateLimiter;
import com.facebook.orca.common.util.SystemClock;

public final class WtfToken
{
  private final RateLimiter a = new RateLimiter(SystemClock.b(), 2, 3600000L);

  public boolean a()
  {
    return this.a.a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.debug.WtfToken
 * JD-Core Version:    0.6.0
 */