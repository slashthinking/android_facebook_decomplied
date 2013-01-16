package com.facebook.orca.prefs;

import java.util.SortedSet;

public abstract interface OrcaSharedPreferences
{
  public abstract int a(PrefKey paramPrefKey, int paramInt);

  public abstract long a(PrefKey paramPrefKey, long paramLong);

  public abstract String a(PrefKey paramPrefKey, String paramString);

  public abstract void a(OrcaSharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener);

  public abstract void a(Runnable paramRunnable);

  public abstract boolean a();

  public abstract boolean a(PrefKey paramPrefKey);

  public abstract boolean a(PrefKey paramPrefKey, boolean paramBoolean);

  public abstract OrcaSharedPreferences.Editor b();

  public abstract SortedSet<PrefKey> b(PrefKey paramPrefKey);

  public abstract void b(OrcaSharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.OrcaSharedPreferences
 * JD-Core Version:    0.6.0
 */