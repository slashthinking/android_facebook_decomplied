package com.facebook.feed.ui;

import com.facebook.feed.data.PagedFeedUnitCollection;
import com.facebook.feed.util.event.UfiEvents.LikeClickedEvent;
import com.facebook.feed.util.event.UfiEvents.LikeClickedEventSubscriber;
import com.facebook.graphql.model.FeedEdge;
import com.facebook.graphql.model.FeedStory;
import java.util.Iterator;
import java.util.List;

class NewsFeedFragment$LikeClickSubscriber extends UfiEvents.LikeClickedEventSubscriber
{
  private NewsFeedFragment$LikeClickSubscriber(NewsFeedFragment paramNewsFeedFragment)
  {
  }

  public void a(UfiEvents.LikeClickedEvent paramLikeClickedEvent)
  {
    if (paramLikeClickedEvent.a == null)
    {
      NewsFeedFragment.a(this.a, this.a.ad.b(paramLikeClickedEvent.b));
      return;
    }
    PagedFeedUnitCollection localPagedFeedUnitCollection = this.a.ad;
    if (paramLikeClickedEvent.c == null);
    for (String str = paramLikeClickedEvent.a; ; str = paramLikeClickedEvent.c)
    {
      Iterator localIterator = localPagedFeedUnitCollection.a(str).iterator();
      while (localIterator.hasNext())
      {
        FeedEdge localFeedEdge = (FeedEdge)localIterator.next();
        if (!(localFeedEdge.b() instanceof FeedStory))
          continue;
        FeedStory localFeedStory = ((FeedStory)localFeedEdge.b()).a(paramLikeClickedEvent.a);
        if ((localFeedStory == null) || (!localFeedStory.b()))
          continue;
        NewsFeedFragment.a(this.a, localFeedStory);
      }
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.NewsFeedFragment.LikeClickSubscriber
 * JD-Core Version:    0.6.0
 */