package com.facebook.katana.activity.faceweb;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.InteractionLogger;
import com.facebook.katana.util.StringUtils;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.Modules;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.UIElements;
import java.net.URLDecoder;

class FacewebFragment$ShowPublisherHandler$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    Bundle localBundle = new Bundle();
    if (!StringUtils.c(FacewebFragment.k(this.c.a)))
      localBundle.putString("extra_composer_title_string", URLDecoder.decode(FacewebFragment.k(this.c.a)));
    while (true)
    {
      localBundle.putString("publisher_type", this.a);
      localBundle.putLong("target_id", this.b);
      FacewebFragment.l(this.c.a).a(FB4A_AnalyticEntities.UIElements.f, FB4A_AnalyticEntities.Modules.l);
      this.c.a.a(null, localBundle, Integer.valueOf(10));
      return;
      if (FacewebFragment.i(this.c.a) != -1L)
        continue;
      localBundle.putInt("extra_composer_title", 2131363234);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.ShowPublisherHandler.1
 * JD-Core Version:    0.6.0
 */