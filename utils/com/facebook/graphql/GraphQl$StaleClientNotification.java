package com.facebook.graphql;

import com.google.common.collect.ImmutableList;

public class GraphQl$StaleClientNotification
{
  public static final GraphQlQueryStaleClientNotification.StaleClientNotificationField a = new GraphQlQueryStaleClientNotification.StaleClientNotificationField("message");
  public static final GraphQlQueryStaleClientNotification.StaleClientNotificationField b = new GraphQlQueryStaleClientNotification.StaleClientNotificationField("link");
  public static final GraphQlQueryStaleClientNotification.StaleClientNotificationField c = new GraphQlQueryStaleClientNotification.StaleClientNotificationField("delay_interval_type");
  public static final GraphQlQueryStaleClientNotification.StaleClientNotificationField d = new GraphQlQueryStaleClientNotification.StaleClientNotificationField("notification_id");

  public static GraphQlQueryStaleClientNotification a(GraphQlQueryStaleClientNotification.StaleClientNotificationField[] paramArrayOfStaleClientNotificationField)
  {
    return new GraphQlQueryStaleClientNotification(null, ImmutableList.a(paramArrayOfStaleClientNotificationField), null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.graphql.GraphQl.StaleClientNotification
 * JD-Core Version:    0.6.2
 */