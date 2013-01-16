package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$NotificationStoriesEdge
{
  public static final GraphQlQueryNotificationStoriesEdge.NotificationStoriesEdgeField a = new GraphQlQueryNotificationStoriesEdge.NotificationStoriesEdgeField("cursor");

  public static GraphQlQueryNotificationStoriesEdge.NotificationStoriesEdgeField a(GraphQlQueryStory paramGraphQlQueryStory)
  {
    return new GraphQlQueryNotificationStoriesEdge.NotificationStoriesEdgeField("node", paramGraphQlQueryStory);
  }

  public static GraphQlQueryNotificationStoriesEdge a(GraphQlQueryNotificationStoriesEdge.NotificationStoriesEdgeField[] paramArrayOfNotificationStoriesEdgeField)
  {
    return new GraphQlQueryNotificationStoriesEdge(ImmutableList.a(paramArrayOfNotificationStoriesEdgeField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.NotificationStoriesEdge
 * JD-Core Version:    0.6.2
 */