package com.facebook.orca.config;

import com.facebook.app.UserActivityManager;

public class PresenceAwarePlatformHttpConfig extends SimplePlatformAppHttpConfig
{
  private final UserActivityManager a;
  private final String b;
  private final String c;

  PresenceAwarePlatformHttpConfig(UserActivityManager paramUserActivityManager, String paramString1, boolean paramBoolean, String paramString2)
  {
    super(paramString1, paramBoolean);
    this.a = paramUserActivityManager;
    this.b = paramString2;
    this.c = (this.b + " FBBK/1");
  }

  public String c()
  {
    if (this.a.a());
    for (String str = this.c; ; str = this.b)
      return str;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.config.PresenceAwarePlatformHttpConfig
 * JD-Core Version:    0.6.0
 */