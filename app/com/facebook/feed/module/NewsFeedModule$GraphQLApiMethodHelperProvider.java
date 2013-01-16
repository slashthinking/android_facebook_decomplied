package com.facebook.feed.module;

import android.content.res.Resources;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.story.GraphQLStoryHelper;

class NewsFeedModule$GraphQLApiMethodHelperProvider extends AbstractProvider<GraphQLStoryHelper>
{
  private NewsFeedModule$GraphQLApiMethodHelperProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public GraphQLStoryHelper a()
  {
    return new GraphQLStoryHelper((Resources)b(Resources.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.GraphQLApiMethodHelperProvider
 * JD-Core Version:    0.6.0
 */