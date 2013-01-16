package com.facebook.katana;

import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.dalvik.DalvikReplaceBuffer;
import com.facebook.orca.app.AppInitLock.Listener;
import com.facebook.orca.inject.FbInjector;

class FacebookApplicationImpl$1 extends AppInitLock.Listener
{
  public void a()
  {
    FacebookApplicationImpl.a(this.d, this.a, this.b);
    if (DalvikReplaceBuffer.a())
    {
      HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent("dalvik_hack_failure");
      localHoneyClientEvent.d("app");
      localHoneyClientEvent.b("failure_string", DalvikReplaceBuffer.b());
      ((AnalyticsLogger)this.c.a(AnalyticsLogger.class)).b(localHoneyClientEvent);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.FacebookApplicationImpl.1
 * JD-Core Version:    0.6.0
 */