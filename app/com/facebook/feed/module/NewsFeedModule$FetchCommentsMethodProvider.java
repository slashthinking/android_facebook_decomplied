package com.facebook.feed.module;

import android.content.res.Resources;
import com.facebook.feed.protocol.FetchCommentsMethod;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.story.GraphQLStoryHelper;

class NewsFeedModule$FetchCommentsMethodProvider extends AbstractProvider<FetchCommentsMethod>
{
  private NewsFeedModule$FetchCommentsMethodProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public FetchCommentsMethod a()
  {
    return new FetchCommentsMethod((Resources)b(Resources.class), (GraphQLStoryHelper)b(GraphQLStoryHelper.class), (GraphQLHelper)b(GraphQLHelper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.FetchCommentsMethodProvider
 * JD-Core Version:    0.6.0
 */