package com.facebook.feed.flyout;

import android.widget.ListView;
import com.facebook.feed.ui.FeedAdapterFactory;
import com.facebook.feed.util.event.FlyoutEvents.SwitchInlineCommentLikersEvent;
import com.facebook.feed.util.event.FlyoutEvents.SwitchInlineCommentLikersEventSubscriber;
import com.facebook.orca.inject.FbInjector;

class FeedFlyoutFragment$SwitchInlineCommentLikersEventSubscriber extends FlyoutEvents.SwitchInlineCommentLikersEventSubscriber
{
  private FeedFlyoutFragment$SwitchInlineCommentLikersEventSubscriber(FeedFlyoutFragment paramFeedFlyoutFragment)
  {
  }

  public void a(FlyoutEvents.SwitchInlineCommentLikersEvent paramSwitchInlineCommentLikersEvent)
  {
    if ((paramSwitchInlineCommentLikersEvent == null) || (paramSwitchInlineCommentLikersEvent.a == null));
    while (true)
    {
      return;
      FeedFlyoutFragment.a(this.a, ((FeedAdapterFactory)this.a.R().a(FeedAdapterFactory.class)).a(paramSwitchInlineCommentLikersEvent.a));
      FeedFlyoutFragment.v(this.a).setAdapter(FeedFlyoutFragment.C(this.a));
      FeedFlyoutFragment.x(this.a);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.FeedFlyoutFragment.SwitchInlineCommentLikersEventSubscriber
 * JD-Core Version:    0.6.0
 */