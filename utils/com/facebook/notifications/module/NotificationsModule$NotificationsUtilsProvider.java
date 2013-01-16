package com.facebook.notifications.module;

import android.content.Context;
import com.facebook.notifications.provider.GQLNotificationsContentProviderHelper;
import com.facebook.notifications.provider.NotificationsContentProviderHelper;
import com.facebook.notifications.util.NotificationsUtils;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperationFactory;

class NotificationsModule$NotificationsUtilsProvider extends AbstractProvider<NotificationsUtils>
{
  private NotificationsModule$NotificationsUtilsProvider(NotificationsModule paramNotificationsModule)
  {
  }

  public NotificationsUtils a()
  {
    return new NotificationsUtils((Context)b(Context.class), (OrcaServiceOperationFactory)b(OrcaServiceOperationFactory.class), (NotificationsContentProviderHelper)b(NotificationsContentProviderHelper.class), (GQLNotificationsContentProviderHelper)b(GQLNotificationsContentProviderHelper.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.module.NotificationsModule.NotificationsUtilsProvider
 * JD-Core Version:    0.6.2
 */