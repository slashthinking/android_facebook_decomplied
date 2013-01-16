package com.facebook.orca.prefs;

public class ConfigPrefKeys
{
  public static final PrefKey a = (PrefKey)SharedPrefKeys.c.c("app_info/");
  public static final PrefKey b = (PrefKey)a.c("last_fetch_time_ms");
  public static final PrefKey c = (PrefKey)a.c("app_info_data");
  public static final PrefKey d = (PrefKey)SharedPrefKeys.c.c("rollout/");
  public static final PrefKey e = (PrefKey)d.c("version");
  public static final PrefKey f = (PrefKey)d.c("values/");

  public static PrefKey a(String paramString)
  {
    return (PrefKey)f.c(paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.ConfigPrefKeys
 * JD-Core Version:    0.6.0
 */