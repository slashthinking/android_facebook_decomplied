package com.facebook.common.util;

import android.content.Context;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.inject.FbInjector;
import java.util.UUID;

public class ToastLogger
{
  private CharSequence a;
  private String b;
  private String c;
  private String d;
  private AnalyticsLogger e;

  public ToastLogger(Context paramContext, CharSequence paramCharSequence, String paramString1, String paramString2, String paramString3)
  {
    this.a = paramCharSequence.toString();
    this.d = paramString2;
    this.c = paramString1;
    this.b = paramString3;
    this.e = ((AnalyticsLogger)FbInjector.a(paramContext).a(AnalyticsLogger.class));
  }

  public void a()
  {
    HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent("error");
    localHoneyClientEvent.b("message", this.a.toString());
    localHoneyClientEvent.h(UUID.randomUUID().toString());
    if (this.d != null)
      localHoneyClientEvent.f(this.d);
    if (this.c != null)
      localHoneyClientEvent.e(this.c);
    if (this.b != null)
      localHoneyClientEvent.d(this.b);
    if (this.e != null)
      this.e.a(localHoneyClientEvent);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.common.util.ToastLogger
 * JD-Core Version:    0.6.2
 */