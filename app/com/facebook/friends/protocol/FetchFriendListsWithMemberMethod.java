package com.facebook.friends.protocol;

import android.content.res.Resources;
import com.facebook.graphql.GraphQl;
import com.facebook.graphql.GraphQl.FriendList;
import com.facebook.graphql.GraphQl.FriendListsConnection;
import com.facebook.graphql.GraphQl.User;
import com.facebook.graphql.GraphQlQuery;
import com.facebook.graphql.GraphQlQueryFriendList.FriendListField;
import com.facebook.graphql.GraphQlQueryFriendListsConnection;
import com.facebook.graphql.GraphQlQueryFriendListsConnection.CallOnFriendListsConnection;
import com.facebook.graphql.GraphQlQueryFriendListsConnection.FriendListsConnectionField;
import com.facebook.graphql.GraphQlQueryParam;
import com.facebook.graphql.GraphQlQueryRootCallActor;
import com.facebook.graphql.GraphQlQueryUser.UserField;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.graphql.model.FriendListList;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.collect.ImmutableMap;

public class FetchFriendListsWithMemberMethod
  implements ApiMethod<FetchFriendListsWithMemberParams, FriendListList>
{
  private static final GraphQlQueryParam a = GraphQlQueryParam.a("user_id");
  private static final GraphQlQuery b;
  private Resources c;
  private GraphQLHelper d;

  static
  {
    GraphQlQueryRootCallActor localGraphQlQueryRootCallActor = GraphQl.a();
    GraphQlQueryUser.UserField[] arrayOfUserField = new GraphQlQueryUser.UserField[1];
    GraphQlQueryFriendListsConnection.CallOnFriendListsConnection[] arrayOfCallOnFriendListsConnection = new GraphQlQueryFriendListsConnection.CallOnFriendListsConnection[1];
    arrayOfCallOnFriendListsConnection[0] = GraphQl.FriendListsConnection.a(a);
    GraphQlQueryFriendListsConnection localGraphQlQueryFriendListsConnection = GraphQl.FriendListsConnection.a(arrayOfCallOnFriendListsConnection);
    GraphQlQueryFriendListsConnection.FriendListsConnectionField[] arrayOfFriendListsConnectionField = new GraphQlQueryFriendListsConnection.FriendListsConnectionField[1];
    GraphQlQueryFriendList.FriendListField[] arrayOfFriendListField = new GraphQlQueryFriendList.FriendListField[1];
    arrayOfFriendListField[0] = GraphQl.FriendList.a;
    arrayOfFriendListsConnectionField[0] = GraphQl.FriendListsConnection.a(GraphQl.FriendList.a(arrayOfFriendListField));
    arrayOfUserField[0] = GraphQl.User.a(localGraphQlQueryFriendListsConnection.a(arrayOfFriendListsConnectionField));
    b = localGraphQlQueryRootCallActor.a(GraphQl.User.a(arrayOfUserField));
  }

  public FetchFriendListsWithMemberMethod(Resources paramResources, GraphQLHelper paramGraphQLHelper)
  {
    this.c = paramResources;
    this.d = paramGraphQLHelper;
  }

  private String b(FetchFriendListsWithMemberParams paramFetchFriendListsWithMemberParams)
  {
    GraphQlQuery localGraphQlQuery = b;
    GraphQlQueryParam localGraphQlQueryParam = a;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Long.valueOf(paramFetchFriendListsWithMemberParams.a());
    return localGraphQlQuery.a(ImmutableMap.a(localGraphQlQueryParam, StringUtil.a("%s", arrayOfObject)));
  }

  public FriendListList a(FetchFriendListsWithMemberParams paramFetchFriendListsWithMemberParams, ApiResponse paramApiResponse)
  {
    FriendListList localFriendListList = (FriendListList)this.d.a("fetch_friendlists_with_member", 2, paramApiResponse.d()).readValueAs(FriendListList.class);
    if (localFriendListList == null)
      throw new Exception("Invalid JSON result");
    return localFriendListList;
  }

  public ApiRequest a(FetchFriendListsWithMemberParams paramFetchFriendListsWithMemberParams)
  {
    return this.d.a("fetch_friendlists_with_member", b(paramFetchFriendListsWithMemberParams));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.protocol.FetchFriendListsWithMemberMethod
 * JD-Core Version:    0.6.0
 */