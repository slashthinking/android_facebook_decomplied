package com.facebook.nearby.prefs;

import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.prefs.SharedPrefKeys;

public class NearbyPrefKeys
{
  public static final PrefKey a = (PrefKey)SharedPrefKeys.a.c("nearby/");
  public static final PrefKey b = (PrefKey)a.c("nux/");
  public static final PrefKey c = (PrefKey)b.c("search_button_nux_completed");
  public static final PrefKey d = (PrefKey)b.c("restore_button_nux_completed");
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.prefs.NearbyPrefKeys
 * JD-Core Version:    0.6.0
 */