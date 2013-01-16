package com.facebook.katana.orca;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.analytics.InteractionLogger;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.katana.util.ApplicationUtils;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.UIElements;
import com.facebook.orca.activity.OrcaFragment;

public class InstallMessengerPromoFragment extends OrcaFragment
{
  private Button a;
  private int b = 2130903249;
  private InteractionLogger c;

  public static boolean b(Context paramContext)
  {
    if ((!ApplicationUtils.a(paramContext, "com.facebook.orca")) && (Boolean.TRUE.equals(Gatekeeper.a(paramContext, "android_messenger_jewel_promotion"))));
    for (int i = 1; ; i = 0)
      return i;
  }

  public static Fragment f(int paramInt)
  {
    InstallMessengerPromoFragment localInstallMessengerPromoFragment = new InstallMessengerPromoFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("layout_id", paramInt);
    localInstallMessengerPromoFragment.f(localBundle);
    return localInstallMessengerPromoFragment;
  }

  public void B()
  {
    super.B();
    if (ApplicationUtils.a(n(), "com.facebook.orca"))
      n().g().a().a(this).a();
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(this.b, paramViewGroup, false);
    this.a = ((Button)localView.findViewById(2131297017));
    return localView;
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.b = m().getInt("layout_id");
    this.c = new InteractionLogger(p());
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent("click");
    localHoneyClientEvent.f(FB4A_AnalyticEntities.UIElements.x);
    localHoneyClientEvent.e("button");
    this.a.setOnClickListener(new InstallMessengerPromoFragment.1(this, localHoneyClientEvent));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.InstallMessengerPromoFragment
 * JD-Core Version:    0.6.0
 */