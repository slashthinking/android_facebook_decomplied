package com.facebook.orca.prefs;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceGroup;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.activity.FbPreferenceActivity;
import com.facebook.orca.annotations.ForUiThread;
import com.facebook.orca.app.AppInitLockHelper;
import com.facebook.orca.common.ui.titlebar.FbTitleBar;
import com.facebook.orca.common.ui.titlebar.FbTitleBarUtil;
import com.facebook.orca.contacts.upload.ContactsUploadRunner;
import com.facebook.orca.contacts.upload.ContactsUploadState;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.ListenableFuture;
import java.text.NumberFormat;
import java.util.UUID;
import java.util.concurrent.Executor;

public class OrcaContactsPreferenceActivity extends FbPreferenceActivity
  implements AnalyticsActivity
{
  private OrcaContactsPreferenceActivity.DeleteContactsPreferenceState a = OrcaContactsPreferenceActivity.DeleteContactsPreferenceState.NOT_STARTED;
  private FbTitleBar b;
  private Executor c;
  private LocalBroadcastManager d;
  private Preference e;
  private Preference f;
  private ContactsUploadRunner g;
  private OrcaServiceOperationFactory h;
  private ListenableFuture<OperationResult> i;
  private AnalyticsLogger j;

  private void a(PreferenceGroup paramPreferenceGroup)
  {
    this.e = new Preference(this);
    a(OrcaContactsPreferenceActivity.DeleteContactsPreferenceState.NOT_STARTED);
    this.e.setOnPreferenceClickListener(new OrcaContactsPreferenceActivity.1(this));
    paramPreferenceGroup.addPreference(this.e);
  }

  private void a(ContactsUploadState paramContactsUploadState)
  {
    NumberFormat localNumberFormat = NumberFormat.getPercentInstance();
    localNumberFormat.setMaximumFractionDigits(0);
    switch (OrcaContactsPreferenceActivity.5.b[paramContactsUploadState.a().ordinal()])
    {
    case 1:
    default:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      return;
      Preference localPreference2 = this.f;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = localNumberFormat.format(0L);
      localPreference2.setTitle(getString(2131362612, arrayOfObject2));
      continue;
      int k = paramContactsUploadState.d();
      float f1 = 0.0F;
      if (k > 0)
        f1 = paramContactsUploadState.c() / paramContactsUploadState.d();
      Preference localPreference1 = this.f;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = localNumberFormat.format(f1);
      localPreference1.setTitle(getString(2131362612, arrayOfObject1));
      continue;
      this.f.setTitle(getString(2131362613));
      this.f.setEnabled(false);
      continue;
      this.f.setTitle(getString(2131362614));
      this.f.setEnabled(false);
    }
  }

  private void a(OrcaContactsPreferenceActivity.DeleteContactsPreferenceState paramDeleteContactsPreferenceState)
  {
    this.a = paramDeleteContactsPreferenceState;
    switch (OrcaContactsPreferenceActivity.5.a[this.a.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      return;
      this.e.setTitle(2131362607);
      continue;
      this.e.setTitle(2131362608);
      this.e.setEnabled(false);
      continue;
      this.e.setTitle(2131362609);
      this.e.setEnabled(true);
      continue;
      this.e.setTitle(2131362610);
      this.e.setEnabled(false);
    }
  }

  private void b(PreferenceGroup paramPreferenceGroup)
  {
    this.f = new Preference(this);
    this.f.setTitle(getString(2131362611));
    this.f.setOnPreferenceClickListener(new OrcaContactsPreferenceActivity.4(this));
    paramPreferenceGroup.addPreference(this.f);
  }

  private void c()
  {
    String str = UUID.randomUUID().toString();
    this.j.a(new HoneyClientEvent("click").d(a()).e("button").h(str).f("orca_preferences_delete_synced_contacts_preference"));
    new AlertDialog.Builder(this).setTitle(2131362607).setMessage(2131362606).setPositiveButton(2131362170, new OrcaContactsPreferenceActivity.3(this, str)).setNegativeButton(2131362168, new OrcaContactsPreferenceActivity.2(this, str)).create().show();
  }

  public String a()
  {
    return "prefs_contacts";
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    AppInitLockHelper.a(this);
    FbInjector localFbInjector = FbInjector.a(this);
    this.c = ((Executor)localFbInjector.a(Executor.class, ForUiThread.class));
    this.d = ((LocalBroadcastManager)localFbInjector.a(LocalBroadcastManager.class));
    this.g = ((ContactsUploadRunner)localFbInjector.a(ContactsUploadRunner.class));
    this.h = ((OrcaServiceOperationFactory)localFbInjector.a(OrcaServiceOperationFactory.class));
    this.j = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
    setContentView(2130903391);
    FbTitleBarUtil.a(this);
    this.b = ((FbTitleBar)a(2131296299));
    this.b.setTitle(getString(2131362605));
    PreferenceScreen localPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
    a(localPreferenceScreen);
    b(localPreferenceScreen);
    setPreferenceScreen(localPreferenceScreen);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.OrcaContactsPreferenceActivity
 * JD-Core Version:    0.6.0
 */