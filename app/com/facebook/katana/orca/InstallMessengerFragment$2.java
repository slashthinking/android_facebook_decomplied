package com.facebook.katana.orca;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.analytics.InteractionLogger;
import com.facebook.katana.util.ApplicationUtils;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.UIElements;

class InstallMessengerFragment$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (InstallMessengerFragment.a(this.a) != null)
    {
      HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent("click");
      localHoneyClientEvent.f(FB4A_AnalyticEntities.UIElements.A);
      localHoneyClientEvent.e("button");
      if (InstallMessengerFragment.b(this.a) != null)
        localHoneyClientEvent.b("dest", InstallMessengerFragment.b(this.a).toString());
      InstallMessengerFragment.a(this.a).a(localHoneyClientEvent);
    }
    ApplicationUtils.b(this.a.n(), "com.facebook.orca");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.InstallMessengerFragment.2
 * JD-Core Version:    0.6.0
 */