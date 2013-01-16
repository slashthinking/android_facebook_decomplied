package com.facebook.notifications.module;

import com.facebook.notifications.protocol.GetNotificationsSettingsMethod;
import com.facebook.orca.inject.AbstractProvider;

class NotificationsModule$GetNotificationsSettingsProvider extends AbstractProvider<GetNotificationsSettingsMethod>
{
  private NotificationsModule$GetNotificationsSettingsProvider(NotificationsModule paramNotificationsModule)
  {
  }

  public GetNotificationsSettingsMethod a()
  {
    return new GetNotificationsSettingsMethod();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.module.NotificationsModule.GetNotificationsSettingsProvider
 * JD-Core Version:    0.6.2
 */