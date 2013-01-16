package com.facebook.notifications.module;

import com.facebook.notifications.util.NotificationsLastUpdatedTimeUtil;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class NotificationsModule$NotificationsLastUpdatedTimeUtilProvider extends AbstractProvider<NotificationsLastUpdatedTimeUtil>
{
  private NotificationsModule$NotificationsLastUpdatedTimeUtilProvider(NotificationsModule paramNotificationsModule)
  {
  }

  public NotificationsLastUpdatedTimeUtil a()
  {
    return new NotificationsLastUpdatedTimeUtil((OrcaSharedPreferences)b(OrcaSharedPreferences.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.module.NotificationsModule.NotificationsLastUpdatedTimeUtilProvider
 * JD-Core Version:    0.6.2
 */