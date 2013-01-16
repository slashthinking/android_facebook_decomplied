package com.facebook.orca.app;

import com.facebook.analytics.AnalyticsLogger;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.cache.SendMessageManager;
import com.facebook.orca.cache.ThreadsCache;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.database.DbClock;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.notify.OrcaNotificationManager;
import com.facebook.orca.ops.OrcaServiceOperation;

class MessagesModule$SendMessageManagerProvider extends AbstractProvider<SendMessageManager>
{
  private MessagesModule$SendMessageManagerProvider(MessagesModule paramMessagesModule)
  {
  }

  public SendMessageManager a()
  {
    return new SendMessageManager((OrcaActivityBroadcaster)b(OrcaActivityBroadcaster.class), a(OrcaServiceOperation.class, FromApplication.class), (OrcaNotificationManager)b(OrcaNotificationManager.class), (AndroidThreadUtil)b(AndroidThreadUtil.class), (ThreadsCache)b(ThreadsCache.class), (AnalyticsLogger)b(AnalyticsLogger.class), (Clock)b(DbClock.class), (Clock)b(Clock.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.SendMessageManagerProvider
 * JD-Core Version:    0.6.0
 */