package com.facebook.feed.module;

import android.content.res.Resources;
import com.facebook.feed.protocol.FetchPlatformStoryMethod;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.story.GraphQLStoryHelper;

class NewsFeedModule$FetchPlatformStoryMethodProvider extends AbstractProvider<FetchPlatformStoryMethod>
{
  private NewsFeedModule$FetchPlatformStoryMethodProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public FetchPlatformStoryMethod a()
  {
    return new FetchPlatformStoryMethod((Resources)b(Resources.class), (GraphQLStoryHelper)b(GraphQLStoryHelper.class), (GraphQLHelper)b(GraphQLHelper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.FetchPlatformStoryMethodProvider
 * JD-Core Version:    0.6.0
 */