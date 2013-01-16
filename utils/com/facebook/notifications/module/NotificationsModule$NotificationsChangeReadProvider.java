package com.facebook.notifications.module;

import com.facebook.notifications.protocol.NotificationsChangeReadMethod;
import com.facebook.orca.inject.AbstractProvider;

class NotificationsModule$NotificationsChangeReadProvider extends AbstractProvider<NotificationsChangeReadMethod>
{
  private NotificationsModule$NotificationsChangeReadProvider(NotificationsModule paramNotificationsModule)
  {
  }

  public NotificationsChangeReadMethod a()
  {
    return new NotificationsChangeReadMethod();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.module.NotificationsModule.NotificationsChangeReadProvider
 * JD-Core Version:    0.6.2
 */