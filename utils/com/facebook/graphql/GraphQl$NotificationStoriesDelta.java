package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$NotificationStoriesDelta
{
  public static final GraphQlQueryNotificationStoriesDelta.NotificationStoriesDeltaField a = new GraphQlQueryNotificationStoriesDelta.NotificationStoriesDeltaField("id");
  public static final GraphQlQueryNotificationStoriesDelta.NotificationStoriesDeltaField b = new GraphQlQueryNotificationStoriesDelta.NotificationStoriesDeltaField("url.site(mobile)");
  public static final GraphQlQueryNotificationStoriesDelta.NotificationStoriesDeltaField c = new GraphQlQueryNotificationStoriesDelta.NotificationStoriesDeltaField("removed");
  public static final GraphQlQueryNotificationStoriesDelta.NotificationStoriesDeltaField d = new GraphQlQueryNotificationStoriesDelta.NotificationStoriesDeltaField("unchanged");

  public static GraphQlQueryNotificationStoriesDelta.NotificationStoriesDeltaField a(GraphQlQueryStory paramGraphQlQueryStory)
  {
    return new GraphQlQueryNotificationStoriesDelta.NotificationStoriesDeltaField("modified", paramGraphQlQueryStory);
  }

  public static GraphQlQueryNotificationStoriesDelta a(GraphQlQueryNotificationStoriesDelta.NotificationStoriesDeltaField[] paramArrayOfNotificationStoriesDeltaField)
  {
    return new GraphQlQueryNotificationStoriesDelta(ImmutableList.a(paramArrayOfNotificationStoriesDeltaField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.NotificationStoriesDelta
 * JD-Core Version:    0.6.2
 */