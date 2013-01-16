package com.facebook.katana.activity.findfriends;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.content.SecureContextHelper;
import com.facebook.katana.SyncContactsSetupActivity;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.activity.NotNewNavEnabled;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.katana.provider.UserValuesManager;
import com.facebook.katana.util.ApplicationUtils;
import com.facebook.katana.util.PlatformUtils;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpecBuilder;
import com.facebook.orca.inject.FbInjector;
import java.util.ArrayList;

public class StepInviteActivity extends BaseFacebookActivity
  implements NotNewNavEnabled
{
  private static final Class<?> n = StepInviteActivity.class;
  private AppSession o;
  private ArrayList<String> p;
  private boolean q = false;
  private boolean r = true;
  private AnalyticsLogger s;
  private long t;
  private SecureContextHelper u;

  private void l()
  {
    this.s.a(new FindFriendsAnalyticsEvent("end").c(this.r));
    if (!this.r)
    {
      finish();
      return;
    }
    if ((Boolean.TRUE.equals(Gatekeeper.a(this, "android_sync_setup_flow_enabled"))) && (PlatformUtils.a(this)) && (!UserValuesManager.a(this)));
    for (Intent localIntent = new Intent(this, SyncContactsSetupActivity.class); ; localIntent = ApplicationUtils.a(this))
    {
      this.u.a(localIntent, this);
      break;
    }
  }

  private void m()
  {
    if (this.q);
    for (int i = this.p.size(); ; i = 0)
    {
      this.s.a(new FindFriendsAnalyticsEvent("invite").i("submitted").c(this.r).b(SystemClock.elapsedRealtime() - this.t).d(this.p.size()).e(i));
      return;
    }
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.s = ((AnalyticsLogger)C().a(AnalyticsLogger.class));
    if (!Boolean.TRUE.equals(Gatekeeper.a(this, "new_android_ci_invite_step_enabled")))
    {
      l();
      finish();
    }
    while (true)
    {
      return;
      this.p = getIntent().getStringArrayListExtra("invitee_credentials");
      this.r = getIntent().getBooleanExtra("is_part_of_nux", true);
      this.u = ((SecureContextHelper)C().a(SecureContextHelper.class));
      this.s.a(new FindFriendsAnalyticsEvent("invite").i("opened").c(this.r).d(this.p.size()));
      this.t = SystemClock.elapsedRealtime();
      if (this.p.size() == 0)
      {
        m();
        l();
        finish();
      }
      this.o = AppSession.a(this, true);
      setContentView(2130903201);
      a(TitleBarButtonSpec.newBuilder().b(getString(2131363188)).i());
      j();
    }
  }

  public String i()
  {
    return getString(2131363443);
  }

  public void j()
  {
    findViewById(2131296866).setOnClickListener(new StepInviteActivity.1(this));
  }

  public void titleBarPrimaryActionClickHandler(View paramView)
  {
    m();
    l();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.findfriends.StepInviteActivity
 * JD-Core Version:    0.6.0
 */