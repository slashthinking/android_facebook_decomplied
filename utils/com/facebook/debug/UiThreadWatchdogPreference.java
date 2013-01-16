package com.facebook.debug;

import android.content.Context;
import com.facebook.orca.prefs.OrcaCheckBoxPreference;
import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.prefs.SharedPrefKeys;

public class UiThreadWatchdogPreference extends OrcaCheckBoxPreference
{
  public UiThreadWatchdogPreference(Context paramContext)
  {
    super(paramContext);
    setKey(SharedPrefKeys.q.a());
    setTitle(2131362210);
    setSummary(2131362211);
    setDefaultValue(Boolean.valueOf(false));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.debug.UiThreadWatchdogPreference
 * JD-Core Version:    0.6.2
 */