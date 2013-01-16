package com.facebook.orca.app;

import com.facebook.orca.cache.AppConfigCache;
import com.facebook.orca.cache.CacheServiceHandler;
import com.facebook.orca.cache.ChatVisibilityCache;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.cache.DeliveredReadReceiptManager;
import com.facebook.orca.cache.SendMessageManager;
import com.facebook.orca.cache.ThreadDisplayCache;
import com.facebook.orca.cache.ThreadsCache;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.notify.OrcaNotificationManager;
import com.facebook.orca.prefs.GlobalNotificationPrefsSynchronizer;
import com.facebook.orca.prefs.ThreadNotificationPrefsSynchronizer;

class MessagesModule$CacheServiceHandlerProvider extends AbstractProvider<CacheServiceHandler>
{
  private MessagesModule$CacheServiceHandlerProvider(MessagesModule paramMessagesModule)
  {
  }

  public CacheServiceHandler a()
  {
    return new CacheServiceHandler((ThreadsCache)b(ThreadsCache.class), (DataCache)b(DataCache.class), (ThreadDisplayCache)b(ThreadDisplayCache.class), (AppConfigCache)b(AppConfigCache.class), (OrcaActivityBroadcaster)b(OrcaActivityBroadcaster.class), (OrcaNotificationManager)b(OrcaNotificationManager.class), (ThreadNotificationPrefsSynchronizer)b(ThreadNotificationPrefsSynchronizer.class), (GlobalNotificationPrefsSynchronizer)b(GlobalNotificationPrefsSynchronizer.class), (DeliveredReadReceiptManager)b(DeliveredReadReceiptManager.class), (ChatVisibilityCache)b(ChatVisibilityCache.class), (OrcaDataManager)b(OrcaDataManager.class), (SendMessageManager)b(SendMessageManager.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.CacheServiceHandlerProvider
 * JD-Core Version:    0.6.0
 */