package com.facebook.katana.orca;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.analytics.InteractionLogger;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.UIElements;

class InstallMessengerFragment$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (InstallMessengerFragment.a(this.a) != null)
    {
      HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent("click");
      localHoneyClientEvent.f(FB4A_AnalyticEntities.UIElements.z);
      localHoneyClientEvent.e("button");
      if (InstallMessengerFragment.b(this.a) != null)
        localHoneyClientEvent.b("dest", InstallMessengerFragment.b(this.a).toString());
      InstallMessengerFragment.a(this.a).a(localHoneyClientEvent);
    }
    InstallMessengerFragment.c(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.InstallMessengerFragment.1
 * JD-Core Version:    0.6.0
 */