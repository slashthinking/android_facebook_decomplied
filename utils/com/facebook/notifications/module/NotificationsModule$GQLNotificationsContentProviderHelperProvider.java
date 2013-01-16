package com.facebook.notifications.module;

import android.content.ContentResolver;
import com.facebook.ipc.notifications.GQLNotificationsContract;
import com.facebook.notifications.provider.GQLNotificationsContentProviderHelper;
import com.facebook.notifications.util.NotificationsLastUpdatedTimeUtil;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;
import com.fasterxml.jackson.databind.ObjectMapper;

class NotificationsModule$GQLNotificationsContentProviderHelperProvider extends AbstractProvider<GQLNotificationsContentProviderHelper>
{
  private NotificationsModule$GQLNotificationsContentProviderHelperProvider(NotificationsModule paramNotificationsModule)
  {
  }

  public GQLNotificationsContentProviderHelper a()
  {
    return new GQLNotificationsContentProviderHelper((GQLNotificationsContract)b(GQLNotificationsContract.class), (ContentResolver)b(ContentResolver.class, FromApplication.class), (NotificationsLastUpdatedTimeUtil)b(NotificationsLastUpdatedTimeUtil.class), (ObjectMapper)b(ObjectMapper.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.module.NotificationsModule.GQLNotificationsContentProviderHelperProvider
 * JD-Core Version:    0.6.2
 */