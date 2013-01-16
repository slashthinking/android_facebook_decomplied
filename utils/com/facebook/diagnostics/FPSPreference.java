package com.facebook.diagnostics;

import android.content.Context;
import com.facebook.orca.prefs.OrcaCheckBoxPreference;
import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.prefs.SharedPrefKeys;

public class FPSPreference extends OrcaCheckBoxPreference
{
  public FPSPreference(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    setKey(SharedPrefKeys.o.a());
    setTitle(2131362207);
    setSummary(2131362208);
    setDefaultValue(Boolean.valueOf(paramBoolean));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.diagnostics.FPSPreference
 * JD-Core Version:    0.6.2
 */