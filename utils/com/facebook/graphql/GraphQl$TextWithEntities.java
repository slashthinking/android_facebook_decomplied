package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$TextWithEntities
{
  public static final GraphQlQueryTextWithEntities.TextWithEntitiesField a = new GraphQlQueryTextWithEntities.TextWithEntitiesField("text");

  public static GraphQlQueryTextWithEntities.TextWithEntitiesField a(GraphQlQueryAggregatedEntitiesAtRange paramGraphQlQueryAggregatedEntitiesAtRange)
  {
    return new GraphQlQueryTextWithEntities.TextWithEntitiesField("aggregated_ranges", paramGraphQlQueryAggregatedEntitiesAtRange);
  }

  public static GraphQlQueryTextWithEntities.TextWithEntitiesField a(GraphQlQueryEntityAtRange paramGraphQlQueryEntityAtRange)
  {
    return new GraphQlQueryTextWithEntities.TextWithEntitiesField("ranges", paramGraphQlQueryEntityAtRange);
  }

  public static GraphQlQueryTextWithEntities a(GraphQlQueryTextWithEntities.TextWithEntitiesField[] paramArrayOfTextWithEntitiesField)
  {
    return new GraphQlQueryTextWithEntities(ImmutableList.a(paramArrayOfTextWithEntitiesField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.TextWithEntities
 * JD-Core Version:    0.6.2
 */