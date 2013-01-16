package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$EntityAtRange
{
  public static final GraphQlQueryEntityAtRange.EntityAtRangeField a = new GraphQlQueryEntityAtRange.EntityAtRangeField("offset");
  public static final GraphQlQueryEntityAtRange.EntityAtRangeField b = new GraphQlQueryEntityAtRange.EntityAtRangeField("length");

  public static GraphQlQueryEntityAtRange.EntityAtRangeField a(GraphQlQueryEntity paramGraphQlQueryEntity)
  {
    return new GraphQlQueryEntityAtRange.EntityAtRangeField("entity", paramGraphQlQueryEntity);
  }

  public static GraphQlQueryEntityAtRange a(GraphQlQueryEntityAtRange.EntityAtRangeField[] paramArrayOfEntityAtRangeField)
  {
    return new GraphQlQueryEntityAtRange(ImmutableList.a(paramArrayOfEntityAtRangeField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.EntityAtRange
 * JD-Core Version:    0.6.2
 */