package com.facebook.friends.protocol;

import android.content.res.Resources;
import com.facebook.graphql.GraphQl;
import com.facebook.graphql.GraphQl.Image;
import com.facebook.graphql.GraphQl.MutualFriendsConnection;
import com.facebook.graphql.GraphQl.PeopleYouMayKnowConnection;
import com.facebook.graphql.GraphQl.User;
import com.facebook.graphql.GraphQlQuery;
import com.facebook.graphql.GraphQlQueryDefaults;
import com.facebook.graphql.GraphQlQueryImage;
import com.facebook.graphql.GraphQlQueryImage.CallOnImage;
import com.facebook.graphql.GraphQlQueryImage.ImageField;
import com.facebook.graphql.GraphQlQueryMutualFriendsConnection.MutualFriendsConnectionField;
import com.facebook.graphql.GraphQlQueryParam;
import com.facebook.graphql.GraphQlQueryPeopleYouMayKnowConnection;
import com.facebook.graphql.GraphQlQueryPeopleYouMayKnowConnection.CallOnPeopleYouMayKnowConnection;
import com.facebook.graphql.GraphQlQueryPeopleYouMayKnowConnection.PeopleYouMayKnowConnectionField;
import com.facebook.graphql.GraphQlQueryRootCallActor;
import com.facebook.graphql.GraphQlQueryUser.UserField;
import com.facebook.graphql.GraphQlUtil;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.collect.ImmutableMap;

public class FetchPeopleYouMayKnowMethod
  implements ApiMethod<FetchFriendingPossibilitiesParams, FetchPeopleYouMayKnowMethod.Result>
{
  private static final GraphQlQueryParam a = GraphQlQueryParam.a("after_param");
  private static final GraphQlQueryParam b = GraphQlQueryParam.a("first_param");
  private static final GraphQlQueryParam c = GraphQlQueryParam.a("picture_size");
  private static final GraphQlQuery d;
  private final GraphQLHelper e;

  static
  {
    GraphQlQueryRootCallActor localGraphQlQueryRootCallActor = GraphQl.a();
    GraphQlQueryUser.UserField[] arrayOfUserField1 = new GraphQlQueryUser.UserField[1];
    GraphQlQueryPeopleYouMayKnowConnection.CallOnPeopleYouMayKnowConnection[] arrayOfCallOnPeopleYouMayKnowConnection = new GraphQlQueryPeopleYouMayKnowConnection.CallOnPeopleYouMayKnowConnection[3];
    arrayOfCallOnPeopleYouMayKnowConnection[0] = GraphQl.PeopleYouMayKnowConnection.a("mobile_jewel");
    arrayOfCallOnPeopleYouMayKnowConnection[1] = GraphQl.PeopleYouMayKnowConnection.a(a);
    arrayOfCallOnPeopleYouMayKnowConnection[2] = GraphQl.PeopleYouMayKnowConnection.b(b);
    GraphQlQueryPeopleYouMayKnowConnection localGraphQlQueryPeopleYouMayKnowConnection = GraphQl.PeopleYouMayKnowConnection.a(arrayOfCallOnPeopleYouMayKnowConnection);
    GraphQlQueryPeopleYouMayKnowConnection.PeopleYouMayKnowConnectionField[] arrayOfPeopleYouMayKnowConnectionField = new GraphQlQueryPeopleYouMayKnowConnection.PeopleYouMayKnowConnectionField[2];
    GraphQlQueryUser.UserField[] arrayOfUserField2 = new GraphQlQueryUser.UserField[4];
    arrayOfUserField2[0] = GraphQl.User.c;
    GraphQlQueryImage.CallOnImage[] arrayOfCallOnImage = new GraphQlQueryImage.CallOnImage[1];
    arrayOfCallOnImage[0] = GraphQl.Image.a(c, c);
    GraphQlQueryImage localGraphQlQueryImage = GraphQl.Image.a(arrayOfCallOnImage);
    GraphQlQueryImage.ImageField[] arrayOfImageField = new GraphQlQueryImage.ImageField[1];
    arrayOfImageField[0] = GraphQl.Image.a;
    arrayOfUserField2[1] = GraphQl.User.a(localGraphQlQueryImage.a(arrayOfImageField));
    arrayOfUserField2[2] = GraphQl.User.a;
    GraphQlQueryMutualFriendsConnection.MutualFriendsConnectionField[] arrayOfMutualFriendsConnectionField = new GraphQlQueryMutualFriendsConnection.MutualFriendsConnectionField[1];
    arrayOfMutualFriendsConnectionField[0] = GraphQl.MutualFriendsConnection.a;
    arrayOfUserField2[3] = GraphQl.User.a(GraphQl.MutualFriendsConnection.a(arrayOfMutualFriendsConnectionField));
    arrayOfPeopleYouMayKnowConnectionField[0] = GraphQl.PeopleYouMayKnowConnection.a(GraphQl.User.a(arrayOfUserField2));
    arrayOfPeopleYouMayKnowConnectionField[1] = GraphQl.PeopleYouMayKnowConnection.a(GraphQlQueryDefaults.k);
    arrayOfUserField1[0] = GraphQl.User.a(localGraphQlQueryPeopleYouMayKnowConnection.a(arrayOfPeopleYouMayKnowConnectionField));
    d = localGraphQlQueryRootCallActor.a(GraphQl.User.a(arrayOfUserField1));
  }

  public FetchPeopleYouMayKnowMethod(Resources paramResources, GraphQLHelper paramGraphQLHelper)
  {
    this.e = paramGraphQLHelper;
  }

  private String b(FetchFriendingPossibilitiesParams paramFetchFriendingPossibilitiesParams)
  {
    return d.a(ImmutableMap.a(a, GraphQlUtil.b(paramFetchFriendingPossibilitiesParams.c), b, String.valueOf(paramFetchFriendingPossibilitiesParams.b), c, String.valueOf(paramFetchFriendingPossibilitiesParams.a)));
  }

  public FetchPeopleYouMayKnowMethod.Result a(FetchFriendingPossibilitiesParams paramFetchFriendingPossibilitiesParams, ApiResponse paramApiResponse)
  {
    return (FetchPeopleYouMayKnowMethod.Result)this.e.a("fetchPeopleYouMayKnow", 2, paramApiResponse.d()).readValueAs(FetchPeopleYouMayKnowMethod.Result.class);
  }

  public ApiRequest a(FetchFriendingPossibilitiesParams paramFetchFriendingPossibilitiesParams)
  {
    return this.e.a("fetchPeopleYouMayKnow", b(paramFetchFriendingPossibilitiesParams));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.protocol.FetchPeopleYouMayKnowMethod
 * JD-Core Version:    0.6.0
 */