package com.facebook.appcenter.protocol;

import android.content.res.Resources;
import com.facebook.appcenter.graphql.model.AppCenterCategoryList;
import com.facebook.appcenter.service.FetchAppCategoryParams;
import com.facebook.graphql.GraphQl;
import com.facebook.graphql.GraphQl.AppCenter;
import com.facebook.graphql.GraphQl.AppCenterCategoryItem;
import com.facebook.graphql.GraphQlQuery;
import com.facebook.graphql.GraphQlQueryAppCenter.AppCenterField;
import com.facebook.graphql.GraphQlQueryAppCenterCategoryItem;
import com.facebook.graphql.GraphQlQueryAppCenterCategoryItem.AppCenterCategoryItemField;
import com.facebook.graphql.GraphQlQueryAppCenterCategoryItem.CallOnAppCenterCategoryItem;
import com.facebook.graphql.GraphQlQueryRootCallNode;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.facebook.orca.server.DataFreshnessResult;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

public class FetchAppCategoryMethod
  implements ApiMethod<FetchAppCategoryParams, FetchAppCategoryResult>
{
  private static final GraphQlQuery c;
  private Resources a;
  private GraphQLHelper b;

  static
  {
    GraphQlQueryRootCallNode localGraphQlQueryRootCallNode = GraphQl.a("124762661005053");
    GraphQlQueryAppCenter.AppCenterField[] arrayOfAppCenterField = new GraphQlQueryAppCenter.AppCenterField[1];
    GraphQlQueryAppCenterCategoryItem.CallOnAppCenterCategoryItem[] arrayOfCallOnAppCenterCategoryItem = new GraphQlQueryAppCenterCategoryItem.CallOnAppCenterCategoryItem[1];
    arrayOfCallOnAppCenterCategoryItem[0] = GraphQl.AppCenterCategoryItem.a("ANDROID");
    GraphQlQueryAppCenterCategoryItem localGraphQlQueryAppCenterCategoryItem = GraphQl.AppCenterCategoryItem.a(arrayOfCallOnAppCenterCategoryItem);
    GraphQlQueryAppCenterCategoryItem.AppCenterCategoryItemField[] arrayOfAppCenterCategoryItemField = new GraphQlQueryAppCenterCategoryItem.AppCenterCategoryItemField[2];
    arrayOfAppCenterCategoryItemField[0] = GraphQl.AppCenterCategoryItem.a;
    arrayOfAppCenterCategoryItemField[1] = GraphQl.AppCenterCategoryItem.b;
    arrayOfAppCenterField[0] = GraphQl.AppCenter.a(localGraphQlQueryAppCenterCategoryItem.a(arrayOfAppCenterCategoryItemField));
    c = localGraphQlQueryRootCallNode.a(GraphQl.AppCenter.a(arrayOfAppCenterField));
  }

  public FetchAppCategoryMethod(Resources paramResources, GraphQLHelper paramGraphQLHelper)
  {
    Preconditions.checkNotNull(paramResources);
    this.a = paramResources;
    this.b = paramGraphQLHelper;
  }

  private String b(FetchAppCategoryParams paramFetchAppCategoryParams)
  {
    ImmutableMap localImmutableMap = ImmutableMap.j();
    return c.a(localImmutableMap);
  }

  public FetchAppCategoryResult a(FetchAppCategoryParams paramFetchAppCategoryParams, ApiResponse paramApiResponse)
  {
    AppCenterCategoryList localAppCenterCategoryList = (AppCenterCategoryList)this.b.a("fetch_app_categories", 1, paramApiResponse.d()).readValueAs(AppCenterCategoryList.class);
    if (localAppCenterCategoryList == null)
      throw new Exception("Invalid JSON result");
    return new FetchAppCategoryResult(localAppCenterCategoryList, DataFreshnessResult.FROM_SERVER, System.currentTimeMillis());
  }

  public ApiRequest a(FetchAppCategoryParams paramFetchAppCategoryParams)
  {
    return this.b.a("fetch_app_categories", b(paramFetchAppCategoryParams));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.protocol.FetchAppCategoryMethod
 * JD-Core Version:    0.6.0
 */