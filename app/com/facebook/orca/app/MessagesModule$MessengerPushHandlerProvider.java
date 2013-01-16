package com.facebook.orca.app;

import com.facebook.analytics.ReliabilityAnalyticsLogger;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.notify.OrcaNotificationManager;
import com.facebook.orca.ops.OrcaServiceOperation;
import com.facebook.orca.push.MessengerPushHandler;

class MessagesModule$MessengerPushHandlerProvider extends AbstractProvider<MessengerPushHandler>
{
  private MessagesModule$MessengerPushHandlerProvider(MessagesModule paramMessagesModule)
  {
  }

  public MessengerPushHandler a()
  {
    return new MessengerPushHandler((DataCache)b(DataCache.class), (OrcaNotificationManager)b(OrcaNotificationManager.class), a(OrcaServiceOperation.class, FromApplication.class), (AppInitLock)b(AppInitLock.class), (ReliabilityAnalyticsLogger)b(ReliabilityAnalyticsLogger.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.MessengerPushHandlerProvider
 * JD-Core Version:    0.6.0
 */