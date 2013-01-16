package com.facebook.diagnostics;

import android.content.Context;
import com.facebook.orca.prefs.OrcaCheckBoxPreference;
import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.prefs.SharedPrefKeys;

public class FPSLoggingPreference extends OrcaCheckBoxPreference
{
  public FPSLoggingPreference(Context paramContext)
  {
    super(paramContext);
    setKey(SharedPrefKeys.p.a());
    setTitle(2131362209);
    setDefaultValue(Boolean.valueOf(false));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.diagnostics.FPSLoggingPreference
 * JD-Core Version:    0.6.2
 */