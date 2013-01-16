package com.facebook.orca.prefs;

import android.content.Context;
import android.preference.ListPreference;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.orca.inject.FbInjector;

public class ListPreferenceWithSummaryValue extends ListPreference
{
  private OrcaSharedPreferences.OnSharedPreferenceChangeListener a;

  public ListPreferenceWithSummaryValue(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public ListPreferenceWithSummaryValue(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  private void a()
  {
    int i = findIndexOfValue(getValue());
    if (i == -1)
      i = 0;
    setSummary(getEntries()[i]);
  }

  private void a(Context paramContext)
  {
    OrcaSharedPreferences localOrcaSharedPreferences = (OrcaSharedPreferences)FbInjector.a(paramContext).a(OrcaSharedPreferences.class);
    this.a = new ListPreferenceWithSummaryValue.1(this, getKey());
    localOrcaSharedPreferences.a(this.a);
  }

  protected void onBindView(View paramView)
  {
    a();
    super.onBindView(paramView);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.ListPreferenceWithSummaryValue
 * JD-Core Version:    0.6.0
 */