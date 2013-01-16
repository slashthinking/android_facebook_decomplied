package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$AppCenter
{
  public static final GraphQlQueryAppCenter.AppCenterField a = new GraphQlQueryAppCenter.AppCenterField("id");
  public static final GraphQlQueryAppCenter.AppCenterField b = new GraphQlQueryAppCenter.AppCenterField("url.site(mobile)");
  public static final GraphQlQueryAppCenter.AppCenterField c = new GraphQlQueryAppCenter.AppCenterField("name");

  public static GraphQlQueryAppCenter.AppCenterField a(GraphQlQueryAppCenterCategoryItem paramGraphQlQueryAppCenterCategoryItem)
  {
    return new GraphQlQueryAppCenter.AppCenterField("application_categories", paramGraphQlQueryAppCenterCategoryItem);
  }

  public static GraphQlQueryAppCenter a(GraphQlQueryAppCenter.AppCenterField[] paramArrayOfAppCenterField)
  {
    return new GraphQlQueryAppCenter(ImmutableList.a(paramArrayOfAppCenterField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.AppCenter
 * JD-Core Version:    0.6.2
 */