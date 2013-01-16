package com.facebook.katana.activity.faceweb;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.InteractionLogger;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.Modules;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.UIElements;

class FacewebFragment$ShowPublisherHandler$3
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("extra_is_checkin", true);
    FacewebFragment.l(this.a.a).a(FB4A_AnalyticEntities.UIElements.h, FB4A_AnalyticEntities.Modules.l);
    this.a.a.a(null, localBundle, Integer.valueOf(10));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.ShowPublisherHandler.3
 * JD-Core Version:    0.6.0
 */