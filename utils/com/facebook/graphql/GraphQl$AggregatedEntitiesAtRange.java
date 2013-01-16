package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$AggregatedEntitiesAtRange
{
  public static final GraphQlQueryAggregatedEntitiesAtRange.AggregatedEntitiesAtRangeField a = new GraphQlQueryAggregatedEntitiesAtRange.AggregatedEntitiesAtRangeField("offset");
  public static final GraphQlQueryAggregatedEntitiesAtRange.AggregatedEntitiesAtRangeField b = new GraphQlQueryAggregatedEntitiesAtRange.AggregatedEntitiesAtRangeField("length");
  public static final GraphQlQueryAggregatedEntitiesAtRange.AggregatedEntitiesAtRangeField c = new GraphQlQueryAggregatedEntitiesAtRange.AggregatedEntitiesAtRangeField("count");

  public static GraphQlQueryAggregatedEntitiesAtRange.AggregatedEntitiesAtRangeField a(GraphQlQueryEntity paramGraphQlQueryEntity)
  {
    return new GraphQlQueryAggregatedEntitiesAtRange.AggregatedEntitiesAtRangeField("sample_entities", paramGraphQlQueryEntity);
  }

  public static GraphQlQueryAggregatedEntitiesAtRange a(GraphQlQueryAggregatedEntitiesAtRange.AggregatedEntitiesAtRangeField[] paramArrayOfAggregatedEntitiesAtRangeField)
  {
    return new GraphQlQueryAggregatedEntitiesAtRange(ImmutableList.a(paramArrayOfAggregatedEntitiesAtRangeField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.AggregatedEntitiesAtRange
 * JD-Core Version:    0.6.2
 */