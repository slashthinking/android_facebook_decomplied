package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$CommentsConnection
{
  public static final GraphQlQueryCommentsConnection.CommentsConnectionField a = new GraphQlQueryCommentsConnection.CommentsConnectionField("count");

  public static GraphQlQueryCallAfter1 a(GraphQlQueryParam paramGraphQlQueryParam)
  {
    return new GraphQlQueryCallAfter1(paramGraphQlQueryParam);
  }

  public static GraphQlQueryCommentsConnection.CommentsConnectionField a(GraphQlQueryComment paramGraphQlQueryComment)
  {
    return new GraphQlQueryCommentsConnection.CommentsConnectionField("nodes", paramGraphQlQueryComment);
  }

  public static GraphQlQueryCommentsConnection.CommentsConnectionField a(GraphQlQueryPageInfo paramGraphQlQueryPageInfo)
  {
    return new GraphQlQueryCommentsConnection.CommentsConnectionField("page_info", paramGraphQlQueryPageInfo);
  }

  public static GraphQlQueryCommentsConnection a(GraphQlQueryCommentsConnection.CallOnCommentsConnection[] paramArrayOfCallOnCommentsConnection)
  {
    return new GraphQlQueryCommentsConnection(ImmutableList.a(paramArrayOfCallOnCommentsConnection), null, null);
  }

  public static GraphQlQueryCommentsConnection a(GraphQlQueryCommentsConnection.CommentsConnectionField[] paramArrayOfCommentsConnectionField)
  {
    return new GraphQlQueryCommentsConnection(null, ImmutableList.a(paramArrayOfCommentsConnectionField), null);
  }

  public static GraphQlQueryCallBefore1 b(GraphQlQueryParam paramGraphQlQueryParam)
  {
    return new GraphQlQueryCallBefore1(paramGraphQlQueryParam);
  }

  public static GraphQlQueryCallFirst1 c(GraphQlQueryParam paramGraphQlQueryParam)
  {
    return new GraphQlQueryCallFirst1(paramGraphQlQueryParam);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.CommentsConnection
 * JD-Core Version:    0.6.2
 */