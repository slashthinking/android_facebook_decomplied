package com.facebook.feed.protocol;

import android.content.res.Resources;
import com.facebook.graphql.GraphQl;
import com.facebook.graphql.GraphQlQuery;
import com.facebook.graphql.GraphQlQueryDefaults;
import com.facebook.graphql.GraphQlQueryParam;
import com.facebook.graphql.GraphQlQueryRootCallNode;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.graphql.common.GraphQlNewsFeedDefaults;
import com.facebook.graphql.model.Feedback;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.server.DataFreshnessResult;
import com.facebook.story.GraphQLStoryHelper;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public class FetchFeedbackMethod
  implements ApiMethod<FetchFeedbackParams, FetchFeedbackResult>
{
  public static final GraphQlQuery a;
  private static final GraphQlQueryParam b = GraphQlQueryParam.a("feedback_id");
  private GraphQLStoryHelper c;
  private GraphQLHelper d;

  static
  {
    a = GraphQl.a(b).a(GraphQlNewsFeedDefaults.n);
  }

  public FetchFeedbackMethod(Resources paramResources, GraphQLStoryHelper paramGraphQLStoryHelper, GraphQLHelper paramGraphQLHelper)
  {
    this.c = paramGraphQLStoryHelper;
    this.d = paramGraphQLHelper;
  }

  public FetchFeedbackResult a(FetchFeedbackParams paramFetchFeedbackParams, ApiResponse paramApiResponse)
  {
    JsonParser localJsonParser = this.d.a("fetch_feedback", 1, paramApiResponse.d());
    Feedback localFeedback = (Feedback)((ObjectMapper)localJsonParser.getCodec()).readValue(localJsonParser, Feedback.class);
    if (localFeedback == null)
      throw new Exception("Invalid JSON result");
    long l = System.currentTimeMillis();
    localFeedback.setFetchTimeMs(l);
    return new FetchFeedbackResult(localFeedback, DataFreshnessResult.FROM_SERVER, l);
  }

  public ApiRequest a(FetchFeedbackParams paramFetchFeedbackParams)
  {
    ImmutableMap localImmutableMap = new ImmutableMap.Builder().b(b, paramFetchFeedbackParams.a()).b(GraphQlNewsFeedDefaults.c, String.valueOf(paramFetchFeedbackParams.c())).b(GraphQlNewsFeedDefaults.b, "null").b(GraphQlNewsFeedDefaults.a, "null").b(GraphQlNewsFeedDefaults.g, String.valueOf(paramFetchFeedbackParams.b())).b(GraphQlNewsFeedDefaults.f, "null").b(GraphQlNewsFeedDefaults.e, "null").b(GraphQlQueryDefaults.e, this.c.a()).b();
    return this.d.a("fetch_feedback", a.a(localImmutableMap));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.FetchFeedbackMethod
 * JD-Core Version:    0.6.0
 */