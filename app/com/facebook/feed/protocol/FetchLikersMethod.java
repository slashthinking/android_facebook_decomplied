package com.facebook.feed.protocol;

import android.content.res.Resources;
import com.facebook.graphql.GraphQl;
import com.facebook.graphql.GraphQl.CommentsConnection;
import com.facebook.graphql.GraphQl.Feedback;
import com.facebook.graphql.GraphQlQuery;
import com.facebook.graphql.GraphQlQueryCommentsConnection.CommentsConnectionField;
import com.facebook.graphql.GraphQlQueryDefaults;
import com.facebook.graphql.GraphQlQueryFeedback;
import com.facebook.graphql.GraphQlQueryParam;
import com.facebook.graphql.GraphQlQueryRootCallNode;
import com.facebook.graphql.GraphQlUtil;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.graphql.common.GraphQlNewsFeedDefaults;
import com.facebook.graphql.model.Feedback;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.story.GraphQLStoryHelper;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.collect.ImmutableMap;

public class FetchLikersMethod
  implements ApiMethod<FetchNodeListParams, FetchFeedbackResult>
{
  private static final GraphQlQueryParam a = GraphQlQueryParam.a("feedback_id");
  private static final GraphQlQuery b;
  private GraphQLStoryHelper c;
  private GraphQLHelper d;

  static
  {
    GraphQlQueryRootCallNode localGraphQlQueryRootCallNode = GraphQl.a(a);
    GraphQlQueryFeedback localGraphQlQueryFeedback = GraphQlNewsFeedDefaults.l.a(GraphQl.Feedback.a(GraphQlNewsFeedDefaults.h));
    GraphQlQueryCommentsConnection.CommentsConnectionField[] arrayOfCommentsConnectionField = new GraphQlQueryCommentsConnection.CommentsConnectionField[1];
    arrayOfCommentsConnectionField[0] = GraphQl.CommentsConnection.a;
    b = localGraphQlQueryRootCallNode.a(localGraphQlQueryFeedback.a(GraphQl.Feedback.a(GraphQl.CommentsConnection.a(arrayOfCommentsConnectionField))));
  }

  public FetchLikersMethod(Resources paramResources, GraphQLStoryHelper paramGraphQLStoryHelper, GraphQLHelper paramGraphQLHelper)
  {
    this.c = paramGraphQLStoryHelper;
    this.d = paramGraphQLHelper;
  }

  public FetchFeedbackResult a(FetchNodeListParams paramFetchNodeListParams, ApiResponse paramApiResponse)
  {
    Feedback localFeedback = (Feedback)this.d.a("fetch_feedback_likes", 1, paramApiResponse.d()).readValueAs(Feedback.class);
    if (localFeedback == null)
      throw new Exception("Invalid JSON result");
    long l = System.currentTimeMillis();
    localFeedback.setFetchTimeMs(l);
    return new FetchFeedbackResult(localFeedback, DataFreshnessResult.FROM_SERVER, l);
  }

  public ApiRequest a(FetchNodeListParams paramFetchNodeListParams)
  {
    ImmutableMap localImmutableMap = ImmutableMap.a(a, paramFetchNodeListParams.a(), GraphQlNewsFeedDefaults.e, GraphQlUtil.b(paramFetchNodeListParams.c()), GraphQlNewsFeedDefaults.f, GraphQlUtil.b(paramFetchNodeListParams.d()), GraphQlNewsFeedDefaults.g, String.valueOf(paramFetchNodeListParams.b()), GraphQlQueryDefaults.e, this.c.b());
    return this.d.a("fetch_feedback_likes", b.a(localImmutableMap));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.FetchLikersMethod
 * JD-Core Version:    0.6.0
 */