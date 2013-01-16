package com.facebook.feed.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.flyout.FlyoutAggrEntParams;
import com.facebook.feed.flyout.FlyoutAnimationHandler;
import com.facebook.graphql.model.GraphQLProfile;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;

class FeedLinkifyUtil$FlyoutSpanNoUnderline extends ClickableSpan
{
  private final List<GraphQLProfile> b;
  private final JsonNode c;

  public FeedLinkifyUtil$FlyoutSpanNoUnderline(List<GraphQLProfile> paramList, JsonNode paramJsonNode)
  {
    this.b = paramJsonNode;
    Object localObject;
    this.c = localObject;
  }

  public void onClick(View paramView)
  {
    HoneyClientEvent localHoneyClientEvent = FeedLinkifyUtil.a(this.a).b(this.c);
    FeedLinkifyUtil.b(this.a).b(localHoneyClientEvent);
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    arrayOfInt[0] += paramView.getWidth() / 2;
    arrayOfInt[1] += paramView.getHeight() / 2;
    FlyoutAggrEntParams localFlyoutAggrEntParams = new FlyoutAggrEntParams(this.b);
    FeedLinkifyUtil.c(this.a).a(paramView.getContext(), localFlyoutAggrEntParams, new Point(arrayOfInt[0], arrayOfInt[1]));
  }

  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setColor(FeedLinkifyUtil.d(this.a).getResources().getColor(2131165265));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.util.FeedLinkifyUtil.FlyoutSpanNoUnderline
 * JD-Core Version:    0.6.0
 */