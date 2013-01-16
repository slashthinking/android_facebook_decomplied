package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$AndroidAppConfig
{
  public static final GraphQlQueryAndroidAppConfig.AndroidAppConfigField a = new GraphQlQueryAndroidAppConfig.AndroidAppConfigField("package_name");
  public static final GraphQlQueryAndroidAppConfig.AndroidAppConfigField b = new GraphQlQueryAndroidAppConfig.AndroidAppConfigField("class_name");
  public static final GraphQlQueryAndroidAppConfig.AndroidAppConfigField c = new GraphQlQueryAndroidAppConfig.AndroidAppConfigField("key_hashes");
  public static final GraphQlQueryAndroidAppConfig.AndroidAppConfigField d = new GraphQlQueryAndroidAppConfig.AndroidAppConfigField("can_deeplink");

  public static GraphQlQueryAndroidAppConfig a(GraphQlQueryAndroidAppConfig.AndroidAppConfigField[] paramArrayOfAndroidAppConfigField)
  {
    return new GraphQlQueryAndroidAppConfig(ImmutableList.a(paramArrayOfAndroidAppConfigField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.AndroidAppConfig
 * JD-Core Version:    0.6.2
 */