package com.facebook.katana.util.logging;

import android.content.Context;
import com.facebook.katana.features.LoggingConfigSettings;

public class MobileEventLogger$MobileEventLogConfig
{
  static String a = "ACTION_LOG";
  static long b = -1L;
  static long c = -1L;
  static MobileEventLogger.MobileEventLogConfig.Factory d = new MobileEventLogger.MobileEventLogConfig.Factory(null);

  public static MobileEventLogger.MobileEventLogConfig.Settings a(Context paramContext)
  {
    return (MobileEventLogger.MobileEventLogConfig.Settings)LoggingConfigSettings.a(paramContext, d);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.logging.MobileEventLogger.MobileEventLogConfig
 * JD-Core Version:    0.6.0
 */