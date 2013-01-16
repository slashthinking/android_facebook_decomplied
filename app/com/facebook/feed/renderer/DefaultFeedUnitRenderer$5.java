package com.facebook.feed.renderer;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.graphql.model.FeedStory;

class DefaultFeedUnitRenderer$5
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    DefaultFeedUnitRenderer.a(this.a).b((HoneyClientEvent)paramView.getTag(2131296270));
    FeedStory localFeedStory = (FeedStory)paramView.getTag(2131296275);
    Intent localIntent = DefaultFeedUnitRenderer.d(this.a).a(localFeedStory);
    DefaultFeedUnitRenderer.e(this.a).a(localIntent, DefaultFeedUnitRenderer.b(this.a));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.renderer.DefaultFeedUnitRenderer.5
 * JD-Core Version:    0.6.0
 */