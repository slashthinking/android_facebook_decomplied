package com.facebook.orca.prefs;

import android.os.Bundle;
import android.preference.PreferenceGroup;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.orca.activity.FbPreferenceActivity;
import com.facebook.orca.common.ui.titlebar.FbTitleBar;
import com.facebook.orca.common.ui.titlebar.FbTitleBarUtil;

public class OrcaTesterPreferenceActivity extends FbPreferenceActivity
  implements AnalyticsActivity
{
  private FbTitleBar a;

  private void a(PreferenceGroup paramPreferenceGroup)
  {
    b(paramPreferenceGroup);
  }

  private void b(PreferenceGroup paramPreferenceGroup)
  {
    ListPreferenceWithSummaryValue localListPreferenceWithSummaryValue = new ListPreferenceWithSummaryValue(this);
    localListPreferenceWithSummaryValue.setKey(SharedPrefKeys.i.a());
    localListPreferenceWithSummaryValue.setTitle(2131362752);
    localListPreferenceWithSummaryValue.setDefaultValue("-1");
    localListPreferenceWithSummaryValue.setEntries(2131689472);
    localListPreferenceWithSummaryValue.setEntryValues(2131689473);
    paramPreferenceGroup.addPreference(localListPreferenceWithSummaryValue);
  }

  public String a()
  {
    return "prefs_tester";
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903391);
    FbTitleBarUtil.a(this);
    this.a = ((FbTitleBar)a(2131296299));
    this.a.setTitle("Tester");
    PreferenceScreen localPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
    setPreferenceScreen(localPreferenceScreen);
    a(localPreferenceScreen);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.OrcaTesterPreferenceActivity
 * JD-Core Version:    0.6.0
 */