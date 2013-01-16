package com.facebook.feed.module;

import com.facebook.common.util.FbErrorReporter;
import com.facebook.feed.protocol.PrefetchNewsFeedMethod;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.orca.app.UserInteractionController;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.story.GraphQLStoryHelper;

class NewsFeedModule$PrefetchNewsFeedMethodProvider extends AbstractProvider<PrefetchNewsFeedMethod>
{
  private NewsFeedModule$PrefetchNewsFeedMethodProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public PrefetchNewsFeedMethod a()
  {
    return new PrefetchNewsFeedMethod((GraphQLStoryHelper)b(GraphQLStoryHelper.class), (GraphQLHelper)b(GraphQLHelper.class), (UserInteractionController)b(UserInteractionController.class), (OrcaSharedPreferences)b(OrcaSharedPreferences.class), (FbErrorReporter)b(FbErrorReporter.class), (Clock)b(Clock.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.PrefetchNewsFeedMethodProvider
 * JD-Core Version:    0.6.0
 */