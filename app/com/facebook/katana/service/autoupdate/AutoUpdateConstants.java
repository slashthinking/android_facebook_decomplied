package com.facebook.katana.service.autoupdate;

import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.prefs.SharedPrefKeys;

public class AutoUpdateConstants
{
  public static final PrefKey a = (PrefKey)SharedPrefKeys.a.c("autoupdate/");
  public static final PrefKey b = (PrefKey)a.c("scheduled_time");
  public static final PrefKey c = (PrefKey)a.c("min_build");
  public static final PrefKey d = (PrefKey)a.c("new_build");
  public static final PrefKey e = (PrefKey)a.c("new_build_url");
  public static final PrefKey f = (PrefKey)a.c("downloaded");
  public static final PrefKey g = (PrefKey)a.c("local_file");
  public static final PrefKey h = (PrefKey)a.c("hard_nag");
  public static final PrefKey i = (PrefKey)a.c("show_nag");
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.autoupdate.AutoUpdateConstants
 * JD-Core Version:    0.6.0
 */