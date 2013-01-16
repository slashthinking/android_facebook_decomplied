package com.facebook.orca.nux;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.app.OrcaActivityBroadcaster;
import com.facebook.orca.common.ui.titlebar.DivebarController.DivebarState;
import com.facebook.orca.common.ui.widgets.text.CustomUrlLikeSpan;
import com.facebook.orca.common.util.StyledStringBuilder;
import com.facebook.orca.contacts.upload.ContactsUploadRunner;
import com.facebook.orca.contacts.upload.ContactsUploadState;
import com.facebook.orca.prefs.MessagesPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.sms.MmsSmsLogger;
import javax.inject.Provider;

public class ThreadListNuxController
{
  private static final Class<?> a = ThreadListNuxController.class;
  private final OrcaNuxManager b;
  private final OrcaActivityBroadcaster c;
  private final OrcaSharedPreferences d;
  private final Provider<Boolean> e;
  private final MmsSmsLogger f;
  private final ContactsUploadRunner g;
  private final LocalBroadcastManager h;
  private final AnalyticsLogger i;
  private final NuxFindingContactsIntroView j;
  private final NuxFindingContactsView k;
  private final NuxScrimView l;
  private final NuxSmsIntroView m;
  private BroadcastReceiver n;
  private ThreadListNuxController.OnNuxFinishedListener o;
  private boolean p = false;

  public ThreadListNuxController(OrcaNuxManager paramOrcaNuxManager, OrcaActivityBroadcaster paramOrcaActivityBroadcaster, OrcaSharedPreferences paramOrcaSharedPreferences, Provider<Boolean> paramProvider, MmsSmsLogger paramMmsSmsLogger, ContactsUploadRunner paramContactsUploadRunner, LocalBroadcastManager paramLocalBroadcastManager, AnalyticsLogger paramAnalyticsLogger, NuxFindingContactsIntroView paramNuxFindingContactsIntroView, NuxFindingContactsView paramNuxFindingContactsView, NuxScrimView paramNuxScrimView, NuxSmsIntroView paramNuxSmsIntroView)
  {
    this.b = paramOrcaNuxManager;
    this.c = paramOrcaActivityBroadcaster;
    this.d = paramOrcaSharedPreferences;
    this.e = paramProvider;
    this.f = paramMmsSmsLogger;
    this.g = paramContactsUploadRunner;
    this.h = paramLocalBroadcastManager;
    this.i = paramAnalyticsLogger;
    this.j = paramNuxFindingContactsIntroView;
    this.k = paramNuxFindingContactsView;
    this.l = paramNuxScrimView;
    this.m = paramNuxSmsIntroView;
  }

  private void a(DivebarController.DivebarState paramDivebarState)
  {
    if ((paramDivebarState == DivebarController.DivebarState.OPENED) && (f()))
      d();
  }

  private void a(ContactsUploadState paramContactsUploadState)
  {
    this.k.setState(paramContactsUploadState);
    switch (ThreadListNuxController.8.a[paramContactsUploadState.a().ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return;
      if (!f())
        continue;
      d();
      continue;
      c();
    }
  }

  private boolean f()
  {
    return this.p;
  }

  private void g()
  {
    this.b.l();
    if (((Boolean)this.e.b()).booleanValue())
      i();
    while (true)
    {
      return;
      this.p = true;
      this.j.setOnFindContactsClickListener(new ThreadListNuxController.2(this));
      this.j.setOnSkipClickListener(new ThreadListNuxController.3(this));
      CustomUrlLikeSpan localCustomUrlLikeSpan = new CustomUrlLikeSpan();
      localCustomUrlLikeSpan.a(new ThreadListNuxController.4(this));
      this.i.a(new HoneyClientEvent("nux_shown").d("finding_contacts_intro"));
      this.j.setLearnMoreLinkSpan(localCustomUrlLikeSpan);
      this.l.h();
      this.j.h();
    }
  }

  private void h()
  {
    this.i.a(new HoneyClientEvent("nux_hidden").d("finding_contacts_intro"));
    this.p = false;
    this.j.i();
    this.l.i();
  }

  private void i()
  {
    this.d.b().a(MessagesPrefKeys.z, true).a();
    this.g.a();
  }

  private void j()
  {
    this.i.a(new HoneyClientEvent("nux_shown").d("finding_contacts_progress"));
    this.p = true;
    this.k.h();
  }

  private void k()
  {
    Intent localIntent = new Intent(this.j.getContext(), LearnMoreActivity.class);
    localIntent.putExtra("layout", 2130903382);
    this.j.getContext().startActivity(localIntent);
  }

  private void l()
  {
    this.p = true;
    this.l.h();
    this.m.setClickable(false);
  }

  private void m()
  {
    this.f.c();
    Intent localIntent = new Intent(this.m.getContext(), SmsNuxDetailActivity.class);
    this.m.getContext().startActivity(localIntent);
  }

  private void n()
  {
    this.f.a(this.b.e());
    CustomUrlLikeSpan localCustomUrlLikeSpan = new CustomUrlLikeSpan();
    localCustomUrlLikeSpan.a(new ThreadListNuxController.5(this));
    Resources localResources = this.m.getResources();
    StyledStringBuilder localStyledStringBuilder = new StyledStringBuilder(localResources);
    if (this.b.e())
      localStyledStringBuilder.a(localResources.getString(2131362384));
    while (true)
    {
      localStyledStringBuilder.a("[[learn_more_link]]", localResources.getString(2131362385), localCustomUrlLikeSpan, 33);
      this.m.b();
      this.m.setBlurb(localStyledStringBuilder.b());
      this.l.b();
      this.m.h();
      this.m.setOnTryClickListener(new ThreadListNuxController.6(this));
      this.m.setOnSkipClickListener(new ThreadListNuxController.7(this));
      return;
      localStyledStringBuilder.a(localResources.getString(2131362383));
    }
  }

  private void o()
  {
    boolean bool = this.d.a(MessagesPrefKeys.g, false);
    this.f.b(bool);
    this.b.j();
    this.m.i();
    this.l.i();
    if (this.o != null)
      this.o.a();
  }

  public void a()
  {
    this.n = new ThreadListNuxController.1(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.facebook.orca.contacts.CONTACTS_UPLOAD_STATE_CHANGED");
    localIntentFilter.addAction("com.facebook.orca.common.ui.titlebar.DIVEBAR_STATE_CHANGED");
    this.h.a(this.n, localIntentFilter);
    a(this.g.c());
  }

  public void a(ThreadListNuxController.OnNuxFinishedListener paramOnNuxFinishedListener)
  {
    this.o = paramOnNuxFinishedListener;
  }

  public void b()
  {
    this.h.a(this.n);
    this.n = null;
  }

  public boolean c()
  {
    boolean bool1 = f();
    int i1 = 0;
    if (bool1)
      return i1;
    if (this.b.h())
      g();
    while (true)
    {
      i1 = 1;
      break;
      if (this.g.d())
      {
        j();
        continue;
      }
      boolean bool2 = this.b.g();
      i1 = 0;
      if (!bool2)
        break;
      l();
      n();
    }
  }

  public void d()
  {
    this.i.a(new HoneyClientEvent("nux_hidden").d("finding_contacts_progress"));
    this.p = false;
    this.k.g();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.nux.ThreadListNuxController
 * JD-Core Version:    0.6.0
 */