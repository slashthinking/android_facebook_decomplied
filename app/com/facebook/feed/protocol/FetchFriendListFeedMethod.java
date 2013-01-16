package com.facebook.feed.protocol;

import com.facebook.graphql.GraphQl;
import com.facebook.graphql.GraphQl.FriendList;
import com.facebook.graphql.GraphQl.FriendListFeedConnection;
import com.facebook.graphql.GraphQl.FriendListFeedEdge;
import com.facebook.graphql.GraphQlQuery;
import com.facebook.graphql.GraphQlQueryDefaults;
import com.facebook.graphql.GraphQlQueryFeedUnit;
import com.facebook.graphql.GraphQlQueryFriendList.FriendListField;
import com.facebook.graphql.GraphQlQueryFriendListFeedConnection;
import com.facebook.graphql.GraphQlQueryFriendListFeedConnection.CallOnFriendListFeedConnection;
import com.facebook.graphql.GraphQlQueryFriendListFeedConnection.FriendListFeedConnectionField;
import com.facebook.graphql.GraphQlQueryFriendListFeedEdge.FriendListFeedEdgeField;
import com.facebook.graphql.GraphQlQueryParam;
import com.facebook.graphql.GraphQlQueryRootCallNode;
import com.facebook.graphql.GraphQlUtil;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.graphql.common.GraphQlNewsFeedDefaults;
import com.facebook.graphql.model.FeedHomeStories;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.FeedUnitEdge;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.story.GraphQLStoryHelper;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Iterator;
import java.util.List;

public class FetchFriendListFeedMethod
  implements ApiMethod<FetchFriendListFeedParams, FetchNewsFeedResult>
{
  private static final GraphQlQueryParam b = GraphQlQueryParam.a("friend_list_id");
  private static final GraphQlQueryParam c = GraphQlQueryParam.a("before_home_story_param");
  private static final GraphQlQueryParam d = GraphQlQueryParam.a("after_home_story_param");
  private static final GraphQlQueryParam e = GraphQlQueryParam.a("first_home_story_param");
  GraphQlQuery a;
  private GraphQLStoryHelper f;
  private GraphQLHelper g;

  public FetchFriendListFeedMethod(GraphQLStoryHelper paramGraphQLStoryHelper, GraphQLHelper paramGraphQLHelper)
  {
    GraphQlQueryRootCallNode localGraphQlQueryRootCallNode = GraphQl.a(b);
    GraphQlQueryFriendList.FriendListField[] arrayOfFriendListField = new GraphQlQueryFriendList.FriendListField[1];
    GraphQlQueryFriendListFeedConnection.CallOnFriendListFeedConnection[] arrayOfCallOnFriendListFeedConnection = new GraphQlQueryFriendListFeedConnection.CallOnFriendListFeedConnection[3];
    arrayOfCallOnFriendListFeedConnection[0] = GraphQl.FriendListFeedConnection.b(c);
    arrayOfCallOnFriendListFeedConnection[1] = GraphQl.FriendListFeedConnection.a(d);
    arrayOfCallOnFriendListFeedConnection[2] = GraphQl.FriendListFeedConnection.c(e);
    GraphQlQueryFriendListFeedConnection localGraphQlQueryFriendListFeedConnection = GraphQl.FriendListFeedConnection.a(arrayOfCallOnFriendListFeedConnection);
    GraphQlQueryFriendListFeedConnection.FriendListFeedConnectionField[] arrayOfFriendListFeedConnectionField = new GraphQlQueryFriendListFeedConnection.FriendListFeedConnectionField[3];
    GraphQlQueryFriendListFeedEdge.FriendListFeedEdgeField[] arrayOfFriendListFeedEdgeField = new GraphQlQueryFriendListFeedEdge.FriendListFeedEdgeField[2];
    arrayOfFriendListFeedEdgeField[0] = GraphQl.FriendListFeedEdge.b;
    arrayOfFriendListFeedEdgeField[1] = GraphQl.FriendListFeedEdge.a((GraphQlQueryFeedUnit)GraphQlNewsFeedDefaults.C.get(2));
    arrayOfFriendListFeedConnectionField[0] = GraphQl.FriendListFeedConnection.a(GraphQl.FriendListFeedEdge.a(arrayOfFriendListFeedEdgeField));
    arrayOfFriendListFeedConnectionField[1] = GraphQl.FriendListFeedConnection.a(GraphQlQueryDefaults.k);
    arrayOfFriendListFeedConnectionField[2] = GraphQl.FriendListFeedConnection.a;
    arrayOfFriendListField[0] = GraphQl.FriendList.a(localGraphQlQueryFriendListFeedConnection.a(arrayOfFriendListFeedConnectionField));
    this.a = localGraphQlQueryRootCallNode.a(GraphQl.FriendList.a(arrayOfFriendListField));
    this.f = paramGraphQLStoryHelper;
    this.g = paramGraphQLHelper;
  }

  private String b(FetchFriendListFeedParams paramFetchFriendListFeedParams)
  {
    ImmutableMap localImmutableMap = ImmutableMap.k().b(GraphQlQueryDefaults.e, this.f.a()).b(b, paramFetchFriendListFeedParams.a()).b(c, GraphQlUtil.b(paramFetchFriendListFeedParams.c())).b(d, GraphQlUtil.b(paramFetchFriendListFeedParams.d())).b(e, String.valueOf(paramFetchFriendListFeedParams.b())).b();
    return this.a.a(localImmutableMap);
  }

  public FetchNewsFeedResult a(FetchFriendListFeedParams paramFetchFriendListFeedParams, ApiResponse paramApiResponse)
  {
    FeedHomeStories localFeedHomeStories = (FeedHomeStories)this.g.a("fetch_friend_list_feed", 2, paramApiResponse.d()).readValueAs(FeedHomeStories.class);
    if (localFeedHomeStories == null)
      throw new Exception("Invalid JSON result");
    long l = System.currentTimeMillis();
    if (localFeedHomeStories.feedUnitEdges != null)
    {
      Iterator localIterator = localFeedHomeStories.feedUnitEdges.iterator();
      while (localIterator.hasNext())
      {
        FeedUnitEdge localFeedUnitEdge = (FeedUnitEdge)localIterator.next();
        if (localFeedUnitEdge.b() == null)
          continue;
        localFeedUnitEdge.b().setFetchTimeMs(l);
      }
    }
    return new FetchNewsFeedResult(new FetchFriendListFeedParamsBuilder().a(paramFetchFriendListFeedParams).b(), localFeedHomeStories, DataFreshnessResult.FROM_SERVER, l);
  }

  public ApiRequest a(FetchFriendListFeedParams paramFetchFriendListFeedParams)
  {
    return this.g.a("fetch_friend_list_feed", b(paramFetchFriendListFeedParams));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.FetchFriendListFeedMethod
 * JD-Core Version:    0.6.0
 */