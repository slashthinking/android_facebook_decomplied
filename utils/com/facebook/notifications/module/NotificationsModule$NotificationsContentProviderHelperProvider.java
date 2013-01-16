package com.facebook.notifications.module;

import android.content.ContentResolver;
import com.facebook.ipc.notifications.NotificationsContract;
import com.facebook.notifications.provider.NotificationsContentProviderHelper;
import com.facebook.notifications.util.NotificationsLastUpdatedTimeUtil;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;

class NotificationsModule$NotificationsContentProviderHelperProvider extends AbstractProvider<NotificationsContentProviderHelper>
{
  private NotificationsModule$NotificationsContentProviderHelperProvider(NotificationsModule paramNotificationsModule)
  {
  }

  public NotificationsContentProviderHelper a()
  {
    return new NotificationsContentProviderHelper((NotificationsContract)b(NotificationsContract.class), (ContentResolver)b(ContentResolver.class, FromApplication.class), (NotificationsLastUpdatedTimeUtil)b(NotificationsLastUpdatedTimeUtil.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.module.NotificationsModule.NotificationsContentProviderHelperProvider
 * JD-Core Version:    0.6.2
 */