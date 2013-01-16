package com.facebook.analytics;

import android.content.Context;
import com.facebook.analytics.util.LoggerUtils;
import com.google.common.base.Preconditions;
import java.util.Map;

public class InteractionLogger
{
  private AnalyticsLogger a;

  public InteractionLogger(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    this.a = LoggerUtils.a(paramContext);
  }

  private static HoneyClientEvent c(String paramString)
  {
    return new HoneyClientEvent("hide_module").b("dest_module", paramString);
  }

  private static HoneyClientEvent c(String paramString, boolean paramBoolean)
  {
    return new HoneyClientEvent("show_module").b("dest_module", paramString).a("is_modal", paramBoolean);
  }

  private boolean c()
  {
    if (this.a != null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public HoneyClientEvent a(InteractionLogger.ContentFlags paramContentFlags, String paramString1, String paramString2, long paramLong)
  {
    HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent("content").a("flags", paramContentFlags.getValue());
    localHoneyClientEvent.a(paramLong);
    if (paramString1 != null)
      localHoneyClientEvent.d(paramString1);
    if (paramString2 != null)
      localHoneyClientEvent.h(paramString2);
    return localHoneyClientEvent;
  }

  public void a()
  {
    this.a.d();
  }

  public void a(HoneyAnalyticsEvent paramHoneyAnalyticsEvent)
  {
    if (c())
      this.a.b(paramHoneyAnalyticsEvent);
  }

  public void a(InteractionLogger.ContentFlags paramContentFlags, String paramString1, String paramString2)
  {
    b(a(paramContentFlags, paramString1, paramString2, -1L));
  }

  public void a(String paramString)
  {
    a(c(paramString));
  }

  public void a(String paramString1, String paramString2)
  {
    a(paramString1, "button", paramString2);
  }

  public void a(String paramString1, String paramString2, String paramString3)
  {
    a("click", paramString1, paramString2, paramString3);
  }

  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent(paramString1).f(paramString2).e(paramString3);
    if (paramString4 != null)
      localHoneyClientEvent.d(paramString4);
    b(localHoneyClientEvent);
  }

  public void a(String paramString, boolean paramBoolean)
  {
    a(c(paramString, paramBoolean));
  }

  public void a(Map<String, String> paramMap)
  {
    this.a.a(paramMap);
  }

  public void b()
  {
    this.a.c();
  }

  public void b(HoneyAnalyticsEvent paramHoneyAnalyticsEvent)
  {
    if (c())
      this.a.a(paramHoneyAnalyticsEvent);
  }

  public void b(String paramString)
  {
    b(c(paramString));
  }

  public void b(String paramString, boolean paramBoolean)
  {
    b(c(paramString, paramBoolean));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.InteractionLogger
 * JD-Core Version:    0.6.2
 */