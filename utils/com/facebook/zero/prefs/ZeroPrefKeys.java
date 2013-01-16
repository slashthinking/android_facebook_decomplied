package com.facebook.zero.prefs;

import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.prefs.SharedPrefKeys;

public class ZeroPrefKeys
{
  public static final PrefKey a = (PrefKey)SharedPrefKeys.c.c("zero_rating/");
  public static final PrefKey b = (PrefKey)a.c("zero_token");
  public static final PrefKey c = (PrefKey)a.c("last_token_fetch_time_ms");
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.zero.prefs.ZeroPrefKeys
 * JD-Core Version:    0.6.2
 */