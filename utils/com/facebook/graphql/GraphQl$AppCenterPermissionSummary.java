package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$AppCenterPermissionSummary
{
  public static GraphQlQueryAppCenterPermissionSummary.AppCenterPermissionSummaryField a(GraphQlQueryAppCenterPermission paramGraphQlQueryAppCenterPermission)
  {
    return new GraphQlQueryAppCenterPermissionSummary.AppCenterPermissionSummaryField("required_permissions", paramGraphQlQueryAppCenterPermission);
  }

  public static GraphQlQueryAppCenterPermissionSummary a(GraphQlQueryAppCenterPermissionSummary.AppCenterPermissionSummaryField[] paramArrayOfAppCenterPermissionSummaryField)
  {
    return new GraphQlQueryAppCenterPermissionSummary(ImmutableList.a(paramArrayOfAppCenterPermissionSummaryField), null);
  }

  public static GraphQlQueryAppCenterPermissionSummary.AppCenterPermissionSummaryField b(GraphQlQueryAppCenterPermission paramGraphQlQueryAppCenterPermission)
  {
    return new GraphQlQueryAppCenterPermissionSummary.AppCenterPermissionSummaryField("additional_permissions", paramGraphQlQueryAppCenterPermission);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.AppCenterPermissionSummary
 * JD-Core Version:    0.6.2
 */