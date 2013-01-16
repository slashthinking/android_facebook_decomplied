package com.facebook.appcenter.protocol;

import android.content.res.Resources;
import com.facebook.appcenter.graphql.model.AppList;
import com.facebook.appcenter.service.FetchAppListParams;
import com.facebook.graphql.GraphQl;
import com.facebook.graphql.GraphQl.Application;
import com.facebook.graphql.GraphQl.FriendsWhoRecentlyUsedAppConnection;
import com.facebook.graphql.GraphQl.Image;
import com.facebook.graphql.GraphQl.RecommendedApplicationsConnection;
import com.facebook.graphql.GraphQl.TextWithEntities;
import com.facebook.graphql.GraphQl.User;
import com.facebook.graphql.GraphQlQuery;
import com.facebook.graphql.GraphQlQueryApplication.ApplicationField;
import com.facebook.graphql.GraphQlQueryDefaults;
import com.facebook.graphql.GraphQlQueryFriendsWhoRecentlyUsedAppConnection;
import com.facebook.graphql.GraphQlQueryFriendsWhoRecentlyUsedAppConnection.CallOnFriendsWhoRecentlyUsedAppConnection;
import com.facebook.graphql.GraphQlQueryFriendsWhoRecentlyUsedAppConnection.FriendsWhoRecentlyUsedAppConnectionField;
import com.facebook.graphql.GraphQlQueryImage;
import com.facebook.graphql.GraphQlQueryImage.CallOnImage;
import com.facebook.graphql.GraphQlQueryParam;
import com.facebook.graphql.GraphQlQueryRecommendedApplicationsConnection;
import com.facebook.graphql.GraphQlQueryRecommendedApplicationsConnection.CallOnRecommendedApplicationsConnection;
import com.facebook.graphql.GraphQlQueryRecommendedApplicationsConnection.RecommendedApplicationsConnectionField;
import com.facebook.graphql.GraphQlQueryRootCallActor;
import com.facebook.graphql.GraphQlQueryTextWithEntities.TextWithEntitiesField;
import com.facebook.graphql.GraphQlQueryUser.UserField;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.server.DataFreshnessResult;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

public class FetchAppListMethod
  implements ApiMethod<FetchAppListParams, FetchAppListResult>
{
  private static final GraphQlQueryParam c = GraphQlQueryParam.a("category");
  private static final GraphQlQueryParam d = GraphQlQueryParam.a("order_by");
  private static final GraphQlQuery e;
  private Resources a;
  private GraphQLHelper b;

  static
  {
    GraphQlQueryRootCallActor localGraphQlQueryRootCallActor = GraphQl.a();
    GraphQlQueryUser.UserField[] arrayOfUserField1 = new GraphQlQueryUser.UserField[3];
    arrayOfUserField1[0] = GraphQl.User.a;
    arrayOfUserField1[1] = GraphQl.User.c;
    GraphQlQueryRecommendedApplicationsConnection.CallOnRecommendedApplicationsConnection[] arrayOfCallOnRecommendedApplicationsConnection = new GraphQlQueryRecommendedApplicationsConnection.CallOnRecommendedApplicationsConnection[5];
    arrayOfCallOnRecommendedApplicationsConnection[0] = GraphQl.RecommendedApplicationsConnection.b(c);
    arrayOfCallOnRecommendedApplicationsConnection[1] = GraphQl.RecommendedApplicationsConnection.a("ANDROID_MOBILE_WEB");
    arrayOfCallOnRecommendedApplicationsConnection[2] = GraphQl.RecommendedApplicationsConnection.a(d);
    arrayOfCallOnRecommendedApplicationsConnection[3] = GraphQl.RecommendedApplicationsConnection.b("ANDROID");
    arrayOfCallOnRecommendedApplicationsConnection[4] = GraphQl.RecommendedApplicationsConnection.a(100L);
    GraphQlQueryRecommendedApplicationsConnection localGraphQlQueryRecommendedApplicationsConnection = GraphQl.RecommendedApplicationsConnection.a(arrayOfCallOnRecommendedApplicationsConnection);
    GraphQlQueryRecommendedApplicationsConnection.RecommendedApplicationsConnectionField[] arrayOfRecommendedApplicationsConnectionField = new GraphQlQueryRecommendedApplicationsConnection.RecommendedApplicationsConnectionField[1];
    GraphQlQueryApplication.ApplicationField[] arrayOfApplicationField = new GraphQlQueryApplication.ApplicationField[8];
    GraphQlQueryFriendsWhoRecentlyUsedAppConnection.CallOnFriendsWhoRecentlyUsedAppConnection[] arrayOfCallOnFriendsWhoRecentlyUsedAppConnection = new GraphQlQueryFriendsWhoRecentlyUsedAppConnection.CallOnFriendsWhoRecentlyUsedAppConnection[1];
    arrayOfCallOnFriendsWhoRecentlyUsedAppConnection[0] = GraphQl.FriendsWhoRecentlyUsedAppConnection.a(3L);
    GraphQlQueryFriendsWhoRecentlyUsedAppConnection localGraphQlQueryFriendsWhoRecentlyUsedAppConnection = GraphQl.FriendsWhoRecentlyUsedAppConnection.a(arrayOfCallOnFriendsWhoRecentlyUsedAppConnection);
    GraphQlQueryFriendsWhoRecentlyUsedAppConnection.FriendsWhoRecentlyUsedAppConnectionField[] arrayOfFriendsWhoRecentlyUsedAppConnectionField = new GraphQlQueryFriendsWhoRecentlyUsedAppConnection.FriendsWhoRecentlyUsedAppConnectionField[3];
    arrayOfFriendsWhoRecentlyUsedAppConnectionField[0] = GraphQl.FriendsWhoRecentlyUsedAppConnection.a;
    GraphQlQueryUser.UserField[] arrayOfUserField2 = new GraphQlQueryUser.UserField[2];
    arrayOfUserField2[0] = GraphQl.User.a;
    arrayOfUserField2[1] = GraphQl.User.c;
    arrayOfFriendsWhoRecentlyUsedAppConnectionField[1] = GraphQl.FriendsWhoRecentlyUsedAppConnection.a(GraphQl.User.a(arrayOfUserField2));
    arrayOfFriendsWhoRecentlyUsedAppConnectionField[2] = GraphQl.FriendsWhoRecentlyUsedAppConnection.a(GraphQlQueryDefaults.k);
    arrayOfApplicationField[0] = GraphQl.Application.a(localGraphQlQueryFriendsWhoRecentlyUsedAppConnection.a(arrayOfFriendsWhoRecentlyUsedAppConnectionField));
    arrayOfApplicationField[1] = GraphQl.Application.n;
    arrayOfApplicationField[2] = GraphQl.Application.c;
    GraphQlQueryTextWithEntities.TextWithEntitiesField[] arrayOfTextWithEntitiesField = new GraphQlQueryTextWithEntities.TextWithEntitiesField[1];
    arrayOfTextWithEntitiesField[0] = GraphQl.TextWithEntities.a;
    arrayOfApplicationField[3] = GraphQl.Application.b(GraphQl.TextWithEntities.a(arrayOfTextWithEntitiesField));
    arrayOfApplicationField[4] = GraphQl.Application.a;
    arrayOfApplicationField[5] = GraphQl.Application.b(GraphQlQueryDefaults.d);
    arrayOfApplicationField[6] = GraphQl.Application.i;
    GraphQlQueryImage.CallOnImage[] arrayOfCallOnImage = new GraphQlQueryImage.CallOnImage[2];
    arrayOfCallOnImage[0] = GraphQl.Image.a("ANDROID");
    arrayOfCallOnImage[1] = GraphQl.Image.a(204L, 204L);
    arrayOfApplicationField[7] = GraphQl.Application.e(GraphQl.Image.a(arrayOfCallOnImage).a(GraphQlQueryDefaults.c));
    arrayOfRecommendedApplicationsConnectionField[0] = GraphQl.RecommendedApplicationsConnection.a(GraphQl.Application.a(arrayOfApplicationField));
    arrayOfUserField1[2] = GraphQl.User.a(localGraphQlQueryRecommendedApplicationsConnection.a(arrayOfRecommendedApplicationsConnectionField));
    e = localGraphQlQueryRootCallActor.a(GraphQl.User.a(arrayOfUserField1));
  }

  public FetchAppListMethod(Resources paramResources, GraphQLHelper paramGraphQLHelper)
  {
    Preconditions.checkNotNull(paramResources);
    this.a = paramResources;
    this.b = paramGraphQLHelper;
  }

  private String b(FetchAppListParams paramFetchAppListParams)
  {
    Preconditions.checkNotNull(paramFetchAppListParams);
    return e.a(ImmutableMap.a(c, paramFetchAppListParams.a(), d, paramFetchAppListParams.b()));
  }

  public FetchAppListResult a(FetchAppListParams paramFetchAppListParams, ApiResponse paramApiResponse)
  {
    AppList localAppList = (AppList)this.b.a("fetch_app_list", 1, paramApiResponse.d()).readValueAs(AppList.class);
    if (localAppList == null)
      throw new Exception("Invalid JSON result");
    return new FetchAppListResult(localAppList, DataFreshnessResult.FROM_SERVER, System.currentTimeMillis());
  }

  public ApiRequest a(FetchAppListParams paramFetchAppListParams)
  {
    return this.b.a("fetch_app_list", b(paramFetchAppListParams));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.protocol.FetchAppListMethod
 * JD-Core Version:    0.6.0
 */