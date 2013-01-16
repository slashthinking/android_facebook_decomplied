package com.facebook.feed.module;

import android.content.res.Resources;
import com.facebook.feed.protocol.FetchGraphQLStoryMethod;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.story.GraphQLStoryHelper;

class NewsFeedModule$FetchGraphQLStoryMethodProvider extends AbstractProvider<FetchGraphQLStoryMethod>
{
  private NewsFeedModule$FetchGraphQLStoryMethodProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public FetchGraphQLStoryMethod a()
  {
    return new FetchGraphQLStoryMethod((Resources)b(Resources.class), (GraphQLStoryHelper)b(GraphQLStoryHelper.class), (GraphQLHelper)b(GraphQLHelper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.FetchGraphQLStoryMethodProvider
 * JD-Core Version:    0.6.0
 */