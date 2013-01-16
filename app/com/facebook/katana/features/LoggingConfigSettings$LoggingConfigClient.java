package com.facebook.katana.features;

import android.content.Context;
import com.facebook.common.json.FBJsonFactory;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.ManagedDataStore.Client;
import com.facebook.katana.binding.NetworkRequestCallback;
import com.facebook.katana.service.method.FqlGetUserServerSettings;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import java.io.IOException;

public class LoggingConfigSettings$LoggingConfigClient
  implements ManagedDataStore.Client<String, LoggingConfigSettings.ConfigValues>
{
  private LoggingConfigSettings.ConfigFactory a;

  public LoggingConfigSettings$LoggingConfigClient(LoggingConfigSettings.ConfigFactory paramConfigFactory)
  {
    this.a = paramConfigFactory;
  }

  public String a(String paramString)
  {
    return paramString;
  }

  public void a(Context paramContext, String paramString, NetworkRequestCallback<String, LoggingConfigSettings.ConfigValues> paramNetworkRequestCallback)
  {
    LoggingConfigSettings.LoggingConfigClient.1 local1 = new LoggingConfigSettings.LoggingConfigClient.1(this, paramNetworkRequestCallback);
    AppSession localAppSession = AppSession.b(paramContext, false);
    if (localAppSession == null);
    while (true)
    {
      return;
      FqlGetUserServerSettings.a(localAppSession, paramContext, "android_log_config", paramString, local1);
    }
  }

  public boolean a(String paramString, LoggingConfigSettings.ConfigValues paramConfigValues)
  {
    return true;
  }

  public int b(String paramString, LoggingConfigSettings.ConfigValues paramConfigValues)
  {
    return 43200;
  }

  public LoggingConfigSettings.ConfigValues b(String paramString)
  {
    try
    {
      JsonParser localJsonParser = FBJsonFactory.a.createJsonParser(paramString);
      LoggingConfigSettings.ConfigValues localConfigValues2 = this.a.a(localJsonParser);
      localConfigValues1 = localConfigValues2;
      return localConfigValues1;
    }
    catch (IOException localIOException)
    {
      while (true)
        localConfigValues1 = null;
    }
    catch (JsonParseException localJsonParseException)
    {
      while (true)
        LoggingConfigSettings.ConfigValues localConfigValues1 = null;
    }
  }

  public int c(String paramString, LoggingConfigSettings.ConfigValues paramConfigValues)
  {
    return b(paramString, paramConfigValues);
  }

  public String getDiskKeyPrefix()
  {
    return LoggingConfigSettings.class.getSimpleName();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.LoggingConfigSettings.LoggingConfigClient
 * JD-Core Version:    0.6.0
 */