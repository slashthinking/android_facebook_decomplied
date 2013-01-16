package com.facebook.appcenter.cache;

import com.facebook.appcenter.model.AppInfo.AppServerState;
import com.google.common.collect.Maps;
import java.util.Map;

public class AppServerStateCache
{
  private final Map<String, AppInfo.AppServerState> a = Maps.a();

  public AppInfo.AppServerState a(String paramString)
  {
    monitorenter;
    try
    {
      AppInfo.AppServerState localAppServerState = (AppInfo.AppServerState)this.a.get(paramString);
      monitorexit;
      return localAppServerState;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void a(String paramString, AppInfo.AppServerState paramAppServerState)
  {
    monitorenter;
    try
    {
      this.a.put(paramString, paramAppServerState);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.cache.AppServerStateCache
 * JD-Core Version:    0.6.0
 */