package com.facebook.notifications.module;

import com.facebook.notifications.protocol.FetchGraphQLNotificationsMethod;
import com.facebook.notifications.protocol.FetchNotificationsMethod;
import com.facebook.notifications.protocol.FetchStaleClientNotificationMethod;
import com.facebook.notifications.protocol.GQLNotificationsChangeSeenStateMethod;
import com.facebook.notifications.protocol.GetNotificationsSettingsMethod;
import com.facebook.notifications.protocol.NotificationsChangeReadMethod;
import com.facebook.notifications.protocol.NotificationsChangeSettingsMethod;
import com.facebook.notifications.protocol.NotificationsServiceHandler;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.base.SingleMethodRunner;

class NotificationsModule$NotificationsHandlerProvider extends AbstractProvider<NotificationsServiceHandler>
{
  private NotificationsModule$NotificationsHandlerProvider(NotificationsModule paramNotificationsModule)
  {
  }

  public NotificationsServiceHandler a()
  {
    return new NotificationsServiceHandler(a(SingleMethodRunner.class), (FetchNotificationsMethod)b(FetchNotificationsMethod.class), (NotificationsChangeReadMethod)b(NotificationsChangeReadMethod.class), (NotificationsChangeSettingsMethod)b(NotificationsChangeSettingsMethod.class), (FetchGraphQLNotificationsMethod)b(FetchGraphQLNotificationsMethod.class), (FetchStaleClientNotificationMethod)b(FetchStaleClientNotificationMethod.class), (GetNotificationsSettingsMethod)b(GetNotificationsSettingsMethod.class), (GQLNotificationsChangeSeenStateMethod)b(GQLNotificationsChangeSeenStateMethod.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.module.NotificationsModule.NotificationsHandlerProvider
 * JD-Core Version:    0.6.2
 */