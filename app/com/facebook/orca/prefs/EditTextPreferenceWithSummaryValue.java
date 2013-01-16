package com.facebook.orca.prefs;

import android.content.Context;
import android.preference.EditTextPreference;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.inject.FbInjector;

public class EditTextPreferenceWithSummaryValue extends EditTextPreference
{
  private OrcaSharedPreferences.OnSharedPreferenceChangeListener a;
  private CharSequence b;

  public EditTextPreferenceWithSummaryValue(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public EditTextPreferenceWithSummaryValue(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public EditTextPreferenceWithSummaryValue(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private void a()
  {
    String str = getText();
    if (StringUtil.a(str))
      setSummary(this.b);
    while (true)
    {
      return;
      setSummary(str);
    }
  }

  private void a(Context paramContext)
  {
    OrcaSharedPreferences localOrcaSharedPreferences = (OrcaSharedPreferences)FbInjector.a(paramContext).a(OrcaSharedPreferences.class);
    this.a = new EditTextPreferenceWithSummaryValue.1(this, getKey());
    localOrcaSharedPreferences.a(this.a);
    this.b = getSummary();
  }

  public void a(CharSequence paramCharSequence)
  {
    this.b = paramCharSequence;
    a();
  }

  protected void onBindView(View paramView)
  {
    a();
    super.onBindView(paramView);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.EditTextPreferenceWithSummaryValue
 * JD-Core Version:    0.6.0
 */