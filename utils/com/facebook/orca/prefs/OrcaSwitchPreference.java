package com.facebook.orca.prefs;

import android.content.Context;
import android.preference.SwitchPreference;
import com.facebook.orca.inject.FbInjector;

public class OrcaSwitchPreference extends SwitchPreference
{
  private final OrcaSharedPreferences a;
  private PrefKey b;

  public OrcaSwitchPreference(Context paramContext)
  {
    super(paramContext);
    this.a = ((OrcaSharedPreferences)FbInjector.a(paramContext).a(OrcaSharedPreferences.class));
  }

  protected void onSetInitialValue(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean);
    for (boolean bool = this.a.a(this.b, isChecked()); ; bool = ((Boolean)paramObject).booleanValue())
    {
      setChecked(bool);
      return;
    }
  }

  public void setChecked(boolean paramBoolean)
  {
    super.setChecked(paramBoolean);
    OrcaSharedPreferences.Editor localEditor = this.a.b();
    localEditor.a(this.b, paramBoolean);
    localEditor.a();
  }

  @Deprecated
  public void setKey(String paramString)
  {
    throw new IllegalStateException("setKey(String key) should not be called");
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.OrcaSwitchPreference
 * JD-Core Version:    0.6.2
 */