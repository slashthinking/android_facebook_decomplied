package com.facebook.feed.ui;

import com.facebook.feed.data.PagedFeedUnitCollection;
import com.facebook.feed.util.event.UfiEvents.PageLikeClickedEvent;
import com.facebook.feed.util.event.UfiEvents.PageLikeClickedEventSubscriber;
import com.facebook.graphql.model.FeedEdge;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.GraphQLActionLink;
import com.facebook.graphql.model.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLObjectType.ObjectType;
import com.facebook.graphql.model.GraphQLProfile;
import java.util.Iterator;
import java.util.List;

class NewsFeedFragment$PageLikeClickSubscriber extends UfiEvents.PageLikeClickedEventSubscriber
{
  private NewsFeedFragment$PageLikeClickSubscriber(NewsFeedFragment paramNewsFeedFragment)
  {
  }

  public void a(UfiEvents.PageLikeClickedEvent paramPageLikeClickedEvent)
  {
    Iterator localIterator = this.a.ad.a(paramPageLikeClickedEvent.a).iterator();
    while (localIterator.hasNext())
    {
      FeedEdge localFeedEdge = (FeedEdge)localIterator.next();
      if (!(localFeedEdge.b() instanceof FeedStory))
        continue;
      GraphQLActionLink localGraphQLActionLink = ((FeedStory)localFeedEdge.b()).f();
      if ((localGraphQLActionLink == null) || (!GraphQLObjectType.ObjectType.LikePageActionLink.equals(localGraphQLActionLink.type.a())) || (localGraphQLActionLink.page == null) || (!localGraphQLActionLink.page.id.equals(paramPageLikeClickedEvent.b)))
        continue;
      NewsFeedFragment.a(this.a, (FeedStory)localFeedEdge.b(), localGraphQLActionLink);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.NewsFeedFragment.PageLikeClickSubscriber
 * JD-Core Version:    0.6.0
 */