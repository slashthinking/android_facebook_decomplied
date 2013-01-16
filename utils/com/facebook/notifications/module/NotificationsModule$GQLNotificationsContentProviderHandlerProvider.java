package com.facebook.notifications.module;

import com.facebook.notifications.provider.GQLNotificationsContentProviderHandler;
import com.facebook.notifications.provider.GQLNotificationsContentProviderHelper;
import com.facebook.orca.inject.AbstractProvider;

class NotificationsModule$GQLNotificationsContentProviderHandlerProvider extends AbstractProvider<GQLNotificationsContentProviderHandler>
{
  private NotificationsModule$GQLNotificationsContentProviderHandlerProvider(NotificationsModule paramNotificationsModule)
  {
  }

  public GQLNotificationsContentProviderHandler a()
  {
    return new GQLNotificationsContentProviderHandler((GQLNotificationsContentProviderHelper)b(GQLNotificationsContentProviderHelper.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.module.NotificationsModule.GQLNotificationsContentProviderHandlerProvider
 * JD-Core Version:    0.6.2
 */