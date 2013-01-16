package com.facebook.orca.cache;

import com.facebook.orca.appconfig.AppConfig;
import com.facebook.orca.appconfig.AppConfigSerialization;
import com.facebook.orca.prefs.ConfigPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import java.io.IOException;

public class AppConfigCache
{
  private final OrcaSharedPreferences a;
  private final AppConfigSerialization b;
  private volatile AppConfig c;

  public AppConfigCache(OrcaSharedPreferences paramOrcaSharedPreferences, AppConfigSerialization paramAppConfigSerialization)
  {
    this.a = paramOrcaSharedPreferences;
    this.b = paramAppConfigSerialization;
  }

  AppConfig a()
  {
    Object localObject;
    if (this.c != null)
      localObject = this.c;
    while (true)
    {
      return localObject;
      String str = this.a.a(ConfigPrefKeys.c, null);
      localObject = null;
      if (str == null)
        continue;
      try
      {
        AppConfig localAppConfig = this.b.a(str);
        localObject = localAppConfig;
      }
      catch (IOException localIOException)
      {
        localObject = null;
      }
    }
  }

  void a(AppConfig paramAppConfig)
  {
    this.c = paramAppConfig;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.cache.AppConfigCache
 * JD-Core Version:    0.6.0
 */