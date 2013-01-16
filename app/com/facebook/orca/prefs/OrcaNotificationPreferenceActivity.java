package com.facebook.orca.prefs;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceGroup;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.preference.RingtonePreference;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.orca.activity.FbPreferenceActivity;
import com.facebook.orca.common.ui.titlebar.FbTitleBar;
import com.facebook.orca.common.ui.titlebar.FbTitleBarUtil;
import com.facebook.orca.inject.FbInjector;

public class OrcaNotificationPreferenceActivity extends FbPreferenceActivity
  implements AnalyticsActivity
{
  private FbTitleBar a;
  private AnalyticsLogger b;

  private void a(Preference paramPreference)
  {
    paramPreference.setOnPreferenceChangeListener(new OrcaNotificationPreferenceActivity.1(this));
  }

  private void a(PreferenceGroup paramPreferenceGroup)
  {
    b(paramPreferenceGroup);
    c(paramPreferenceGroup);
    d(paramPreferenceGroup);
    e(paramPreferenceGroup);
    f(paramPreferenceGroup);
    for (int i = 0; i < paramPreferenceGroup.getPreferenceCount(); i++)
      a(paramPreferenceGroup.getPreference(i));
  }

  private void b(PreferenceGroup paramPreferenceGroup)
  {
    NotificationEnabledPreference localNotificationEnabledPreference = new NotificationEnabledPreference(this);
    localNotificationEnabledPreference.setTitle(2131362589);
    paramPreferenceGroup.addPreference(localNotificationEnabledPreference);
  }

  private void c(PreferenceGroup paramPreferenceGroup)
  {
    CheckBoxPreference localCheckBoxPreference = new CheckBoxPreference(this);
    localCheckBoxPreference.setKey(MessagesPrefKeys.n.a());
    localCheckBoxPreference.setTitle(2131362590);
    localCheckBoxPreference.setDefaultValue(Boolean.valueOf(true));
    paramPreferenceGroup.addPreference(localCheckBoxPreference);
    localCheckBoxPreference.setDependency(MessagesPrefKeys.l.a());
  }

  private void d(PreferenceGroup paramPreferenceGroup)
  {
    RingtonePreference localRingtonePreference = new RingtonePreference(this);
    localRingtonePreference.setKey(MessagesPrefKeys.q.a());
    localRingtonePreference.setTitle(2131362593);
    localRingtonePreference.setRingtoneType(2);
    localRingtonePreference.setDefaultValue("content://settings/system/notification_sound");
    localRingtonePreference.setShowDefault(true);
    paramPreferenceGroup.addPreference(localRingtonePreference);
    localRingtonePreference.setDependency(MessagesPrefKeys.l.a());
  }

  private void e(PreferenceGroup paramPreferenceGroup)
  {
    CheckBoxPreference localCheckBoxPreference = new CheckBoxPreference(this);
    localCheckBoxPreference.setKey(MessagesPrefKeys.o.a());
    localCheckBoxPreference.setTitle(2131362591);
    localCheckBoxPreference.setDefaultValue(Boolean.valueOf(true));
    paramPreferenceGroup.addPreference(localCheckBoxPreference);
    localCheckBoxPreference.setDependency(MessagesPrefKeys.l.a());
  }

  private void f(PreferenceGroup paramPreferenceGroup)
  {
    CheckBoxPreference localCheckBoxPreference = new CheckBoxPreference(this);
    localCheckBoxPreference.setKey(MessagesPrefKeys.p.a());
    localCheckBoxPreference.setTitle(2131362592);
    localCheckBoxPreference.setDefaultValue(Boolean.valueOf(true));
    paramPreferenceGroup.addPreference(localCheckBoxPreference);
    localCheckBoxPreference.setDependency(MessagesPrefKeys.l.a());
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
    this.a.setTitle(getString(2131362584));
    this.b = ((AnalyticsLogger)b().a(AnalyticsLogger.class));
    PreferenceScreen localPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
    setPreferenceScreen(localPreferenceScreen);
    a(localPreferenceScreen);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.OrcaNotificationPreferenceActivity
 * JD-Core Version:    0.6.0
 */