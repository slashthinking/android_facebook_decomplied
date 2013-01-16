package com.facebook.orca.prefs;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceGroup;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.widget.EditText;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.common.util.ExecutorWithProgressDialog;
import com.facebook.common.util.NetAccessLogger;
import com.facebook.debug.UiThreadWatchdogPreference;
import com.facebook.diagnostics.FPSPreference;
import com.facebook.orca.activity.FbPreferenceActivity;
import com.facebook.orca.annotations.IsMobileOnlineAvailabilityPermitted;
import com.facebook.orca.app.OrcaDataManager;
import com.facebook.orca.common.ui.titlebar.FbTitleBar;
import com.facebook.orca.common.ui.titlebar.FbTitleBarUtil;
import com.facebook.orca.contacts.upload.ContactsUploadRunner;
import com.facebook.orca.images.ImageCache;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.nux.OrcaNuxManager;

public class OrcaInternalPreferenceActivity extends FbPreferenceActivity
  implements AnalyticsActivity
{
  private ImageCache a;
  private OrcaDataManager b;
  private OrcaNuxManager c;
  private FbTitleBar d;
  private ContactsUploadRunner e;
  private ExecutorWithProgressDialog f;
  private boolean g;

  private void a(PreferenceGroup paramPreferenceGroup)
  {
    b(paramPreferenceGroup);
    PreferenceCategory localPreferenceCategory1 = new PreferenceCategory(this);
    localPreferenceCategory1.setTitle(2131362787);
    paramPreferenceGroup.addPreference(localPreferenceCategory1);
    c(localPreferenceCategory1);
    d(localPreferenceCategory1);
    e(localPreferenceCategory1);
    PreferenceCategory localPreferenceCategory2 = new PreferenceCategory(this);
    localPreferenceCategory2.setTitle(2131362788);
    paramPreferenceGroup.addPreference(localPreferenceCategory2);
    localPreferenceCategory2.addPreference(new FPSPreference(this, false));
    localPreferenceCategory2.addPreference(new UiThreadWatchdogPreference(this));
    PreferenceCategory localPreferenceCategory3 = new PreferenceCategory(this);
    localPreferenceCategory3.setTitle(2131362789);
    paramPreferenceGroup.addPreference(localPreferenceCategory3);
    f(localPreferenceCategory3);
    h(localPreferenceCategory3);
    g(localPreferenceCategory3);
    PreferenceCategory localPreferenceCategory4 = new PreferenceCategory(this);
    localPreferenceCategory4.setTitle(2131362790);
    paramPreferenceGroup.addPreference(localPreferenceCategory4);
    j(localPreferenceCategory4);
    k(localPreferenceCategory4);
    l(localPreferenceCategory4);
    m(localPreferenceCategory4);
    localPreferenceCategory4.addPreference(new CheckSslCertsPreference(this));
    localPreferenceCategory4.addPreference(new HttpProxyPreference(this));
    PreferenceCategory localPreferenceCategory5 = new PreferenceCategory(this);
    localPreferenceCategory5.setTitle(2131362791);
    paramPreferenceGroup.addPreference(localPreferenceCategory5);
    n(localPreferenceCategory5);
    o(localPreferenceCategory5);
    p(localPreferenceCategory5);
    PreferenceCategory localPreferenceCategory6 = new PreferenceCategory(this);
    localPreferenceCategory6.setTitle(2131362792);
    paramPreferenceGroup.addPreference(localPreferenceCategory6);
    q(localPreferenceCategory6);
    r(localPreferenceCategory6);
    s(localPreferenceCategory6);
    PreferenceCategory localPreferenceCategory7 = new PreferenceCategory(this);
    localPreferenceCategory7.setTitle(2131362793);
    paramPreferenceGroup.addPreference(localPreferenceCategory7);
    t(localPreferenceCategory7);
    u(localPreferenceCategory7);
    PreferenceCategory localPreferenceCategory8 = new PreferenceCategory(this);
    localPreferenceCategory8.setTitle(2131362794);
    paramPreferenceGroup.addPreference(localPreferenceCategory8);
    i(localPreferenceCategory8);
  }

  private void b(PreferenceGroup paramPreferenceGroup)
  {
    if (this.g)
      paramPreferenceGroup.addPreference(new MobileOnlineAvailabilityPreference(this));
  }

  private void c(PreferenceGroup paramPreferenceGroup)
  {
    ListPreferenceWithSummaryValue localListPreferenceWithSummaryValue = new ListPreferenceWithSummaryValue(this);
    localListPreferenceWithSummaryValue.setKey(SharedPrefKeys.i.a());
    localListPreferenceWithSummaryValue.setTitle(2131362752);
    localListPreferenceWithSummaryValue.setDefaultValue("-1");
    localListPreferenceWithSummaryValue.setEntries(2131689472);
    localListPreferenceWithSummaryValue.setEntryValues(2131689473);
    paramPreferenceGroup.addPreference(localListPreferenceWithSummaryValue);
  }

  private void d(PreferenceGroup paramPreferenceGroup)
  {
    CheckBoxPreference localCheckBoxPreference = new CheckBoxPreference(this);
    localCheckBoxPreference.setKey(SharedPrefKeys.j.a());
    localCheckBoxPreference.setTitle(2131362753);
    localCheckBoxPreference.setSummary(2131362754);
    localCheckBoxPreference.setDefaultValue(Boolean.valueOf(false));
    paramPreferenceGroup.addPreference(localCheckBoxPreference);
  }

  private void e(PreferenceGroup paramPreferenceGroup)
  {
    CheckBoxPreference localCheckBoxPreference = new CheckBoxPreference(this);
    localCheckBoxPreference.setKey(NetAccessLogger.a.a());
    localCheckBoxPreference.setTitle(2131362785);
    localCheckBoxPreference.setDefaultValue(Boolean.valueOf(false));
    paramPreferenceGroup.addPreference(localCheckBoxPreference);
  }

  private void f(PreferenceGroup paramPreferenceGroup)
  {
    CheckBoxPreference localCheckBoxPreference = new CheckBoxPreference(this);
    localCheckBoxPreference.setKey(InternalHttpPrefKeys.b.a());
    localCheckBoxPreference.setTitle(2131362756);
    localCheckBoxPreference.setSummary(2131362757);
    localCheckBoxPreference.setDefaultValue(Boolean.valueOf(false));
    paramPreferenceGroup.addPreference(localCheckBoxPreference);
  }

  private void g(PreferenceGroup paramPreferenceGroup)
  {
    CheckBoxPreference localCheckBoxPreference = new CheckBoxPreference(this);
    localCheckBoxPreference.setKey(InternalHttpPrefKeys.c.a());
    localCheckBoxPreference.setTitle(2131362760);
    localCheckBoxPreference.setSummary(2131362761);
    localCheckBoxPreference.setDefaultValue(Boolean.valueOf(false));
    paramPreferenceGroup.addPreference(localCheckBoxPreference);
  }

  private void h(PreferenceGroup paramPreferenceGroup)
  {
    CheckBoxPreference localCheckBoxPreference = new CheckBoxPreference(this);
    localCheckBoxPreference.setKey(InternalHttpPrefKeys.d.a());
    localCheckBoxPreference.setTitle(2131362758);
    localCheckBoxPreference.setSummary(2131362759);
    localCheckBoxPreference.setDefaultValue(Boolean.valueOf(false));
    paramPreferenceGroup.addPreference(localCheckBoxPreference);
  }

  private void i(PreferenceGroup paramPreferenceGroup)
  {
    CheckBoxPreference localCheckBoxPreference = new CheckBoxPreference(this);
    localCheckBoxPreference.setKey(MessengerPrefKeys.u.a());
    localCheckBoxPreference.setTitle(2131362762);
    localCheckBoxPreference.setSummary(2131362763);
    localCheckBoxPreference.setDefaultValue(Boolean.valueOf(false));
    paramPreferenceGroup.addPreference(localCheckBoxPreference);
  }

  private void j(PreferenceGroup paramPreferenceGroup)
  {
    ListPreferenceWithSummaryValue localListPreferenceWithSummaryValue = new ListPreferenceWithSummaryValue(this);
    localListPreferenceWithSummaryValue.setKey(InternalHttpPrefKeys.j.a());
    localListPreferenceWithSummaryValue.setTitle(2131362764);
    localListPreferenceWithSummaryValue.setSummary(2131362765);
    localListPreferenceWithSummaryValue.setDefaultValue("default");
    localListPreferenceWithSummaryValue.setEntries(2131689474);
    localListPreferenceWithSummaryValue.setEntryValues(2131689475);
    paramPreferenceGroup.addPreference(localListPreferenceWithSummaryValue);
  }

  private void k(PreferenceGroup paramPreferenceGroup)
  {
    EditTextPreferenceWithSummaryValue localEditTextPreferenceWithSummaryValue = new EditTextPreferenceWithSummaryValue(this);
    localEditTextPreferenceWithSummaryValue.setKey(InternalHttpPrefKeys.k.a());
    localEditTextPreferenceWithSummaryValue.setTitle(2131362766);
    localEditTextPreferenceWithSummaryValue.a(getString(2131362767));
    localEditTextPreferenceWithSummaryValue.setDialogTitle(2131362766);
    localEditTextPreferenceWithSummaryValue.getEditText().setHint(2131362768);
    localEditTextPreferenceWithSummaryValue.getEditText().setSingleLine(true);
    localEditTextPreferenceWithSummaryValue.getEditText().setInputType(1);
    paramPreferenceGroup.addPreference(localEditTextPreferenceWithSummaryValue);
  }

  private void l(PreferenceGroup paramPreferenceGroup)
  {
    ListPreferenceWithSummaryValue localListPreferenceWithSummaryValue = new ListPreferenceWithSummaryValue(this);
    localListPreferenceWithSummaryValue.setKey(InternalHttpPrefKeys.m.a());
    localListPreferenceWithSummaryValue.setTitle(2131362769);
    localListPreferenceWithSummaryValue.setSummary(2131362770);
    localListPreferenceWithSummaryValue.setDefaultValue("default");
    localListPreferenceWithSummaryValue.setEntries(2131689476);
    localListPreferenceWithSummaryValue.setEntryValues(2131689477);
    paramPreferenceGroup.addPreference(localListPreferenceWithSummaryValue);
  }

  private void m(PreferenceGroup paramPreferenceGroup)
  {
    EditTextPreferenceWithSummaryValue localEditTextPreferenceWithSummaryValue = new EditTextPreferenceWithSummaryValue(this);
    localEditTextPreferenceWithSummaryValue.setKey(InternalHttpPrefKeys.n.a());
    localEditTextPreferenceWithSummaryValue.setTitle(2131362771);
    localEditTextPreferenceWithSummaryValue.a(getString(2131362772));
    localEditTextPreferenceWithSummaryValue.setDialogTitle(2131362771);
    localEditTextPreferenceWithSummaryValue.getEditText().setHint(2131362773);
    localEditTextPreferenceWithSummaryValue.getEditText().setSingleLine(true);
    localEditTextPreferenceWithSummaryValue.getEditText().setInputType(1);
    paramPreferenceGroup.addPreference(localEditTextPreferenceWithSummaryValue);
  }

  private void n(PreferenceGroup paramPreferenceGroup)
  {
    Preference localPreference = new Preference(this);
    localPreference.setTitle(2131362594);
    localPreference.setSummary(2131362595);
    localPreference.setOnPreferenceClickListener(new OrcaInternalPreferenceActivity.1(this));
    paramPreferenceGroup.addPreference(localPreference);
  }

  private void o(PreferenceGroup paramPreferenceGroup)
  {
    Preference localPreference = new Preference(this);
    localPreference.setTitle(2131362596);
    localPreference.setSummary(2131362597);
    localPreference.setOnPreferenceClickListener(new OrcaInternalPreferenceActivity.2(this));
    paramPreferenceGroup.addPreference(localPreference);
  }

  private void p(PreferenceGroup paramPreferenceGroup)
  {
    Preference localPreference = new Preference(this);
    localPreference.setTitle(2131362750);
    localPreference.setOnPreferenceClickListener(new OrcaInternalPreferenceActivity.3(this));
    paramPreferenceGroup.addPreference(localPreference);
  }

  private void q(PreferenceGroup paramPreferenceGroup)
  {
    CheckBoxPreference localCheckBoxPreference = new CheckBoxPreference(this);
    localCheckBoxPreference.setKey(InternalPrefKeys.a.a());
    localCheckBoxPreference.setTitle(2131362774);
    localCheckBoxPreference.setSummary(2131362775);
    localCheckBoxPreference.setDefaultValue(Boolean.valueOf(false));
    paramPreferenceGroup.addPreference(localCheckBoxPreference);
  }

  private void r(PreferenceGroup paramPreferenceGroup)
  {
    ListPreferenceWithSummaryValue localListPreferenceWithSummaryValue = new ListPreferenceWithSummaryValue(this);
    localListPreferenceWithSummaryValue.setKey(InternalPrefKeys.d.a());
    localListPreferenceWithSummaryValue.setTitle(2131362776);
    localListPreferenceWithSummaryValue.setSummary(2131362777);
    localListPreferenceWithSummaryValue.setDefaultValue("-1");
    localListPreferenceWithSummaryValue.setEntries(2131689478);
    localListPreferenceWithSummaryValue.setEntryValues(2131689479);
    paramPreferenceGroup.addPreference(localListPreferenceWithSummaryValue);
  }

  private void s(PreferenceGroup paramPreferenceGroup)
  {
    Preference localPreference = new Preference(this);
    localPreference.setTitle(2131362778);
    localPreference.setSummary(2131362779);
    localPreference.setOnPreferenceClickListener(new OrcaInternalPreferenceActivity.4(this));
    paramPreferenceGroup.addPreference(localPreference);
  }

  private void t(PreferenceGroup paramPreferenceGroup)
  {
    CheckBoxPreference localCheckBoxPreference = new CheckBoxPreference(this);
    localCheckBoxPreference.setKey(InternalPrefKeys.f.a());
    localCheckBoxPreference.setTitle(2131362780);
    localCheckBoxPreference.setSummary(2131362781);
    localCheckBoxPreference.setDefaultValue(Boolean.valueOf(true));
    paramPreferenceGroup.addPreference(localCheckBoxPreference);
  }

  private void u(PreferenceGroup paramPreferenceGroup)
  {
    CheckBoxPreference localCheckBoxPreference = new CheckBoxPreference(this);
    localCheckBoxPreference.setKey(InternalPrefKeys.g.a());
    localCheckBoxPreference.setTitle(2131362782);
    localCheckBoxPreference.setSummary(2131362783);
    localCheckBoxPreference.setDefaultValue(Boolean.valueOf(false));
    paramPreferenceGroup.addPreference(localCheckBoxPreference);
    localCheckBoxPreference.setDependency(InternalPrefKeys.f.a());
  }

  public String a()
  {
    return "prefs_internal";
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903391);
    FbInjector localFbInjector = b();
    this.a = ((ImageCache)localFbInjector.a(ImageCache.class));
    this.b = ((OrcaDataManager)localFbInjector.a(OrcaDataManager.class));
    this.c = ((OrcaNuxManager)localFbInjector.a(OrcaNuxManager.class));
    this.e = ((ContactsUploadRunner)localFbInjector.a(ContactsUploadRunner.class));
    this.f = ((ExecutorWithProgressDialog)localFbInjector.a(ExecutorWithProgressDialog.class));
    this.g = ((Boolean)localFbInjector.a(Boolean.class, IsMobileOnlineAvailabilityPermitted.class)).booleanValue();
    FbTitleBarUtil.a(this);
    this.d = ((FbTitleBar)a(2131296299));
    this.d.setTitle(2131362786);
    PreferenceScreen localPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
    setPreferenceScreen(localPreferenceScreen);
    a(localPreferenceScreen);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.OrcaInternalPreferenceActivity
 * JD-Core Version:    0.6.0
 */