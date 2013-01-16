package com.facebook.katana.features;

import android.content.Context;
import com.facebook.katana.binding.ManagedDataStore;
import com.facebook.katana.binding.ManagedDataStore.Mode;
import java.util.HashMap;
import java.util.Map;

public class LoggingConfigSettings
{
  private static Map<String, ManagedDataStore<String, LoggingConfigSettings.ConfigValues>> a = new HashMap();

  private static ManagedDataStore<String, LoggingConfigSettings.ConfigValues> a(LoggingConfigSettings.ConfigFactory paramConfigFactory, Context paramContext)
  {
    String str = paramConfigFactory.b();
    ManagedDataStore localManagedDataStore;
    if (a.containsKey(str))
      localManagedDataStore = (ManagedDataStore)a.get(str);
    while (true)
    {
      return localManagedDataStore;
      localManagedDataStore = new ManagedDataStore(new LoggingConfigSettings.LoggingConfigClient(paramConfigFactory), ManagedDataStore.Mode.SINGLE_REQUEST, paramContext);
      a.put(str, localManagedDataStore);
    }
  }

  public static LoggingConfigSettings.ConfigValues a(Context paramContext, LoggingConfigSettings.ConfigFactory paramConfigFactory)
  {
    LoggingConfigSettings.ConfigValues localConfigValues = (LoggingConfigSettings.ConfigValues)a(paramConfigFactory, paramContext).a(paramConfigFactory.b());
    if (localConfigValues == null)
      localConfigValues = paramConfigFactory.a();
    return localConfigValues;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.LoggingConfigSettings
 * JD-Core Version:    0.6.0
 */