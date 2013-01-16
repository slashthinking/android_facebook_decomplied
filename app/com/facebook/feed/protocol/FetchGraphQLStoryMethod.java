package com.facebook.feed.protocol;

import android.content.res.Resources;
import com.facebook.graphql.GraphQl;
import com.facebook.graphql.GraphQlQuery;
import com.facebook.graphql.GraphQlQueryNode;
import com.facebook.graphql.GraphQlQueryParam;
import com.facebook.graphql.GraphQlQueryRootCallNode;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.graphql.common.GraphQlNewsFeedDefaults;
import com.facebook.story.GraphQLStoryHelper;
import com.google.common.collect.ImmutableList;

public class FetchGraphQLStoryMethod extends FetchSingleStoryMethod
{
  private static final GraphQlQueryParam d = GraphQlQueryParam.a("node_id");
  private static final GraphQlQuery e = GraphQl.a(d).a((GraphQlQueryNode)GraphQlNewsFeedDefaults.E.get(2));
  private static final GraphQlQuery f = GraphQl.a(d).a((GraphQlQueryNode)GraphQlNewsFeedDefaults.F.get(2));

  public FetchGraphQLStoryMethod(Resources paramResources, GraphQLStoryHelper paramGraphQLStoryHelper, GraphQLHelper paramGraphQLHelper)
  {
    super(paramResources, paramGraphQLStoryHelper, paramGraphQLHelper);
  }

  protected GraphQlQuery a(boolean paramBoolean)
  {
    if (paramBoolean);
    for (GraphQlQuery localGraphQlQuery = f; ; localGraphQlQuery = e)
      return localGraphQlQuery;
  }

  protected GraphQlQueryParam a()
  {
    return d;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.FetchGraphQLStoryMethod
 * JD-Core Version:    0.6.0
 */