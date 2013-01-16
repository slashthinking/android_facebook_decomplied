package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$PrivacyScope
{
  public static final GraphQlQueryPrivacyScope.PrivacyScopeField a = new GraphQlQueryPrivacyScope.PrivacyScopeField("label");

  @Deprecated
  public static final GraphQlQueryPrivacyScope.PrivacyScopeField b = new GraphQlQueryPrivacyScope.PrivacyScopeField("type");

  @Deprecated
  public static final GraphQlQueryPrivacyScope.PrivacyScopeField c = new GraphQlQueryPrivacyScope.PrivacyScopeField("icon_type");

  public static GraphQlQueryPrivacyScope.PrivacyScopeField a(GraphQlQueryIcon paramGraphQlQueryIcon)
  {
    return new GraphQlQueryPrivacyScope.PrivacyScopeField("icon", paramGraphQlQueryIcon);
  }

  public static GraphQlQueryPrivacyScope a(GraphQlQueryPrivacyScope.PrivacyScopeField[] paramArrayOfPrivacyScopeField)
  {
    return new GraphQlQueryPrivacyScope(ImmutableList.a(paramArrayOfPrivacyScopeField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.PrivacyScope
 * JD-Core Version:    0.6.2
 */