package com.facebook.orca.preference;

import android.content.Context;
import android.preference.EditTextPreference;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.prefs.PrefKey;

public class OrcaEditTextPreference extends EditTextPreference
{
  private final OrcaSharedPreferences a;
  private PrefKey b;

  public OrcaEditTextPreference(Context paramContext)
  {
    super(paramContext);
    this.a = ((OrcaSharedPreferences)FbInjector.a(paramContext).a(OrcaSharedPreferences.class));
  }

  protected void onSetInitialValue(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean);
    for (String str = this.a.a(this.b, (String)paramObject); ; str = (String)paramObject)
    {
      setText(str);
      return;
    }
  }

  @Deprecated
  public void setKey(String paramString)
  {
    throw new IllegalStateException("setKey(String key) should not be called");
  }

  public void setText(String paramString)
  {
    super.setText(paramString);
    OrcaSharedPreferences.Editor localEditor = this.a.b();
    localEditor.a(this.b, paramString);
    localEditor.a();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.preference.OrcaEditTextPreference
 * JD-Core Version:    0.6.2
 */