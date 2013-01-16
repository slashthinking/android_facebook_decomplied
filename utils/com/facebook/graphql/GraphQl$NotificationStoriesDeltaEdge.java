package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$NotificationStoriesDeltaEdge
{
  public static final GraphQlQueryNotificationStoriesDeltaEdge.NotificationStoriesDeltaEdgeField a = new GraphQlQueryNotificationStoriesDeltaEdge.NotificationStoriesDeltaEdgeField("cursor");

  public static GraphQlQueryNotificationStoriesDeltaEdge.NotificationStoriesDeltaEdgeField a(GraphQlQueryNotificationStoriesDelta paramGraphQlQueryNotificationStoriesDelta)
  {
    return new GraphQlQueryNotificationStoriesDeltaEdge.NotificationStoriesDeltaEdgeField("node", paramGraphQlQueryNotificationStoriesDelta);
  }

  public static GraphQlQueryNotificationStoriesDeltaEdge a(GraphQlQueryNotificationStoriesDeltaEdge.NotificationStoriesDeltaEdgeField[] paramArrayOfNotificationStoriesDeltaEdgeField)
  {
    return new GraphQlQueryNotificationStoriesDeltaEdge(ImmutableList.a(paramArrayOfNotificationStoriesDeltaEdgeField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.NotificationStoriesDeltaEdge
 * JD-Core Version:    0.6.2
 */