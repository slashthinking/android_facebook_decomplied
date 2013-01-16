package com.facebook.feed.module;

import com.facebook.feed.protocol.FetchFriendListFeedMethod;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.story.GraphQLStoryHelper;

class NewsFeedModule$FetchFriendListFeedMethodProvider extends AbstractProvider<FetchFriendListFeedMethod>
{
  private NewsFeedModule$FetchFriendListFeedMethodProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public FetchFriendListFeedMethod a()
  {
    return new FetchFriendListFeedMethod((GraphQLStoryHelper)b(GraphQLStoryHelper.class), (GraphQLHelper)b(GraphQLHelper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.FetchFriendListFeedMethodProvider
 * JD-Core Version:    0.6.0
 */