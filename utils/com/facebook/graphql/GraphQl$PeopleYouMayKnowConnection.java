package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$PeopleYouMayKnowConnection
{
  public static final GraphQlQueryPeopleYouMayKnowConnection.PeopleYouMayKnowConnectionField a = new GraphQlQueryPeopleYouMayKnowConnection.PeopleYouMayKnowConnectionField("count");

  public static GraphQlQueryCallAfter1 a(GraphQlQueryParam paramGraphQlQueryParam)
  {
    return new GraphQlQueryCallAfter1(paramGraphQlQueryParam);
  }

  public static GraphQlQueryCallLocation1 a(String paramString)
  {
    return new GraphQlQueryCallLocation1(paramString);
  }

  public static GraphQlQueryPeopleYouMayKnowConnection.PeopleYouMayKnowConnectionField a(GraphQlQueryPageInfo paramGraphQlQueryPageInfo)
  {
    return new GraphQlQueryPeopleYouMayKnowConnection.PeopleYouMayKnowConnectionField("page_info", paramGraphQlQueryPageInfo);
  }

  public static GraphQlQueryPeopleYouMayKnowConnection.PeopleYouMayKnowConnectionField a(GraphQlQueryUser paramGraphQlQueryUser)
  {
    return new GraphQlQueryPeopleYouMayKnowConnection.PeopleYouMayKnowConnectionField("nodes", paramGraphQlQueryUser);
  }

  public static GraphQlQueryPeopleYouMayKnowConnection a(GraphQlQueryPeopleYouMayKnowConnection.CallOnPeopleYouMayKnowConnection[] paramArrayOfCallOnPeopleYouMayKnowConnection)
  {
    return new GraphQlQueryPeopleYouMayKnowConnection(ImmutableList.a(paramArrayOfCallOnPeopleYouMayKnowConnection), null, null);
  }

  public static GraphQlQueryCallFirst1 b(GraphQlQueryParam paramGraphQlQueryParam)
  {
    return new GraphQlQueryCallFirst1(paramGraphQlQueryParam);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.PeopleYouMayKnowConnection
 * JD-Core Version:    0.6.2
 */