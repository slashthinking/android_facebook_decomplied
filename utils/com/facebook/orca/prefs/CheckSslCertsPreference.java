package com.facebook.orca.prefs;

import android.content.Context;
import android.preference.CheckBoxPreference;

public class CheckSslCertsPreference extends CheckBoxPreference
{
  public CheckSslCertsPreference(Context paramContext)
  {
    super(paramContext);
    setKey(InternalHttpPrefKeys.f.a());
    setDefaultValue(Boolean.valueOf(true));
    setTitle(2131362799);
    setSummary(2131362800);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.CheckSslCertsPreference
 * JD-Core Version:    0.6.2
 */