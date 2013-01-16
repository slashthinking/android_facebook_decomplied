package com.facebook.katana.orca;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.analytics.InteractionLogger;
import com.facebook.katana.util.ApplicationUtils;

class InstallMessengerPromoFragment$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (InstallMessengerPromoFragment.a(this.b) != null)
      InstallMessengerPromoFragment.a(this.b).a(this.a);
    ApplicationUtils.b(this.b.n(), "com.facebook.orca");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.InstallMessengerPromoFragment.1
 * JD-Core Version:    0.6.0
 */