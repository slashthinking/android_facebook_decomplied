package com.facebook.feed.flyout;

import android.content.Context;
import android.graphics.Point;
import android.support.v4.app.FragmentActivity;
import com.facebook.feed.protocol.FeedbackLoggingParams;
import com.facebook.feed.ui.StorySecondaryActionsFragment;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.Feedback;
import com.facebook.widget.flyout.FlyoutFragment;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;

public class FlyoutAnimationHandler
{
  private static boolean a;

  private void a(Context paramContext, FlyoutFragment paramFlyoutFragment)
  {
    if (a);
    while (true)
    {
      return;
      a = true;
      paramFlyoutFragment.a((FragmentActivity)paramContext).a(new FlyoutAnimationHandler.1(this), MoreExecutors.a());
    }
  }

  public void a(Context paramContext, FlyoutAggrEntParams paramFlyoutAggrEntParams, Point paramPoint)
  {
    if (!(paramContext instanceof FragmentActivity));
    while (true)
    {
      return;
      FeedAggregatedEntitiesFlyoutFragment localFeedAggregatedEntitiesFlyoutFragment = new FeedAggregatedEntitiesFlyoutFragment();
      localFeedAggregatedEntitiesFlyoutFragment.a(paramFlyoutAggrEntParams);
      localFeedAggregatedEntitiesFlyoutFragment.a(paramPoint);
      a(paramContext, localFeedAggregatedEntitiesFlyoutFragment);
    }
  }

  public void a(Context paramContext, FlyoutParams paramFlyoutParams, Point paramPoint)
  {
    a(paramContext, FlyoutParams.a(paramFlyoutParams), paramFlyoutParams.f, paramPoint);
  }

  public void a(Context paramContext, FeedStory paramFeedStory, Point paramPoint)
  {
    if (!(paramContext instanceof FragmentActivity));
    while (true)
    {
      return;
      StorySecondaryActionsFragment localStorySecondaryActionsFragment = new StorySecondaryActionsFragment();
      localStorySecondaryActionsFragment.a(paramContext, paramFeedStory);
      localStorySecondaryActionsFragment.a(paramPoint);
      a(paramContext, localStorySecondaryActionsFragment);
    }
  }

  public void a(Context paramContext, Feedback paramFeedback, FeedbackLoggingParams paramFeedbackLoggingParams, Point paramPoint)
  {
    if (!(paramContext instanceof FragmentActivity));
    while (true)
    {
      return;
      FeedFlyoutFragment localFeedFlyoutFragment = new FeedFlyoutFragment();
      localFeedFlyoutFragment.a(paramFeedback, paramFeedbackLoggingParams);
      localFeedFlyoutFragment.a(paramPoint);
      a(paramContext, localFeedFlyoutFragment);
    }
  }

  public void a(Context paramContext, String paramString, Point paramPoint)
  {
    if (!(paramContext instanceof FragmentActivity));
    while (true)
    {
      return;
      FeedFlyoutFragment localFeedFlyoutFragment = new FeedFlyoutFragment();
      localFeedFlyoutFragment.a(paramString);
      localFeedFlyoutFragment.a(paramPoint);
      a(paramContext, localFeedFlyoutFragment);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.FlyoutAnimationHandler
 * JD-Core Version:    0.6.0
 */