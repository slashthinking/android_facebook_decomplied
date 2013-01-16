package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$NotificationStoriesConnection
{
  public static final GraphQlQueryNotificationStoriesConnection.NotificationStoriesConnectionField a = new GraphQlQueryNotificationStoriesConnection.NotificationStoriesConnectionField("count");

  public static GraphQlQueryCallAfter1 a(GraphQlQueryParam paramGraphQlQueryParam)
  {
    return new GraphQlQueryCallAfter1(paramGraphQlQueryParam);
  }

  public static GraphQlQueryNotificationStoriesConnection.NotificationStoriesConnectionField a(GraphQlQueryNotificationStoriesDeltaConnection paramGraphQlQueryNotificationStoriesDeltaConnection)
  {
    return new GraphQlQueryNotificationStoriesConnection.NotificationStoriesConnectionField("deltas", paramGraphQlQueryNotificationStoriesDeltaConnection);
  }

  public static GraphQlQueryNotificationStoriesConnection.NotificationStoriesConnectionField a(GraphQlQueryNotificationStoriesEdge paramGraphQlQueryNotificationStoriesEdge)
  {
    return new GraphQlQueryNotificationStoriesConnection.NotificationStoriesConnectionField("edges", paramGraphQlQueryNotificationStoriesEdge);
  }

  public static GraphQlQueryNotificationStoriesConnection a(GraphQlQueryNotificationStoriesConnection.CallOnNotificationStoriesConnection[] paramArrayOfCallOnNotificationStoriesConnection)
  {
    return new GraphQlQueryNotificationStoriesConnection(ImmutableList.a(paramArrayOfCallOnNotificationStoriesConnection), null, null);
  }

  public static GraphQlQueryCallBefore1 b(GraphQlQueryParam paramGraphQlQueryParam)
  {
    return new GraphQlQueryCallBefore1(paramGraphQlQueryParam);
  }

  public static GraphQlQueryCallFirst1 c(GraphQlQueryParam paramGraphQlQueryParam)
  {
    return new GraphQlQueryCallFirst1(paramGraphQlQueryParam);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.NotificationStoriesConnection
 * JD-Core Version:    0.6.2
 */