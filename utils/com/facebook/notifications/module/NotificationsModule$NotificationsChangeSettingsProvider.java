package com.facebook.notifications.module;

import com.facebook.notifications.protocol.NotificationsChangeSettingsMethod;
import com.facebook.orca.inject.AbstractProvider;

class NotificationsModule$NotificationsChangeSettingsProvider extends AbstractProvider<NotificationsChangeSettingsMethod>
{
  private NotificationsModule$NotificationsChangeSettingsProvider(NotificationsModule paramNotificationsModule)
  {
  }

  public NotificationsChangeSettingsMethod a()
  {
    return new NotificationsChangeSettingsMethod();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.module.NotificationsModule.NotificationsChangeSettingsProvider
 * JD-Core Version:    0.6.2
 */