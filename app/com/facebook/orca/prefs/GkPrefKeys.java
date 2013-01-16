package com.facebook.orca.prefs;

import android.net.Uri;

public class GkPrefKeys
{
  public static final PrefKey a = (PrefKey)SharedPrefKeys.c.c("gk/");
  public static final PrefKey b = (PrefKey)a.c("version");
  public static final PrefKey c = (PrefKey)a.c("values/");
  public static final PrefKey d = (PrefKey)a.c("last_fetch_time_ms");

  public static PrefKey a(String paramString)
  {
    return (PrefKey)c.c(Uri.encode(paramString));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.GkPrefKeys
 * JD-Core Version:    0.6.0
 */