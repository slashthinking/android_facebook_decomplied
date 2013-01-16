package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$TimelineSectionsConnection
{
  public static final GraphQlQueryTimelineSectionsConnection.TimelineSectionsConnectionField a = new GraphQlQueryTimelineSectionsConnection.TimelineSectionsConnectionField("count");

  public static GraphQlQueryCallFirst1 a(long paramLong)
  {
    return new GraphQlQueryCallFirst1(paramLong);
  }

  public static GraphQlQueryCallWithUnits1 a(GraphQlQueryParam paramGraphQlQueryParam)
  {
    return new GraphQlQueryCallWithUnits1(paramGraphQlQueryParam);
  }

  public static GraphQlQueryTimelineSectionsConnection.TimelineSectionsConnectionField a(GraphQlQueryTimelineSection paramGraphQlQueryTimelineSection)
  {
    return new GraphQlQueryTimelineSectionsConnection.TimelineSectionsConnectionField("nodes", paramGraphQlQueryTimelineSection);
  }

  public static GraphQlQueryTimelineSectionsConnection a(GraphQlQueryTimelineSectionsConnection.CallOnTimelineSectionsConnection[] paramArrayOfCallOnTimelineSectionsConnection)
  {
    return new GraphQlQueryTimelineSectionsConnection(ImmutableList.a(paramArrayOfCallOnTimelineSectionsConnection), null, null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.TimelineSectionsConnection
 * JD-Core Version:    0.6.2
 */