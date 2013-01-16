package com.facebook.friends.protocol;

import android.content.res.Resources;
import com.facebook.graphql.GraphQl;
import com.facebook.graphql.GraphQl.FriendingPossibilitiesConnection;
import com.facebook.graphql.GraphQl.FriendingPossibilitiesEdge;
import com.facebook.graphql.GraphQl.Image;
import com.facebook.graphql.GraphQl.MutualFriendsConnection;
import com.facebook.graphql.GraphQl.User;
import com.facebook.graphql.GraphQl.Viewer;
import com.facebook.graphql.GraphQlQuery;
import com.facebook.graphql.GraphQlQueryDefaults;
import com.facebook.graphql.GraphQlQueryFriendingPossibilitiesConnection;
import com.facebook.graphql.GraphQlQueryFriendingPossibilitiesConnection.CallOnFriendingPossibilitiesConnection;
import com.facebook.graphql.GraphQlQueryFriendingPossibilitiesConnection.FriendingPossibilitiesConnectionField;
import com.facebook.graphql.GraphQlQueryFriendingPossibilitiesEdge.FriendingPossibilitiesEdgeField;
import com.facebook.graphql.GraphQlQueryImage;
import com.facebook.graphql.GraphQlQueryImage.CallOnImage;
import com.facebook.graphql.GraphQlQueryImage.ImageField;
import com.facebook.graphql.GraphQlQueryMutualFriendsConnection.MutualFriendsConnectionField;
import com.facebook.graphql.GraphQlQueryParam;
import com.facebook.graphql.GraphQlQueryRootCallViewer;
import com.facebook.graphql.GraphQlQueryUser.UserField;
import com.facebook.graphql.GraphQlQueryViewer.ViewerField;
import com.facebook.graphql.GraphQlUtil;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.collect.ImmutableMap;

public class FetchFriendRequestsMethod
  implements ApiMethod<FetchFriendingPossibilitiesParams, FetchFriendRequestsMethod.Result>
{
  private static final GraphQlQueryParam a = GraphQlQueryParam.a("after_param");
  private static final GraphQlQueryParam b = GraphQlQueryParam.a("first_param");
  private static final GraphQlQueryParam c = GraphQlQueryParam.a("picture_size");
  private static final GraphQlQuery d;
  private final GraphQLHelper e;

  static
  {
    GraphQlQueryRootCallViewer localGraphQlQueryRootCallViewer = GraphQl.b();
    GraphQlQueryViewer.ViewerField[] arrayOfViewerField = new GraphQlQueryViewer.ViewerField[1];
    GraphQlQueryFriendingPossibilitiesConnection.CallOnFriendingPossibilitiesConnection[] arrayOfCallOnFriendingPossibilitiesConnection = new GraphQlQueryFriendingPossibilitiesConnection.CallOnFriendingPossibilitiesConnection[2];
    arrayOfCallOnFriendingPossibilitiesConnection[0] = GraphQl.FriendingPossibilitiesConnection.a(a);
    arrayOfCallOnFriendingPossibilitiesConnection[1] = GraphQl.FriendingPossibilitiesConnection.b(b);
    GraphQlQueryFriendingPossibilitiesConnection localGraphQlQueryFriendingPossibilitiesConnection = GraphQl.FriendingPossibilitiesConnection.a(arrayOfCallOnFriendingPossibilitiesConnection);
    GraphQlQueryFriendingPossibilitiesConnection.FriendingPossibilitiesConnectionField[] arrayOfFriendingPossibilitiesConnectionField = new GraphQlQueryFriendingPossibilitiesConnection.FriendingPossibilitiesConnectionField[2];
    GraphQlQueryFriendingPossibilitiesEdge.FriendingPossibilitiesEdgeField[] arrayOfFriendingPossibilitiesEdgeField = new GraphQlQueryFriendingPossibilitiesEdge.FriendingPossibilitiesEdgeField[3];
    arrayOfFriendingPossibilitiesEdgeField[0] = GraphQl.FriendingPossibilitiesEdge.b;
    GraphQlQueryUser.UserField[] arrayOfUserField1 = new GraphQlQueryUser.UserField[5];
    arrayOfUserField1[0] = GraphQl.User.a;
    arrayOfUserField1[1] = GraphQl.User.c;
    arrayOfUserField1[2] = GraphQl.User.j;
    GraphQlQueryImage.CallOnImage[] arrayOfCallOnImage = new GraphQlQueryImage.CallOnImage[1];
    arrayOfCallOnImage[0] = GraphQl.Image.a(c, c);
    GraphQlQueryImage localGraphQlQueryImage = GraphQl.Image.a(arrayOfCallOnImage);
    GraphQlQueryImage.ImageField[] arrayOfImageField = new GraphQlQueryImage.ImageField[1];
    arrayOfImageField[0] = GraphQl.Image.a;
    arrayOfUserField1[3] = GraphQl.User.a(localGraphQlQueryImage.a(arrayOfImageField));
    GraphQlQueryMutualFriendsConnection.MutualFriendsConnectionField[] arrayOfMutualFriendsConnectionField = new GraphQlQueryMutualFriendsConnection.MutualFriendsConnectionField[1];
    arrayOfMutualFriendsConnectionField[0] = GraphQl.MutualFriendsConnection.a;
    arrayOfUserField1[4] = GraphQl.User.a(GraphQl.MutualFriendsConnection.a(arrayOfMutualFriendsConnectionField));
    arrayOfFriendingPossibilitiesEdgeField[1] = GraphQl.FriendingPossibilitiesEdge.a(GraphQl.User.a(arrayOfUserField1));
    GraphQlQueryUser.UserField[] arrayOfUserField2 = new GraphQlQueryUser.UserField[2];
    arrayOfUserField2[0] = GraphQl.User.a;
    arrayOfUserField2[1] = GraphQl.User.c;
    arrayOfFriendingPossibilitiesEdgeField[2] = GraphQl.FriendingPossibilitiesEdge.b(GraphQl.User.a(arrayOfUserField2));
    arrayOfFriendingPossibilitiesConnectionField[0] = GraphQl.FriendingPossibilitiesConnection.a(GraphQl.FriendingPossibilitiesEdge.a(arrayOfFriendingPossibilitiesEdgeField));
    arrayOfFriendingPossibilitiesConnectionField[1] = GraphQl.FriendingPossibilitiesConnection.a(GraphQlQueryDefaults.k);
    arrayOfViewerField[0] = GraphQl.Viewer.a(localGraphQlQueryFriendingPossibilitiesConnection.a(arrayOfFriendingPossibilitiesConnectionField));
    d = localGraphQlQueryRootCallViewer.a(GraphQl.Viewer.a(arrayOfViewerField));
  }

  public FetchFriendRequestsMethod(Resources paramResources, GraphQLHelper paramGraphQLHelper)
  {
    this.e = paramGraphQLHelper;
  }

  private String b(FetchFriendingPossibilitiesParams paramFetchFriendingPossibilitiesParams)
  {
    return d.a(ImmutableMap.a(a, GraphQlUtil.b(paramFetchFriendingPossibilitiesParams.c), b, String.valueOf(paramFetchFriendingPossibilitiesParams.b), c, String.valueOf(paramFetchFriendingPossibilitiesParams.a)));
  }

  public FetchFriendRequestsMethod.Result a(FetchFriendingPossibilitiesParams paramFetchFriendingPossibilitiesParams, ApiResponse paramApiResponse)
  {
    return (FetchFriendRequestsMethod.Result)this.e.a("fetchFriendRequests", 2, paramApiResponse.d()).readValueAs(FetchFriendRequestsMethod.Result.class);
  }

  public ApiRequest a(FetchFriendingPossibilitiesParams paramFetchFriendingPossibilitiesParams)
  {
    return this.e.a("fetchFriendRequests", b(paramFetchFriendingPossibilitiesParams));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.protocol.FetchFriendRequestsMethod
 * JD-Core Version:    0.6.0
 */