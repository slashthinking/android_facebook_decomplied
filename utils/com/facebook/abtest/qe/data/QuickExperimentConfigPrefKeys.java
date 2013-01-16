package com.facebook.abtest.qe.data;

import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.prefs.SharedPrefKeys;

public class QuickExperimentConfigPrefKeys
{
  public static final PrefKey a = (PrefKey)SharedPrefKeys.c.c("qe/");
  public static final PrefKey b = (PrefKey)a.c("last_fetch_time_ms");
  public static final PrefKey c = (PrefKey)a.c("last_fetch_locale");
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.abtest.qe.data.QuickExperimentConfigPrefKeys
 * JD-Core Version:    0.6.2
 */