package com.facebook.feed.protocol;

import android.content.res.Resources;
import com.facebook.graphql.GraphQlQuery;
import com.facebook.graphql.GraphQlQueryDefaults;
import com.facebook.graphql.GraphQlQueryParam;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.graphql.common.GraphQlNewsFeedDefaults;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.Feedback;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.story.GraphQLStoryHelper;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public abstract class FetchSingleStoryMethod
  implements ApiMethod<FetchSingleStoryParams, FetchSingleStoryResult>
{
  protected Resources a;
  protected GraphQLStoryHelper b;
  protected GraphQLHelper c;

  public FetchSingleStoryMethod(Resources paramResources, GraphQLStoryHelper paramGraphQLStoryHelper, GraphQLHelper paramGraphQLHelper)
  {
    this.a = paramResources;
    this.b = paramGraphQLStoryHelper;
    this.c = paramGraphQLHelper;
  }

  public FetchSingleStoryResult a(FetchSingleStoryParams paramFetchSingleStoryParams, ApiResponse paramApiResponse)
  {
    FeedStory localFeedStory = (FeedStory)this.c.a("fetch_single_story", 1, paramApiResponse.d()).readValueAs(FeedStory.class);
    if (localFeedStory == null)
      throw new Exception("Not a valid JSON object");
    localFeedStory.p();
    long l = System.currentTimeMillis();
    localFeedStory.setFetchTimeMs(l);
    if (localFeedStory.S() != null)
      localFeedStory.S().setFetchTimeMs(l);
    return new FetchSingleStoryResult(localFeedStory, DataFreshnessResult.FROM_SERVER, l);
  }

  protected abstract GraphQlQuery a(boolean paramBoolean);

  protected abstract GraphQlQueryParam a();

  protected String a(FetchSingleStoryParams paramFetchSingleStoryParams)
  {
    ImmutableMap.Builder localBuilder = new ImmutableMap.Builder().b(GraphQlQueryDefaults.e, this.b.a()).b(a(), paramFetchSingleStoryParams.a);
    if (paramFetchSingleStoryParams.c)
      localBuilder.b(GraphQlNewsFeedDefaults.a, "null").b(GraphQlNewsFeedDefaults.b, "null").b(GraphQlNewsFeedDefaults.e, "null").b(GraphQlNewsFeedDefaults.f, "null").b(GraphQlNewsFeedDefaults.c, String.valueOf(paramFetchSingleStoryParams.e)).b(GraphQlNewsFeedDefaults.g, String.valueOf(paramFetchSingleStoryParams.d));
    ImmutableMap localImmutableMap = localBuilder.b();
    return a(paramFetchSingleStoryParams.c).a(localImmutableMap);
  }

  public ApiRequest b(FetchSingleStoryParams paramFetchSingleStoryParams)
  {
    return this.c.a("fetch_single_story", a(paramFetchSingleStoryParams));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.FetchSingleStoryMethod
 * JD-Core Version:    0.6.0
 */