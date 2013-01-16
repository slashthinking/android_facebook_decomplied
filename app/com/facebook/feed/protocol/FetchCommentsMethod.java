package com.facebook.feed.protocol;

import android.content.res.Resources;
import com.facebook.graphql.GraphQl;
import com.facebook.graphql.GraphQl.Feedback;
import com.facebook.graphql.GraphQl.LikersOfContentConnection;
import com.facebook.graphql.GraphQlQuery;
import com.facebook.graphql.GraphQlQueryDefaults;
import com.facebook.graphql.GraphQlQueryFeedback;
import com.facebook.graphql.GraphQlQueryLikersOfContentConnection.LikersOfContentConnectionField;
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
import com.google.common.collect.ImmutableMap.Builder;

public class FetchCommentsMethod
  implements ApiMethod<FetchNodeListParams, FetchFeedbackResult>
{
  private static final GraphQlQueryParam a = GraphQlQueryParam.a("feedback_id");
  private static final GraphQlQuery b;
  private GraphQLStoryHelper c;
  private GraphQLHelper d;

  static
  {
    GraphQlQueryRootCallNode localGraphQlQueryRootCallNode = GraphQl.a(a);
    GraphQlQueryFeedback localGraphQlQueryFeedback = GraphQlNewsFeedDefaults.l.a(GraphQl.Feedback.a(GraphQlNewsFeedDefaults.d));
    GraphQlQueryLikersOfContentConnection.LikersOfContentConnectionField[] arrayOfLikersOfContentConnectionField = new GraphQlQueryLikersOfContentConnection.LikersOfContentConnectionField[1];
    arrayOfLikersOfContentConnectionField[0] = GraphQl.LikersOfContentConnection.a;
    b = localGraphQlQueryRootCallNode.a(localGraphQlQueryFeedback.a(GraphQl.Feedback.a(GraphQl.LikersOfContentConnection.a(arrayOfLikersOfContentConnectionField))));
  }

  public FetchCommentsMethod(Resources paramResources, GraphQLStoryHelper paramGraphQLStoryHelper, GraphQLHelper paramGraphQLHelper)
  {
    this.c = paramGraphQLStoryHelper;
    this.d = paramGraphQLHelper;
  }

  public FetchFeedbackResult a(FetchNodeListParams paramFetchNodeListParams, ApiResponse paramApiResponse)
  {
    Feedback localFeedback = (Feedback)this.d.a("fetch_feedback_comments", 1, paramApiResponse.d()).readValueAs(Feedback.class);
    if (localFeedback == null)
      throw new Exception("Invalid JSON result");
    long l = System.currentTimeMillis();
    localFeedback.setFetchTimeMs(l);
    return new FetchFeedbackResult(localFeedback, DataFreshnessResult.FROM_SERVER, l);
  }

  public ApiRequest a(FetchNodeListParams paramFetchNodeListParams)
  {
    ImmutableMap localImmutableMap = ImmutableMap.k().b(a, paramFetchNodeListParams.a()).b(GraphQlNewsFeedDefaults.a, GraphQlUtil.b(paramFetchNodeListParams.c())).b(GraphQlNewsFeedDefaults.b, GraphQlUtil.b(paramFetchNodeListParams.d())).b(GraphQlNewsFeedDefaults.c, String.valueOf(paramFetchNodeListParams.b())).b(GraphQlQueryDefaults.e, this.c.a()).b();
    return this.d.a("fetch_feedback_comments", b.a(localImmutableMap));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.FetchCommentsMethod
 * JD-Core Version:    0.6.0
 */