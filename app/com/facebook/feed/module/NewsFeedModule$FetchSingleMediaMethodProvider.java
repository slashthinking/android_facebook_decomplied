package com.facebook.feed.module;

import com.facebook.feed.protocol.FetchSingleMediaMethod;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.story.GraphQLStoryHelper;

class NewsFeedModule$FetchSingleMediaMethodProvider extends AbstractProvider<FetchSingleMediaMethod>
{
  private NewsFeedModule$FetchSingleMediaMethodProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public FetchSingleMediaMethod a()
  {
    return new FetchSingleMediaMethod((GraphQLStoryHelper)b(GraphQLStoryHelper.class), (GraphQLHelper)b(GraphQLHelper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.FetchSingleMediaMethodProvider
 * JD-Core Version:    0.6.0
 */