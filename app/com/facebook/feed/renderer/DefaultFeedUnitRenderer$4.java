package com.facebook.feed.renderer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.feed.intent.IFeedIntentBuilder;

class DefaultFeedUnitRenderer$4
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    String str = (String)paramView.getTag(2131296274);
    if (!DefaultFeedUnitRenderer.d(this.a).a(DefaultFeedUnitRenderer.b(this.a), str))
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(str));
      DefaultFeedUnitRenderer.b(this.a).startActivity(localIntent);
      DefaultFeedUnitRenderer.a(this.a).b((HoneyClientEvent)paramView.getTag(2131296270));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.renderer.DefaultFeedUnitRenderer.4
 * JD-Core Version:    0.6.0
 */