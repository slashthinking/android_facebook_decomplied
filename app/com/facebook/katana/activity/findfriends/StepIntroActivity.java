package com.facebook.katana.activity.findfriends;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.content.SecureContextHelper;
import com.facebook.katana.SyncContactsSetupActivity;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.activity.NotNewNavEnabled;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.katana.provider.UserValuesManager;
import com.facebook.katana.util.ApplicationUtils;
import com.facebook.katana.util.GrowthUtils;
import com.facebook.katana.util.PlatformUtils;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpecBuilder;
import com.facebook.orca.inject.FbInjector;

public class StepIntroActivity extends BaseFacebookActivity
  implements NotNewNavEnabled
{
  private SecureContextHelper n;
  private boolean o = false;
  private boolean p = false;
  private boolean q = true;
  private AnalyticsLogger r;
  private long s;
  private boolean t = false;

  private void j()
  {
    findViewById(2131296863).setOnClickListener(new StepIntroActivity.1(this));
    findViewById(2131296864).setOnClickListener(new StepIntroActivity.2(this));
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.n = ((SecureContextHelper)C().a(SecureContextHelper.class));
    this.r = ((AnalyticsLogger)C().a(AnalyticsLogger.class));
    this.q = getIntent().getBooleanExtra("is_part_of_nux", true);
    this.r.a(new FindFriendsAnalyticsEvent("begin").c(this.q));
    this.r.a(new FindFriendsAnalyticsEvent("legal_consent").c(this.q).i("opened"));
    this.s = SystemClock.elapsedRealtime();
    setContentView(2130903200);
    a(TitleBarButtonSpec.newBuilder().b(getString(2131363188)).i());
    this.o = Boolean.TRUE.equals(Gatekeeper.a(this, "new_android_ci_enabled"));
    this.p = Boolean.TRUE.equals(Gatekeeper.a(this, "new_android_ci_invite_step_enabled"));
    if (GrowthUtils.a().h(this))
      ((TextView)findViewById(2131296865)).setText(getResources().getString(2131363431));
    j();
  }

  public String i()
  {
    return getString(2131363427);
  }

  public void titleBarPrimaryActionClickHandler(View paramView)
  {
    GrowthUtils.a().g(this);
    if (!this.q)
    {
      finish();
      return;
    }
    if ((Boolean.TRUE.equals(Gatekeeper.a(this, "android_sync_setup_flow_enabled"))) && (PlatformUtils.a(this)) && (!UserValuesManager.a(this)));
    for (Intent localIntent = new Intent(this, SyncContactsSetupActivity.class); ; localIntent = ApplicationUtils.a(this))
    {
      this.n.a(localIntent, this);
      finish();
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.findfriends.StepIntroActivity
 * JD-Core Version:    0.6.0
 */