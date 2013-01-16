package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$PageInfo
{
  public static final GraphQlQueryPageInfo.PageInfoField a = new GraphQlQueryPageInfo.PageInfoField("start_cursor");
  public static final GraphQlQueryPageInfo.PageInfoField b = new GraphQlQueryPageInfo.PageInfoField("end_cursor");
  public static final GraphQlQueryPageInfo.PageInfoField c = new GraphQlQueryPageInfo.PageInfoField("has_next_page");
  public static final GraphQlQueryPageInfo.PageInfoField d = new GraphQlQueryPageInfo.PageInfoField("has_previous_page");
  public static final GraphQlQueryPageInfo.PageInfoField e = new GraphQlQueryPageInfo.PageInfoField("delta_cursor");

  public static GraphQlQueryPageInfo a(GraphQlQueryPageInfo.PageInfoField[] paramArrayOfPageInfoField)
  {
    return new GraphQlQueryPageInfo(ImmutableList.a(paramArrayOfPageInfoField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.PageInfo
 * JD-Core Version:    0.6.2
 */