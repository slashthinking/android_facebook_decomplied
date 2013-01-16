package com.facebook.notifications.module;

import com.facebook.notifications.provider.NotificationsContentProviderHandler;
import com.facebook.notifications.provider.NotificationsContentProviderHelper;
import com.facebook.orca.inject.AbstractProvider;

class NotificationsModule$NotificationsContentProviderHandlerProvider extends AbstractProvider<NotificationsContentProviderHandler>
{
  private NotificationsModule$NotificationsContentProviderHandlerProvider(NotificationsModule paramNotificationsModule)
  {
  }

  public NotificationsContentProviderHandler a()
  {
    return new NotificationsContentProviderHandler((NotificationsContentProviderHelper)b(NotificationsContentProviderHelper.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.module.NotificationsModule.NotificationsContentProviderHandlerProvider
 * JD-Core Version:    0.6.2
 */