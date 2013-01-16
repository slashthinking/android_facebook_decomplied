package com.facebook.orca.prefs;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceGroup;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.activity.FbPreferenceActivity;
import com.facebook.orca.annotations.IsClientSmsPermitted;
import com.facebook.orca.annotations.IsContactsUploadPermitted;
import com.facebook.orca.annotations.IsInternalPrefsEnabled;
import com.facebook.orca.annotations.IsPartialAccount;
import com.facebook.orca.annotations.IsPartialUpgradeEnabled;
import com.facebook.orca.annotations.IsTesterPrefsEnabled;
import com.facebook.orca.app.IntendedAudience;
import com.facebook.orca.app.OrcaAppType;
import com.facebook.orca.common.ui.titlebar.FbTitleBar;
import com.facebook.orca.common.ui.titlebar.FbTitleBarUtil;
import com.facebook.orca.inject.FbInjector;
import java.util.UUID;

public class OrcaRootPreferenceActivity extends FbPreferenceActivity
  implements AnalyticsActivity
{
  private FbTitleBar a;
  private PackageInfo b;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private OrcaAppType i;
  private AnalyticsLogger j;

  private void a(PreferenceGroup paramPreferenceGroup)
  {
    b(paramPreferenceGroup);
    c(paramPreferenceGroup);
    d(paramPreferenceGroup);
    f(paramPreferenceGroup);
    e(paramPreferenceGroup);
    g(paramPreferenceGroup);
    h(paramPreferenceGroup);
    i(paramPreferenceGroup);
    j(paramPreferenceGroup);
    k(paramPreferenceGroup);
  }

  private void b(PreferenceGroup paramPreferenceGroup)
  {
    PreferenceScreen localPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
    localPreferenceScreen.setTitle(2131362585);
    localPreferenceScreen.setIntent(new Intent(this, OrcaNotificationPreferenceActivity.class));
    paramPreferenceGroup.addPreference(localPreferenceScreen);
  }

  private void c()
  {
    String str = UUID.randomUUID().toString();
    this.j.a(new HoneyClientEvent("click").d(a()).e("button").h(str).f("orca_preferences_delete_account_preference"));
    new AlertDialog.Builder(this).setTitle(getString(2131362623)).setMessage(getString(2131362624)).setPositiveButton(2131362170, new OrcaRootPreferenceActivity.5(this, str)).setNegativeButton(2131362168, new OrcaRootPreferenceActivity.4(this, str)).create().show();
  }

  private void c(PreferenceGroup paramPreferenceGroup)
  {
    LocationServicesPreference localLocationServicesPreference = new LocationServicesPreference(this);
    localLocationServicesPreference.setTitle(2131362599);
    localLocationServicesPreference.setDefaultValue(Boolean.valueOf(true));
    paramPreferenceGroup.addPreference(localLocationServicesPreference);
  }

  private void d(PreferenceGroup paramPreferenceGroup)
  {
    if (this.f)
    {
      PreferenceScreen localPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
      localPreferenceScreen.setTitle(2131362605);
      localPreferenceScreen.setIntent(new Intent(this, OrcaContactsPreferenceActivity.class));
      paramPreferenceGroup.addPreference(localPreferenceScreen);
    }
  }

  private void e(PreferenceGroup paramPreferenceGroup)
  {
    if ((this.g) && (this.h))
    {
      PreferenceScreen localPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
      localPreferenceScreen.setTitle(2131362622);
      localPreferenceScreen.setIntent(new Intent(this, OrcaPartialUserUpgradeActivity.class));
      paramPreferenceGroup.addPreference(localPreferenceScreen);
    }
  }

  private void f(PreferenceGroup paramPreferenceGroup)
  {
    if (this.c)
    {
      PreferenceScreen localPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
      localPreferenceScreen.setTitle(2131362617);
      localPreferenceScreen.setIntent(new Intent(this, OrcaSmsMmsPreferenceActivity.class));
      paramPreferenceGroup.addPreference(localPreferenceScreen);
    }
  }

  private void g(PreferenceGroup paramPreferenceGroup)
  {
    PreferenceScreen localPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
    localPreferenceScreen.setTitle(2131362574);
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.b.versionName;
    arrayOfObject[1] = Integer.valueOf(this.b.versionCode);
    localPreferenceScreen.setSummary(getString(2131362598, arrayOfObject));
    localPreferenceScreen.setOnPreferenceClickListener(new OrcaRootPreferenceActivity.1(this));
    paramPreferenceGroup.addPreference(localPreferenceScreen);
  }

  private void h(PreferenceGroup paramPreferenceGroup)
  {
    if ((!this.g) || (this.i.h() != IntendedAudience.PUBLIC))
    {
      Preference localPreference = new Preference(this);
      localPreference.setTitle(2131362576);
      localPreference.setOnPreferenceClickListener(new OrcaRootPreferenceActivity.2(this));
      paramPreferenceGroup.addPreference(localPreference);
    }
  }

  private void i(PreferenceGroup paramPreferenceGroup)
  {
    if (this.g)
    {
      Preference localPreference = new Preference(this);
      localPreference.setTitle(getString(2131362623));
      localPreference.setOnPreferenceClickListener(new OrcaRootPreferenceActivity.3(this));
      paramPreferenceGroup.addPreference(localPreference);
    }
  }

  private void j(PreferenceGroup paramPreferenceGroup)
  {
    if (this.d)
    {
      PreferenceScreen localPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
      localPreferenceScreen.setTitle("Tester");
      localPreferenceScreen.setIntent(new Intent(this, OrcaTesterPreferenceActivity.class));
      paramPreferenceGroup.addPreference(localPreferenceScreen);
    }
  }

  private void k(PreferenceGroup paramPreferenceGroup)
  {
    if (this.e)
    {
      PreferenceScreen localPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
      localPreferenceScreen.setTitle("Internal");
      localPreferenceScreen.setIntent(new Intent(this, OrcaInternalPreferenceActivity.class));
      paramPreferenceGroup.addPreference(localPreferenceScreen);
    }
  }

  public String a()
  {
    return "prefs_root";
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903391);
    FbInjector localFbInjector = b();
    this.b = ((PackageInfo)localFbInjector.a(PackageInfo.class));
    this.c = ((Boolean)localFbInjector.a(Boolean.class, IsClientSmsPermitted.class)).booleanValue();
    this.d = ((Boolean)localFbInjector.a(Boolean.class, IsTesterPrefsEnabled.class)).booleanValue();
    this.e = ((Boolean)localFbInjector.a(Boolean.class, IsInternalPrefsEnabled.class)).booleanValue();
    this.f = ((Boolean)localFbInjector.a(Boolean.class, IsContactsUploadPermitted.class)).booleanValue();
    this.g = ((Boolean)localFbInjector.a(Boolean.class, IsPartialAccount.class)).booleanValue();
    this.h = ((Boolean)localFbInjector.a(Boolean.class, IsPartialUpgradeEnabled.class)).booleanValue();
    this.i = ((OrcaAppType)localFbInjector.a(OrcaAppType.class));
    this.j = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
    FbTitleBarUtil.a(this);
    this.a = ((FbTitleBar)a(2131296299));
    this.a.setTitle(getString(2131362583));
    PreferenceScreen localPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
    setPreferenceScreen(localPreferenceScreen);
    a(localPreferenceScreen);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.OrcaRootPreferenceActivity
 * JD-Core Version:    0.6.0
 */