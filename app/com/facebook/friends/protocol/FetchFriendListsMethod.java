package com.facebook.friends.protocol;

import android.content.res.Resources;
import com.facebook.graphql.GraphQl;
import com.facebook.graphql.GraphQl.FriendList;
import com.facebook.graphql.GraphQl.FriendListsConnection;
import com.facebook.graphql.GraphQl.User;
import com.facebook.graphql.GraphQlQuery;
import com.facebook.graphql.GraphQlQueryFriendList.FriendListField;
import com.facebook.graphql.GraphQlQueryFriendListsConnection.FriendListsConnectionField;
import com.facebook.graphql.GraphQlQueryRootCallActor;
import com.facebook.graphql.GraphQlQueryUser.UserField;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.graphql.model.FriendListList;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.collect.ImmutableMap;

public class FetchFriendListsMethod
  implements ApiMethod<Object, FriendListList>
{
  private static final GraphQlQuery a;
  private Resources b;
  private GraphQLHelper c;

  static
  {
    GraphQlQueryRootCallActor localGraphQlQueryRootCallActor = GraphQl.a();
    GraphQlQueryUser.UserField[] arrayOfUserField = new GraphQlQueryUser.UserField[1];
    GraphQlQueryFriendListsConnection.FriendListsConnectionField[] arrayOfFriendListsConnectionField = new GraphQlQueryFriendListsConnection.FriendListsConnectionField[1];
    GraphQlQueryFriendList.FriendListField[] arrayOfFriendListField = new GraphQlQueryFriendList.FriendListField[3];
    arrayOfFriendListField[0] = GraphQl.FriendList.a;
    arrayOfFriendListField[1] = GraphQl.FriendList.c;
    arrayOfFriendListField[2] = GraphQl.FriendList.d;
    arrayOfFriendListsConnectionField[0] = GraphQl.FriendListsConnection.a(GraphQl.FriendList.a(arrayOfFriendListField));
    arrayOfUserField[0] = GraphQl.User.a(GraphQl.FriendListsConnection.a(arrayOfFriendListsConnectionField));
    a = localGraphQlQueryRootCallActor.a(GraphQl.User.a(arrayOfUserField));
  }

  public FetchFriendListsMethod(Resources paramResources, GraphQLHelper paramGraphQLHelper)
  {
    this.b = paramResources;
    this.c = paramGraphQLHelper;
  }

  private String a()
  {
    ImmutableMap localImmutableMap = ImmutableMap.j();
    return a.a(localImmutableMap);
  }

  public ApiRequest a(Object paramObject)
  {
    return this.c.a("fetch_friendlists", a());
  }

  public FriendListList b(Object paramObject, ApiResponse paramApiResponse)
  {
    FriendListList localFriendListList = (FriendListList)this.c.a("fetch_friendlists", 2, paramApiResponse.d()).readValueAs(FriendListList.class);
    if (localFriendListList == null)
      throw new Exception("Invalid JSON result");
    return localFriendListList;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.protocol.FetchFriendListsMethod
 * JD-Core Version:    0.6.0
 */