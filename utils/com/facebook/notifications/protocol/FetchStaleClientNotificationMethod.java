package com.facebook.notifications.protocol;

import com.facebook.graphql.GraphQl;
import com.facebook.graphql.GraphQl.StaleClientNotification;
import com.facebook.graphql.GraphQl.User;
import com.facebook.graphql.GraphQlQuery;
import com.facebook.graphql.GraphQlQueryRootCallActor;
import com.facebook.graphql.GraphQlQueryStaleClientNotification.StaleClientNotificationField;
import com.facebook.graphql.GraphQlQueryUser.UserField;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.orca.protocol.base.ApiMethod;
import com.facebook.orca.protocol.base.ApiRequest;
import com.facebook.orca.protocol.base.ApiResponse;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.collect.ImmutableMap;

public class FetchStaleClientNotificationMethod
  implements ApiMethod<Void, FetchStaleClientNotificationMethod.Result>
{
  private static final GraphQlQuery a = localGraphQlQueryRootCallActor.a(GraphQl.User.a(arrayOfUserField));
  private final GraphQLHelper b;

  static
  {
    GraphQlQueryRootCallActor localGraphQlQueryRootCallActor = GraphQl.a();
    GraphQlQueryUser.UserField[] arrayOfUserField = new GraphQlQueryUser.UserField[1];
    GraphQlQueryStaleClientNotification.StaleClientNotificationField[] arrayOfStaleClientNotificationField = new GraphQlQueryStaleClientNotification.StaleClientNotificationField[3];
    arrayOfStaleClientNotificationField[0] = GraphQl.StaleClientNotification.a;
    arrayOfStaleClientNotificationField[1] = GraphQl.StaleClientNotification.b;
    arrayOfStaleClientNotificationField[2] = GraphQl.StaleClientNotification.d;
    arrayOfUserField[0] = GraphQl.User.a(GraphQl.StaleClientNotification.a(arrayOfStaleClientNotificationField));
  }

  public FetchStaleClientNotificationMethod(GraphQLHelper paramGraphQLHelper)
  {
    this.b = paramGraphQLHelper;
  }

  private String a()
  {
    ImmutableMap localImmutableMap = ImmutableMap.j();
    return a.a(localImmutableMap);
  }

  public FetchStaleClientNotificationMethod.Result a(Void paramVoid, ApiResponse paramApiResponse)
  {
    return (FetchStaleClientNotificationMethod.Result)this.b.a("fetchStaleClientNotification", 2, paramApiResponse.d()).readValueAs(FetchStaleClientNotificationMethod.Result.class);
  }

  public ApiRequest a(Void paramVoid)
  {
    return this.b.a("fetchStaleClientNotification", a());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.protocol.FetchStaleClientNotificationMethod
 * JD-Core Version:    0.6.2
 */