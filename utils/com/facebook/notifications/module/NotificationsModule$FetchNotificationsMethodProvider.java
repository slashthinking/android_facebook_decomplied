package com.facebook.notifications.module;

import com.facebook.notifications.protocol.FetchNotificationsMethod;
import com.facebook.orca.inject.AbstractProvider;

class NotificationsModule$FetchNotificationsMethodProvider extends AbstractProvider<FetchNotificationsMethod>
{
  private NotificationsModule$FetchNotificationsMethodProvider(NotificationsModule paramNotificationsModule)
  {
  }

  public FetchNotificationsMethod a()
  {
    return new FetchNotificationsMethod();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.module.NotificationsModule.FetchNotificationsMethodProvider
 * JD-Core Version:    0.6.2
 */