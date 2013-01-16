package com.facebook.orca.prefs;

import android.content.Context;
import android.preference.CheckBoxPreference;
import com.facebook.orca.inject.FbInjector;

public class OrcaCheckBoxPreference extends CheckBoxPreference
{
  private final OrcaSharedPreferences a;

  public OrcaCheckBoxPreference(Context paramContext)
  {
    super(paramContext);
    this.a = ((OrcaSharedPreferences)FbInjector.a(paramContext).a(OrcaSharedPreferences.class));
  }

  public void a(PrefKey paramPrefKey)
  {
    setKey(paramPrefKey.a());
  }

  protected boolean getPersistedBoolean(boolean paramBoolean)
  {
    return this.a.a(new PrefKey(getKey()), paramBoolean);
  }

  protected boolean persistBoolean(boolean paramBoolean)
  {
    super.persistBoolean(false);
    boolean bool = false;
    if (!paramBoolean)
      bool = true;
    if (paramBoolean != getPersistedBoolean(bool))
    {
      OrcaSharedPreferences.Editor localEditor = this.a.b();
      localEditor.a(new PrefKey(getKey()), paramBoolean);
      localEditor.a();
    }
    return true;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.OrcaCheckBoxPreference
 * JD-Core Version:    0.6.2
 */