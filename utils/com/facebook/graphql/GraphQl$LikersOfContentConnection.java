package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$LikersOfContentConnection
{
  public static final GraphQlQueryLikersOfContentConnection.LikersOfContentConnectionField a = new GraphQlQueryLikersOfContentConnection.LikersOfContentConnectionField("count");

  public static GraphQlQueryCallAfter1 a(GraphQlQueryParam paramGraphQlQueryParam)
  {
    return new GraphQlQueryCallAfter1(paramGraphQlQueryParam);
  }

  public static GraphQlQueryLikersOfContentConnection.LikersOfContentConnectionField a(GraphQlQueryPageInfo paramGraphQlQueryPageInfo)
  {
    return new GraphQlQueryLikersOfContentConnection.LikersOfContentConnectionField("page_info", paramGraphQlQueryPageInfo);
  }

  public static GraphQlQueryLikersOfContentConnection.LikersOfContentConnectionField a(GraphQlQueryProfile paramGraphQlQueryProfile)
  {
    return new GraphQlQueryLikersOfContentConnection.LikersOfContentConnectionField("nodes", paramGraphQlQueryProfile);
  }

  public static GraphQlQueryLikersOfContentConnection a(GraphQlQueryLikersOfContentConnection.CallOnLikersOfContentConnection[] paramArrayOfCallOnLikersOfContentConnection)
  {
    return new GraphQlQueryLikersOfContentConnection(ImmutableList.a(paramArrayOfCallOnLikersOfContentConnection), null, null);
  }

  public static GraphQlQueryLikersOfContentConnection a(GraphQlQueryLikersOfContentConnection.LikersOfContentConnectionField[] paramArrayOfLikersOfContentConnectionField)
  {
    return new GraphQlQueryLikersOfContentConnection(null, ImmutableList.a(paramArrayOfLikersOfContentConnectionField), null);
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
 * Qualified Name:     com.facebook.graphql.GraphQl.LikersOfContentConnection
 * JD-Core Version:    0.6.2
 */