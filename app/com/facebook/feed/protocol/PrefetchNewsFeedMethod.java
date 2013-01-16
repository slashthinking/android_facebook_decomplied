package com.facebook.feed.protocol;

import com.facebook.common.util.FbErrorReporter;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.orca.app.UserInteractionController;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.server.DataFreshnessParam;
import com.facebook.story.GraphQLStoryHelper;
import com.google.common.base.Preconditions;

public class PrefetchNewsFeedMethod extends FetchNewsFeedMethod
{
  public PrefetchNewsFeedMethod(GraphQLStoryHelper paramGraphQLStoryHelper, GraphQLHelper paramGraphQLHelper, UserInteractionController paramUserInteractionController, OrcaSharedPreferences paramOrcaSharedPreferences, FbErrorReporter paramFbErrorReporter, Clock paramClock)
  {
    super(paramGraphQLStoryHelper, paramGraphQLHelper, paramUserInteractionController, paramOrcaSharedPreferences, paramFbErrorReporter, paramClock);
  }

  public ApiRequest a(FetchNewsFeedParams paramFetchNewsFeedParams)
  {
    boolean bool1 = true;
    boolean bool2;
    boolean bool3;
    if (paramFetchNewsFeedParams.e() == DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA)
    {
      bool2 = bool1;
      Preconditions.checkArgument(bool2, "Prefetch request must hit server for new data");
      if (paramFetchNewsFeedParams.d() != null)
        break label74;
      bool3 = bool1;
      label30: Preconditions.checkArgument(bool3, "Prefetch request may not include an after cursor");
      Preconditions.checkNotNull(paramFetchNewsFeedParams.c(), "Prefetch request must include before cursor");
      if (paramFetchNewsFeedParams.g() != FetchNewsFeedParams.ViewMode.PREFETCH)
        break label80;
    }
    while (true)
    {
      Preconditions.checkArgument(bool1, "Prefetch request without prefetch set in params");
      return super.a(paramFetchNewsFeedParams);
      bool2 = false;
      break;
      label74: bool3 = false;
      break label30;
      label80: bool1 = false;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.PrefetchNewsFeedMethod
 * JD-Core Version:    0.6.0
 */