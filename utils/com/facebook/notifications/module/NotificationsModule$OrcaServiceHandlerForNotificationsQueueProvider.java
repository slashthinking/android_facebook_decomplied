package com.facebook.notifications.module;

import com.facebook.notifications.protocol.NotificationsServiceHandler;
import com.facebook.notifications.provider.GQLNotificationsContentProviderHandler;
import com.facebook.notifications.provider.NotificationsContentProviderHandler;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.server.FilterChainLink;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceHandler.Filter;

class NotificationsModule$OrcaServiceHandlerForNotificationsQueueProvider extends AbstractProvider<OrcaServiceHandler>
{
  private NotificationsModule$OrcaServiceHandlerForNotificationsQueueProvider(NotificationsModule paramNotificationsModule)
  {
  }

  public OrcaServiceHandler a()
  {
    return new FilterChainLink((OrcaServiceHandler.Filter)b(NotificationsContentProviderHandler.class), new FilterChainLink((OrcaServiceHandler.Filter)b(GQLNotificationsContentProviderHandler.class), (OrcaServiceHandler)b(NotificationsServiceHandler.class)));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.module.NotificationsModule.OrcaServiceHandlerForNotificationsQueueProvider
 * JD-Core Version:    0.6.2
 */