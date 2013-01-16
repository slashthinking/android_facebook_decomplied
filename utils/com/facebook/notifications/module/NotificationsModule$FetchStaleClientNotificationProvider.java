package com.facebook.notifications.module;

import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.notifications.protocol.FetchStaleClientNotificationMethod;
import com.facebook.orca.inject.AbstractProvider;

class NotificationsModule$FetchStaleClientNotificationProvider extends AbstractProvider<FetchStaleClientNotificationMethod>
{
  private NotificationsModule$FetchStaleClientNotificationProvider(NotificationsModule paramNotificationsModule)
  {
  }

  public FetchStaleClientNotificationMethod a()
  {
    return new FetchStaleClientNotificationMethod((GraphQLHelper)b(GraphQLHelper.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.module.NotificationsModule.FetchStaleClientNotificationProvider
 * JD-Core Version:    0.6.2
 */