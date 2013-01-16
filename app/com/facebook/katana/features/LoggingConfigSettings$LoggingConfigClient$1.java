package com.facebook.katana.features;

import android.content.Context;
import com.facebook.katana.binding.NetworkRequestCallback;
import com.facebook.katana.util.TraceLogger;

class LoggingConfigSettings$LoggingConfigClient$1
  implements NetworkRequestCallback<String, String>
{
  public void a(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    LoggingConfigSettings.ConfigValues localConfigValues = null;
    if (paramBoolean)
      localConfigValues = this.b.b(paramString3);
    this.a.a(paramContext, paramBoolean, paramString1, paramString3, localConfigValues);
  }

  public TraceLogger b()
  {
    return this.a.b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.LoggingConfigSettings.LoggingConfigClient.1
 * JD-Core Version:    0.6.0
 */