package com.facebook.orca.prefs;

import android.content.Context;
import android.preference.ListPreference;
import com.facebook.orca.inject.FbInjector;
import com.google.common.base.Objects;

public class OrcaListPreference extends ListPreference
{
  private final OrcaSharedPreferences a;

  public OrcaListPreference(Context paramContext)
  {
    super(paramContext);
    this.a = ((OrcaSharedPreferences)FbInjector.a(paramContext).a(OrcaSharedPreferences.class));
  }

  public void a(PrefKey paramPrefKey)
  {
    setKey(paramPrefKey.a());
  }

  protected String getPersistedString(String paramString)
  {
    return this.a.a(new PrefKey(getKey()), paramString);
  }

  protected boolean persistString(String paramString)
  {
    super.persistString("");
    if (!Objects.equal(paramString, getPersistedString(null)))
    {
      OrcaSharedPreferences.Editor localEditor = this.a.b();
      localEditor.a(new PrefKey(getKey()), paramString);
      localEditor.a();
    }
    return true;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.OrcaListPreference
 * JD-Core Version:    0.6.2
 */