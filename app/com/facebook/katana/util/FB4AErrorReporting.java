package com.facebook.katana.util;

import android.content.Context;
import android.provider.Settings.Secure;
import com.facebook.common.util.ErrorReporting;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookSessionInfo;

public class FB4AErrorReporting
{
  public static void a()
  {
    ErrorReporting.b("uid");
  }

  public static void a(Context paramContext)
  {
    ErrorReporting.a(Constants.URL.m(paramContext));
  }

  public static void a(Context paramContext, String paramString)
  {
    AppSession localAppSession = AppSession.b(paramContext, false);
    if ((localAppSession != null) && (localAppSession.b().userId != -1L))
    {
      ErrorReporting.b("uid", String.valueOf(localAppSession.b().userId));
      if (StringUtils.c(paramString))
        break label75;
      ErrorReporting.b("marauder_device_id", paramString);
    }
    while (true)
    {
      ErrorReporting.b("android_id", Settings.Secure.getString(paramContext.getContentResolver(), "android_id"));
      return;
      ErrorReporting.b("uid");
      break;
      label75: ErrorReporting.b("marauder_device_id");
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.FB4AErrorReporting
 * JD-Core Version:    0.6.0
 */