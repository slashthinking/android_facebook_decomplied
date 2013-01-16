package com.facebook.orca.prefs;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.PreferenceGroup;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.orca.activity.FbPreferenceActivity;
import com.facebook.orca.common.ui.titlebar.FbTitleBar;
import com.facebook.orca.common.ui.titlebar.FbTitleBarUtil;

public class OrcaSmsMmsPreferenceActivity extends FbPreferenceActivity
  implements AnalyticsActivity
{
  private FbTitleBar a;

  private void a(PreferenceGroup paramPreferenceGroup)
  {
    b(paramPreferenceGroup);
    c(paramPreferenceGroup);
  }

  private void b(PreferenceGroup paramPreferenceGroup)
  {
    CheckBoxPreference localCheckBoxPreference = new CheckBoxPreference(this);
    localCheckBoxPreference.setKey(MessagesPrefKeys.g.a());
    localCheckBoxPreference.setTitle(2131362618);
    localCheckBoxPreference.setSummary(2131362619);
    localCheckBoxPreference.setDefaultValue(Boolean.valueOf(false));
    paramPreferenceGroup.addPreference(localCheckBoxPreference);
  }

  private void c(PreferenceGroup paramPreferenceGroup)
  {
    CheckBoxPreference localCheckBoxPreference = new CheckBoxPreference(this);
    localCheckBoxPreference.setKey(MessagesPrefKeys.i.a());
    localCheckBoxPreference.setTitle(2131362620);
    localCheckBoxPreference.setDefaultValue(Boolean.valueOf(true));
    localCheckBoxPreference.setSummary(2131362621);
    paramPreferenceGroup.addPreference(localCheckBoxPreference);
    localCheckBoxPreference.setDependency(MessagesPrefKeys.g.a());
  }

  public String a()
  {
    return "prefs_root";
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903391);
    FbTitleBarUtil.a(this);
    this.a = ((FbTitleBar)a(2131296299));
    this.a.setTitle(getString(2131362616));
    PreferenceScreen localPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
    setPreferenceScreen(localPreferenceScreen);
    a(localPreferenceScreen);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.OrcaSmsMmsPreferenceActivity
 * JD-Core Version:    0.6.0
 */