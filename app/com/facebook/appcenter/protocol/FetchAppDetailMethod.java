package com.facebook.appcenter.protocol;

import android.content.res.Resources;
import com.facebook.appcenter.graphql.model.AppDetail;
import com.facebook.appcenter.service.FetchAppDetailParams;
import com.facebook.graphql.GraphQl;
import com.facebook.graphql.GraphQl.AppCenterPermission;
import com.facebook.graphql.GraphQl.AppCenterPermissionSummary;
import com.facebook.graphql.GraphQl.Application;
import com.facebook.graphql.GraphQl.FriendsWhoLikeConnection;
import com.facebook.graphql.GraphQl.FriendsWhoRecentlyUsedAppConnection;
import com.facebook.graphql.GraphQl.Image;
import com.facebook.graphql.GraphQl.SimilarApplicationsConnection;
import com.facebook.graphql.GraphQl.User;
import com.facebook.graphql.GraphQlQuery;
import com.facebook.graphql.GraphQlQueryAppCenterPermission;
import com.facebook.graphql.GraphQlQueryAppCenterPermission.AppCenterPermissionField;
import com.facebook.graphql.GraphQlQueryAppCenterPermissionSummary.AppCenterPermissionSummaryField;
import com.facebook.graphql.GraphQlQueryApplication.ApplicationField;
import com.facebook.graphql.GraphQlQueryDefaults;
import com.facebook.graphql.GraphQlQueryFriendsWhoRecentlyUsedAppConnection;
import com.facebook.graphql.GraphQlQueryFriendsWhoRecentlyUsedAppConnection.CallOnFriendsWhoRecentlyUsedAppConnection;
import com.facebook.graphql.GraphQlQueryFriendsWhoRecentlyUsedAppConnection.FriendsWhoRecentlyUsedAppConnectionField;
import com.facebook.graphql.GraphQlQueryImage;
import com.facebook.graphql.GraphQlQueryImage.CallOnImage;
import com.facebook.graphql.GraphQlQueryParam;
import com.facebook.graphql.GraphQlQueryRootCallNode;
import com.facebook.graphql.GraphQlQuerySimilarApplicationsConnection;
import com.facebook.graphql.GraphQlQuerySimilarApplicationsConnection.CallOnSimilarApplicationsConnection;
import com.facebook.graphql.GraphQlQuerySimilarApplicationsConnection.SimilarApplicationsConnectionField;
import com.facebook.graphql.GraphQlQueryUser.UserField;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.server.DataFreshnessResult;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

public class FetchAppDetailMethod
  implements ApiMethod<FetchAppDetailParams, FetchAppDetailResult>
{
  private static final GraphQlQueryParam c = GraphQlQueryParam.a("app_id");
  private static final GraphQlQueryAppCenterPermission d;
  private static final GraphQlQuery e;
  private Resources a;
  private GraphQLHelper b;

  static
  {
    GraphQlQueryAppCenterPermission.AppCenterPermissionField[] arrayOfAppCenterPermissionField = new GraphQlQueryAppCenterPermission.AppCenterPermissionField[5];
    arrayOfAppCenterPermissionField[0] = GraphQl.AppCenterPermission.a;
    arrayOfAppCenterPermissionField[1] = GraphQl.AppCenterPermission.e;
    arrayOfAppCenterPermissionField[2] = GraphQl.AppCenterPermission.b;
    arrayOfAppCenterPermissionField[3] = GraphQl.AppCenterPermission.d;
    arrayOfAppCenterPermissionField[4] = GraphQl.AppCenterPermission.c;
    d = GraphQl.AppCenterPermission.a(arrayOfAppCenterPermissionField);
    GraphQlQueryRootCallNode localGraphQlQueryRootCallNode = GraphQl.a(c);
    GraphQlQueryApplication.ApplicationField[] arrayOfApplicationField1 = new GraphQlQueryApplication.ApplicationField[22];
    arrayOfApplicationField1[0] = GraphQl.Application.v;
    arrayOfApplicationField1[1] = GraphQl.Application.j;
    arrayOfApplicationField1[2] = GraphQl.Application.q;
    GraphQlQueryAppCenterPermissionSummary.AppCenterPermissionSummaryField[] arrayOfAppCenterPermissionSummaryField = new GraphQlQueryAppCenterPermissionSummary.AppCenterPermissionSummaryField[2];
    arrayOfAppCenterPermissionSummaryField[0] = GraphQl.AppCenterPermissionSummary.b(d);
    arrayOfAppCenterPermissionSummaryField[1] = GraphQl.AppCenterPermissionSummary.a(d);
    arrayOfApplicationField1[3] = GraphQl.Application.a(GraphQl.AppCenterPermissionSummary.a(arrayOfAppCenterPermissionSummaryField));
    arrayOfApplicationField1[4] = GraphQl.Application.n;
    arrayOfApplicationField1[5] = GraphQl.Application.g;
    GraphQlQueryFriendsWhoRecentlyUsedAppConnection.CallOnFriendsWhoRecentlyUsedAppConnection[] arrayOfCallOnFriendsWhoRecentlyUsedAppConnection = new GraphQlQueryFriendsWhoRecentlyUsedAppConnection.CallOnFriendsWhoRecentlyUsedAppConnection[1];
    arrayOfCallOnFriendsWhoRecentlyUsedAppConnection[0] = GraphQl.FriendsWhoLikeConnection.a(3L);
    GraphQlQueryFriendsWhoRecentlyUsedAppConnection localGraphQlQueryFriendsWhoRecentlyUsedAppConnection = GraphQl.FriendsWhoRecentlyUsedAppConnection.a(arrayOfCallOnFriendsWhoRecentlyUsedAppConnection);
    GraphQlQueryFriendsWhoRecentlyUsedAppConnection.FriendsWhoRecentlyUsedAppConnectionField[] arrayOfFriendsWhoRecentlyUsedAppConnectionField = new GraphQlQueryFriendsWhoRecentlyUsedAppConnection.FriendsWhoRecentlyUsedAppConnectionField[3];
    arrayOfFriendsWhoRecentlyUsedAppConnectionField[0] = GraphQl.FriendsWhoRecentlyUsedAppConnection.a;
    GraphQlQueryUser.UserField[] arrayOfUserField = new GraphQlQueryUser.UserField[2];
    arrayOfUserField[0] = GraphQl.User.a;
    arrayOfUserField[1] = GraphQl.User.c;
    arrayOfFriendsWhoRecentlyUsedAppConnectionField[1] = GraphQl.FriendsWhoRecentlyUsedAppConnection.a(GraphQl.User.a(arrayOfUserField));
    arrayOfFriendsWhoRecentlyUsedAppConnectionField[2] = GraphQl.FriendsWhoRecentlyUsedAppConnection.a(GraphQlQueryDefaults.k);
    arrayOfApplicationField1[6] = GraphQl.Application.a(localGraphQlQueryFriendsWhoRecentlyUsedAppConnection.a(arrayOfFriendsWhoRecentlyUsedAppConnectionField));
    arrayOfApplicationField1[7] = GraphQl.Application.a;
    arrayOfApplicationField1[8] = GraphQl.Application.h;
    arrayOfApplicationField1[9] = GraphQl.Application.i;
    arrayOfApplicationField1[10] = GraphQl.Application.s;
    arrayOfApplicationField1[11] = GraphQl.Application.c;
    arrayOfApplicationField1[12] = GraphQl.Application.u;
    arrayOfApplicationField1[13] = GraphQl.Application.e;
    GraphQlQueryImage.CallOnImage[] arrayOfCallOnImage1 = new GraphQlQueryImage.CallOnImage[1];
    arrayOfCallOnImage1[0] = GraphQl.Image.a("ANDROID");
    arrayOfApplicationField1[14] = GraphQl.Application.d(GraphQl.Image.a(arrayOfCallOnImage1).a(GraphQlQueryDefaults.c).a("screenshots_android"));
    GraphQlQueryImage.CallOnImage[] arrayOfCallOnImage2 = new GraphQlQueryImage.CallOnImage[1];
    arrayOfCallOnImage2[0] = GraphQl.Image.a("MOBILE_WEB");
    arrayOfApplicationField1[15] = GraphQl.Application.d(GraphQl.Image.a(arrayOfCallOnImage2).a(GraphQlQueryDefaults.c).a("screenshots_mobile_web"));
    GraphQlQuerySimilarApplicationsConnection.CallOnSimilarApplicationsConnection[] arrayOfCallOnSimilarApplicationsConnection = new GraphQlQuerySimilarApplicationsConnection.CallOnSimilarApplicationsConnection[1];
    arrayOfCallOnSimilarApplicationsConnection[0] = GraphQl.SimilarApplicationsConnection.a(20L);
    GraphQlQuerySimilarApplicationsConnection localGraphQlQuerySimilarApplicationsConnection = GraphQl.SimilarApplicationsConnection.a(arrayOfCallOnSimilarApplicationsConnection);
    GraphQlQuerySimilarApplicationsConnection.SimilarApplicationsConnectionField[] arrayOfSimilarApplicationsConnectionField = new GraphQlQuerySimilarApplicationsConnection.SimilarApplicationsConnectionField[1];
    GraphQlQueryApplication.ApplicationField[] arrayOfApplicationField2 = new GraphQlQueryApplication.ApplicationField[3];
    arrayOfApplicationField2[0] = GraphQl.Application.c;
    arrayOfApplicationField2[1] = GraphQl.Application.a;
    GraphQlQueryImage.CallOnImage[] arrayOfCallOnImage3 = new GraphQlQueryImage.CallOnImage[2];
    arrayOfCallOnImage3[0] = GraphQl.Image.a("ANDROID");
    arrayOfCallOnImage3[1] = GraphQl.Image.a(204L, 204L);
    arrayOfApplicationField2[2] = GraphQl.Application.e(GraphQl.Image.a(arrayOfCallOnImage3).a(GraphQlQueryDefaults.c));
    arrayOfSimilarApplicationsConnectionField[0] = GraphQl.SimilarApplicationsConnection.a(GraphQl.Application.a(arrayOfApplicationField2));
    arrayOfApplicationField1[16] = GraphQl.Application.a(localGraphQlQuerySimilarApplicationsConnection.a(arrayOfSimilarApplicationsConnectionField));
    arrayOfApplicationField1[17] = GraphQl.Application.f;
    arrayOfApplicationField1[18] = GraphQl.Application.b(GraphQlQueryDefaults.d);
    arrayOfApplicationField1[19] = GraphQl.Application.d;
    arrayOfApplicationField1[20] = GraphQl.Application.b;
    arrayOfApplicationField1[21] = GraphQl.Application.p;
    e = localGraphQlQueryRootCallNode.a(GraphQl.Application.a(arrayOfApplicationField1));
  }

  public FetchAppDetailMethod(Resources paramResources, GraphQLHelper paramGraphQLHelper)
  {
    Preconditions.checkNotNull(paramResources);
    this.a = paramResources;
    this.b = paramGraphQLHelper;
  }

  private String b(FetchAppDetailParams paramFetchAppDetailParams)
  {
    return e.a(ImmutableMap.a(c, paramFetchAppDetailParams.a()));
  }

  public FetchAppDetailResult a(FetchAppDetailParams paramFetchAppDetailParams, ApiResponse paramApiResponse)
  {
    AppDetail localAppDetail = (AppDetail)this.b.a("fetch_app_detail", 1, paramApiResponse.d()).readValueAs(AppDetail.class);
    if (localAppDetail == null)
      throw new Exception("Invalid JSON result");
    return new FetchAppDetailResult(localAppDetail, DataFreshnessResult.FROM_SERVER, System.currentTimeMillis());
  }

  public ApiRequest a(FetchAppDetailParams paramFetchAppDetailParams)
  {
    return this.b.a("fetch_app_detail", b(paramFetchAppDetailParams));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.protocol.FetchAppDetailMethod
 * JD-Core Version:    0.6.0
 */