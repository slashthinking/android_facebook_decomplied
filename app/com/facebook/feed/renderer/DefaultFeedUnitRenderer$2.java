package com.facebook.feed.renderer;

import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.feed.flyout.FlyoutAnimationHandler;
import com.facebook.feed.protocol.FeedbackLoggingParams;
import com.facebook.graphql.model.Feedback;

class DefaultFeedUnitRenderer$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    DefaultFeedUnitRenderer.a(this.a).b((HoneyClientEvent)paramView.getTag(2131296270));
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    arrayOfInt[0] += paramView.getWidth() / 2;
    arrayOfInt[1] += paramView.getHeight() / 2;
    DefaultFeedUnitRenderer.c(this.a).a(DefaultFeedUnitRenderer.b(this.a), (Feedback)paramView.getTag(2131296272), (FeedbackLoggingParams)paramView.getTag(2131296273), new Point(arrayOfInt[0], arrayOfInt[1]));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.renderer.DefaultFeedUnitRenderer.2
 * JD-Core Version:    0.6.0
 */