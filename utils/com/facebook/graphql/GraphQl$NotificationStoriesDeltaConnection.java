package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$NotificationStoriesDeltaConnection
{
  public static final GraphQlQueryNotificationStoriesDeltaConnection.NotificationStoriesDeltaConnectionField a = new GraphQlQueryNotificationStoriesDeltaConnection.NotificationStoriesDeltaConnectionField("count");

  public static GraphQlQueryCallCacheIds1 a(GraphQlQueryParam paramGraphQlQueryParam)
  {
    return new GraphQlQueryCallCacheIds1(paramGraphQlQueryParam);
  }

  public static GraphQlQueryNotificationStoriesDeltaConnection.NotificationStoriesDeltaConnectionField a(GraphQlQueryNotificationStoriesDeltaEdge paramGraphQlQueryNotificationStoriesDeltaEdge)
  {
    return new GraphQlQueryNotificationStoriesDeltaConnection.NotificationStoriesDeltaConnectionField("edges", paramGraphQlQueryNotificationStoriesDeltaEdge);
  }

  public static GraphQlQueryNotificationStoriesDeltaConnection a(GraphQlQueryNotificationStoriesDeltaConnection.CallOnNotificationStoriesDeltaConnection[] paramArrayOfCallOnNotificationStoriesDeltaConnection)
  {
    return new GraphQlQueryNotificationStoriesDeltaConnection(ImmutableList.a(paramArrayOfCallOnNotificationStoriesDeltaConnection), null, null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.NotificationStoriesDeltaConnection
 * JD-Core Version:    0.6.2
 */