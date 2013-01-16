package com.facebook.feed.renderer;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;

class DefaultFeedUnitRenderer$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    DefaultFeedUnitRenderer.a(this.a).b((HoneyClientEvent)paramView.getTag(2131296270));
    DefaultFeedUnitRenderer.b(this.a).startActivity((Intent)paramView.getTag(2131296271));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.renderer.DefaultFeedUnitRenderer.1
 * JD-Core Version:    0.6.0
 */