package com.facebook.graphql;

import com.google.common.collect.ImmutableList;
import java.util.List;

public class GraphQl$Image
{
  public static final GraphQlQueryImage.ImageField a = new GraphQlQueryImage.ImageField("uri");
  public static final GraphQlQueryImage.ImageField b = new GraphQlQueryImage.ImageField("width");
  public static final GraphQlQueryImage.ImageField c = new GraphQlQueryImage.ImageField("height");

  public static GraphQlQueryCallDevice1 a(String paramString)
  {
    return new GraphQlQueryCallDevice1(paramString);
  }

  public static GraphQlQueryCallSize1 a(GraphQlQueryParam paramGraphQlQueryParam)
  {
    return new GraphQlQueryCallSize1(paramGraphQlQueryParam);
  }

  public static GraphQlQueryCallSize2 a(long paramLong1, long paramLong2)
  {
    return new GraphQlQueryCallSize2(paramLong1, paramLong2);
  }

  public static GraphQlQueryCallSize2 a(GraphQlQueryParam paramGraphQlQueryParam1, GraphQlQueryParam paramGraphQlQueryParam2)
  {
    return new GraphQlQueryCallSize2(paramGraphQlQueryParam1, paramGraphQlQueryParam2);
  }

  public static GraphQlQueryImage a(List<? extends GraphQlQueryImage.ImageField> paramList)
  {
    return new GraphQlQueryImage(null, paramList, null);
  }

  public static GraphQlQueryImage a(GraphQlQueryImage.CallOnImage[] paramArrayOfCallOnImage)
  {
    return new GraphQlQueryImage(ImmutableList.a(paramArrayOfCallOnImage), null, null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.Image
 * JD-Core Version:    0.6.2
 */