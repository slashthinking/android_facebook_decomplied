package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$Media
{
  public static final GraphQlQueryMediaImpl.MediaGenericField a = new GraphQlQueryMediaImpl.MediaGenericField("is_playable");
  public static final GraphQlQueryMediaImpl.MediaGenericField b = new GraphQlQueryMediaImpl.MediaGenericField("playable_url");

  public static GraphQlQueryMediaImpl.MediaGenericField a(GraphQlQueryImage paramGraphQlQueryImage)
  {
    return new GraphQlQueryMediaImpl.MediaGenericField("image", paramGraphQlQueryImage);
  }

  public static GraphQlQueryMediaImpl a(GraphQlQueryFieldMedia[] paramArrayOfGraphQlQueryFieldMedia)
  {
    return new GraphQlQueryMediaImpl(ImmutableList.a(paramArrayOfGraphQlQueryFieldMedia), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.Media
 * JD-Core Version:    0.6.2
 */