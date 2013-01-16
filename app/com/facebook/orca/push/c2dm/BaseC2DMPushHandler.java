package com.facebook.orca.push.c2dm;

import com.facebook.analytics.ReliabilityAnalyticsLogger;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.push.PushType;

public abstract class BaseC2DMPushHandler
  implements C2DMPushHandler
{
  private static final Class<?> a = BaseC2DMPushHandler.class;
  private final ReliabilityAnalyticsLogger b;

  public BaseC2DMPushHandler(ReliabilityAnalyticsLogger paramReliabilityAnalyticsLogger)
  {
    this.b = paramReliabilityAnalyticsLogger;
  }

  public abstract void a(int paramInt);

  public abstract void a(String paramString);

  public void b(int paramInt)
  {
    Class localClass = a;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    BLog.a(localClass, "Received deleted C2DM notifications: %d", arrayOfObject);
    a(paramInt);
  }

  public void b(String paramString)
  {
    BLog.a(a, "Received C2DM notification: %s", new Object[] { paramString });
    a(paramString);
  }

  protected void c(String paramString)
  {
    this.b.a("", "", PushType.C2DM.toString(), paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.c2dm.BaseC2DMPushHandler
 * JD-Core Version:    0.6.0
 */