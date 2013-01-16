package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$AppCenterCategoryItem
{
  public static final GraphQlQueryAppCenterCategoryItem.AppCenterCategoryItemField a = new GraphQlQueryAppCenterCategoryItem.AppCenterCategoryItemField("name");
  public static final GraphQlQueryAppCenterCategoryItem.AppCenterCategoryItemField b = new GraphQlQueryAppCenterCategoryItem.AppCenterCategoryItemField("label");

  public static GraphQlQueryAppCenterCategoryItem a(GraphQlQueryAppCenterCategoryItem.CallOnAppCenterCategoryItem[] paramArrayOfCallOnAppCenterCategoryItem)
  {
    return new GraphQlQueryAppCenterCategoryItem(ImmutableList.a(paramArrayOfCallOnAppCenterCategoryItem), null, null);
  }

  public static GraphQlQueryCallEnvironment1 a(String paramString)
  {
    return new GraphQlQueryCallEnvironment1(paramString);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.AppCenterCategoryItem
 * JD-Core Version:    0.6.2
 */