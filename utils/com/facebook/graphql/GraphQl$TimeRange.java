package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$TimeRange
{
  public static final GraphQlQueryTimeRange.TimeRangeField a = new GraphQlQueryTimeRange.TimeRangeField("start");
  public static final GraphQlQueryTimeRange.TimeRangeField b = new GraphQlQueryTimeRange.TimeRangeField("end");

  public static GraphQlQueryTimeRange a(GraphQlQueryTimeRange.TimeRangeField[] paramArrayOfTimeRangeField)
  {
    return new GraphQlQueryTimeRange(ImmutableList.a(paramArrayOfTimeRangeField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.TimeRange
 * JD-Core Version:    0.6.2
 */