package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$TimelineUnitsConnection
{
  public static final GraphQlQueryTimelineUnitsConnection.TimelineUnitsConnectionField a = new GraphQlQueryTimelineUnitsConnection.TimelineUnitsConnectionField("count");

  public static GraphQlQueryCallAfter1 a(GraphQlQueryParam paramGraphQlQueryParam)
  {
    return new GraphQlQueryCallAfter1(paramGraphQlQueryParam);
  }

  public static GraphQlQueryCallFirst1 a(long paramLong)
  {
    return new GraphQlQueryCallFirst1(paramLong);
  }

  public static GraphQlQueryTimelineUnitsConnection.TimelineUnitsConnectionField a(GraphQlQueryFeedUnit paramGraphQlQueryFeedUnit)
  {
    return new GraphQlQueryTimelineUnitsConnection.TimelineUnitsConnectionField("nodes", paramGraphQlQueryFeedUnit);
  }

  public static GraphQlQueryTimelineUnitsConnection.TimelineUnitsConnectionField a(GraphQlQueryPageInfo paramGraphQlQueryPageInfo)
  {
    return new GraphQlQueryTimelineUnitsConnection.TimelineUnitsConnectionField("page_info", paramGraphQlQueryPageInfo);
  }

  public static GraphQlQueryTimelineUnitsConnection a(GraphQlQueryTimelineUnitsConnection.CallOnTimelineUnitsConnection[] paramArrayOfCallOnTimelineUnitsConnection)
  {
    return new GraphQlQueryTimelineUnitsConnection(ImmutableList.a(paramArrayOfCallOnTimelineUnitsConnection), null, null);
  }

  public static GraphQlQueryCallWithSource1 b(GraphQlQueryParam paramGraphQlQueryParam)
  {
    return new GraphQlQueryCallWithSource1(paramGraphQlQueryParam);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.TimelineUnitsConnection
 * JD-Core Version:    0.6.2
 */